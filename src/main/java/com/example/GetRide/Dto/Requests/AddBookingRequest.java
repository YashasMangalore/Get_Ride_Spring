package com.example.GetRide.Dto.Requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddBookingRequest
{
    String bookingPickUpLocation;
    String bookingDropOffLocation;
    Double bookingTotalDistance;
    String customerEmail;
}
