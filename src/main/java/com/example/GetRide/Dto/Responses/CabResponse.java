package com.example.GetRide.Dto.Responses;

import com.example.GetRide.Enum.CabType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabResponse
{
    String cabNumber;
    CabType cabType;
    Double cabFarePerKm;
    Boolean cabIsBooked;
}
