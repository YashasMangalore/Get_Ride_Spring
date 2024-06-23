package com.example.GetRide.Controller;

import com.example.GetRide.Dto.Requests.AddDriverRequest;
import com.example.GetRide.Dto.Responses.DriverResponse;
import com.example.GetRide.Service.BookingService;
import com.example.GetRide.Service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/driver")
public class DriverController
{
    private final DriverService driverService;
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> addDriverAndCab(@RequestBody AddDriverRequest driverRequest)//normally separate but to show cascading written together
    {
        String response=driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<DriverResponse> getDriverAndCab(@RequestParam("mobile number") String mobileNumber)
    {
        DriverResponse response=driverService.getDriverAndCab(mobileNumber);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> otpVerification(@RequestParam("email") String email,@RequestParam("otp") String code)
    {
        String response=bookingService.otpVerification(email,code);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}