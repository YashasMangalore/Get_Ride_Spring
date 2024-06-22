package com.example.GetRide.Controller;

import com.example.GetRide.Dto.Requests.AddDriverRequest;
import com.example.GetRide.Dto.Responses.DriverResponse;
import com.example.GetRide.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
public class DriverController
{
    @Autowired
    DriverService driverService;

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
}
