package com.example.GetRide.Service;

import com.example.GetRide.Dto.Requests.AddBookingRequest;
import com.example.GetRide.Dto.Responses.BookingResponse;
import com.example.GetRide.Exception.CabNotAvailableException;
import com.example.GetRide.Exception.CustomerNotFoundException;
import com.example.GetRide.Model.Booking;
import com.example.GetRide.Model.Cab;
import com.example.GetRide.Model.Customer;
import com.example.GetRide.Model.Driver;
import com.example.GetRide.Repository.BookingRepository;
import com.example.GetRide.Repository.CabRepository;
import com.example.GetRide.Repository.CustomerRepository;
import com.example.GetRide.Repository.DriverRepository;
import com.example.GetRide.Transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BookingService
{
    private final JavaMailSender javaMailSender;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;

    private final Map<String, String> verificationCodes = new HashMap<>();

//    public BookingService(CustomerRepository customerRepository){
//        this.customerRepository=customerRepository; }

    public BookingResponse bookCab(AddBookingRequest bookingRequest)
    {
        Customer customer=customerRepository.findByCustomerEmailId(bookingRequest.getCustomerEmail());
        if(ObjectUtils.isEmpty(customer))
        {
            throw new CustomerNotFoundException("Invalid email-Id");
        }
        Optional<Cab> optionalCab=cabRepository.getRandomAvailableCab();
        if(optionalCab.isEmpty())
        {
            throw new CabNotAvailableException("Seems like all the drivers are busy.");
        }
        Cab cab=optionalCab.get();
        Driver driver=cab.getDriver();

        //booking entity
        Booking booking= BookingTransformer.bookingRequestToBooking(bookingRequest,cab);
        booking.setCustomer(customer);
        booking.setDriver(driver);
        Booking savedBooking=bookingRepository.save(booking);//else two booking duplicate saved

        //set remaining attributes
        customer.getBookings().add(savedBooking);//overrides
        driver.getBookings().add(savedBooking);

        //because of cascade if customer, driver saved booking will be saved
        customerRepository.save(customer);//customer+booking
        driverRepository.save(driver);//driver+booking

        sendMail(savedBooking);

        return BookingTransformer.bookingToBookingResponse(booking);
    }

    private void sendMail(Booking savedBooking)
    {
        String code = generateVerificationCode();
        verificationCodes.put(savedBooking.getDriver().getDriverEmailId(), code);
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("springtestdummy@gmail.com");

        // Send confirmation email to customer
        simpleMailMessage.setTo(savedBooking.getCustomer().getCustomerEmailId());
        simpleMailMessage.setSubject("Booking Confirmed");
        String body = "Hi " + savedBooking.getCustomer().getCustomerName() + " \n \n" + "Your ride is confirmed with booking-Id "
                +savedBooking.getBookingIdGenerated()+". The driver " +savedBooking.getDriver().getDriverName()
                +" will be arriving shortly at your location to pick you up. The OTP for the ride is "+code;
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);

        // Send confirmation email to driver
        simpleMailMessage.setTo(savedBooking.getDriver().getDriverEmailId());
        simpleMailMessage.setSubject("New booking confirmed");
        body = "Hi " + savedBooking.getDriver().getDriverName() + " \n \n" + "Your new ride is confirmed. The customer is at the location "
                +savedBooking.getBookingPickUpLocation()+" and will be dropped off at "+savedBooking.getBookingDropOffLocation()+
                " and the total price is calculated to "+savedBooking.getBookingTotalFare();
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

    private String generateVerificationCode()
    {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }

    public String otpVerification(String driverEmailId,String code)
    {
        String savedCode = verificationCodes.get(driverEmailId);
        if (savedCode != null && savedCode.equals(code))
        {
            verificationCodes.remove(driverEmailId);
            return "The OTP for the ride is successfully verified";
        }
        return "The OTP verification failed";
    }
}
