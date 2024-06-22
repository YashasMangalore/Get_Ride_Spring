package com.example.GetRide.Dto.Requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddDriverRequest
{
    String driverName;
    Integer driverAge;
    String driverMobileNumber;
    String driverLicense;
    AddCabRequest cabRequest;
}
