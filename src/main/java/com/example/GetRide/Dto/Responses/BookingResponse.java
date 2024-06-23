package com.example.GetRide.Dto.Responses;

import com.example.GetRide.Enum.BookingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse
{
    BookingStatus bookingStatus;
    Date bookedAt;

    String bookingIdGenerated;//UUID
    String bookingPickUpLocation;
    String bookingDropOffLocation;
    Double bookingTotalDistance;
    Double bookingTotalFare;

    CustomerResponse customerResponse;
    DriverResponse driverResponse;
}
