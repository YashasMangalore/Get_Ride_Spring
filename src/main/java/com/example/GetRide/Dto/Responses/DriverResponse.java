package com.example.GetRide.Dto.Responses;

import com.example.GetRide.Model.Booking;
import com.example.GetRide.Model.Cab;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class DriverResponse
{
    String driverName;
    Integer driverAge;
    String driverMobileNumber;
    String driverLicense;
    CabResponse cab;
    List<Booking> bookings=new ArrayList<>();
}
