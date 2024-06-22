package com.example.GetRide.Dto.Responses;

import com.example.GetRide.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CustomerResponse
{
    String customerName;
    Integer customerAge;
    Gender customerGender;
    String customerEmailId;
    String customerMobileNumber;
}
