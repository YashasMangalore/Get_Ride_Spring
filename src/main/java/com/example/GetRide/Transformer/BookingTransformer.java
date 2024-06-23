package com.example.GetRide.Transformer;

import com.example.GetRide.Dto.Requests.AddBookingRequest;
import com.example.GetRide.Dto.Responses.BookingResponse;
import com.example.GetRide.Enum.BookingStatus;
import com.example.GetRide.Model.Booking;
import com.example.GetRide.Model.Cab;

import java.util.Date;
import java.util.UUID;

public class BookingTransformer
{
    public static Booking bookingRequestToBooking(AddBookingRequest bookingRequest, Cab cab)
    {
        return Booking.builder()
                .bookingIdGenerated(String.valueOf(UUID.randomUUID()))
                .bookingPickUpLocation(bookingRequest.getBookingPickUpLocation())
                .bookingDropOffLocation(bookingRequest.getBookingDropOffLocation())
                .bookingStatus(BookingStatus.CONFIRMED)
                .bookingTotalDistance(bookingRequest.getBookingTotalDistance())
                .bookingTotalFare(bookingRequest.getBookingTotalDistance()* cab.getCabFarePerKm())
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking)
    {
        return BookingResponse.builder()
                .bookingIdGenerated(booking.getBookingIdGenerated())
                .bookingPickUpLocation(booking.getBookingPickUpLocation())
                .bookingDropOffLocation(booking.getBookingDropOffLocation())
                .bookingStatus(booking.getBookingStatus())
                .bookingTotalFare(booking.getBookingTotalFare())
                .bookingTotalDistance(booking.getBookingTotalDistance())
                .customerResponse(CustomerTransformer.customerToCustomerResponse(booking.getCustomer()))
                .driverResponse(DriverTransformer.driverToDriverResponse(booking.getDriver()))
                .bookedAt(booking.getBookedAt())
                .build();
    }
}
