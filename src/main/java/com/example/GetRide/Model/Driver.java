package com.example.GetRide.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="driver")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer driverId;
    @Column(unique = true,nullable = false)
    String driverMobileNumber;
    @Column(unique = true,nullable = false)
    String driverLicense;

    String driverName;
    Integer driverAge;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<Booking> bookings=new ArrayList<>();
}
