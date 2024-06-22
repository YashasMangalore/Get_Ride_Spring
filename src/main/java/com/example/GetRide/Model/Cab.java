package com.example.GetRide.Model;

import com.example.GetRide.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @JsonIgnore
    Driver driver;
}
