package com.example.GetRide.Model;

import com.example.GetRide.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name="booking")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookingId;
    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;
    @CreationTimestamp
    Date bookedAt;

    String bookingIdGenerated;
    String bookingPickUpLocation;
    String bookingDropOffLocation;
    Double bookingTotalDistance;
    Double bookingTotalFare;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;
}
