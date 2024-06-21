package com.example.GetRide.Dto.Responses;

import com.example.GetRide.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse
{
    private String customerName;
    private Integer customerAge;
    private Gender customerGender;
    private String customerEmailId;
    private String customerMobileNumber;
}
