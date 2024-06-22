package com.example.GetRide.Dto.Requests;

import com.example.GetRide.Enum.CabType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddCabRequest
{
    String cabNumber;
    CabType cabType;
    Double cabFarePerKm;
}
