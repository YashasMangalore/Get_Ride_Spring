package com.example.GetRide.Dto.Requests;

import com.example.GetRide.Enum.Gender;
import lombok.Data;

@Data
public class AddCustomerRequest
{
    private String customerName;
    private Integer customerAge;
    private String customerEmailId;
    private String customerMobileNumber;
    private Gender customerGender;

}
