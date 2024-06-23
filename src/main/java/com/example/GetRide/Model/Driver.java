package com.example.GetRide.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    String driverEmailId;
    @Column(unique = true,nullable = false)
    String driverLicense;

    String driverName;
    Integer driverAge;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<Booking> bookings=new ArrayList<>();
}
