package com.example.GetRide.Transformer;

import com.example.GetRide.Dto.Requests.AddDriverRequest;
import com.example.GetRide.Dto.Responses.DriverResponse;
import com.example.GetRide.Model.Driver;

public class DriverTransformer
{
    public static Driver driverRequestToDriver(AddDriverRequest driverRequest)
    {
        return Driver.builder()
                .driverName(driverRequest.getDriverName())
                .driverAge(driverRequest.getDriverAge())
                .driverMobileNumber(driverRequest.getDriverMobileNumber())
                .driverLicense(driverRequest.getDriverLicense())
                .driverEmailId(driverRequest.getDriverEmailId())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver)
    {
        return DriverResponse.builder()
                .driverName(driver.getDriverName())
                .driverAge(driver.getDriverAge())
                .driverLicense(driver.getDriverLicense())
                .driverMobileNumber(driver.getDriverMobileNumber())
                .bookings(driver.getBookings())
                .cab(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
