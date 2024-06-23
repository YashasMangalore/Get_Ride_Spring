package com.example.GetRide.Service;

import com.example.GetRide.Dto.Responses.DriverResponse;
import com.example.GetRide.Model.Cab;
import com.example.GetRide.Transformer.CabTransformer;
import com.example.GetRide.Transformer.DriverTransformer;
import com.example.GetRide.Dto.Requests.AddDriverRequest;
import com.example.GetRide.Model.Driver;
import com.example.GetRide.Repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService
{
    private final DriverRepository driverRepository;

    public String addDriverAndCab(AddDriverRequest driverRequest)
    {
        Driver driver= DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab= CabTransformer.cabRequestToCab(driverRequest.getCabRequest());
        driver.setCab(cab);
        cab.setDriver(driver);

        //save both
        driverRepository.save(driver);//save both as cascading enabled
        return "The driver and cab has been registered successfully";
    }

    public DriverResponse getDriverAndCab(String mobileNumber)
    {
        Driver driver=driverRepository.findByDriverMobileNumber(mobileNumber);
        return DriverTransformer.driverToDriverResponse(driver);
    }
}
