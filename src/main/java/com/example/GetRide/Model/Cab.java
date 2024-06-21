package com.example.GetRide.Model;

import com.example.GetRide.Enum.CabType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Table(name="cab")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cab
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cabId;
    @Column(unique = true,nullable = false)
    String cabNumber;

    CabType cabType;
    Double cabFarePerKm;
    Boolean cabIsBooked;

    @OneToOne
    @JoinColumn
    Driver driver;
}
