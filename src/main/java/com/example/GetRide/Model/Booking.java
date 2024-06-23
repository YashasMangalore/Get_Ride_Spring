package com.example.GetRide.Model;

import com.example.GetRide.Enum.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    String bookingIdGenerated;//UUID
    String bookingPickUpLocation;
    String bookingDropOffLocation;
    Double bookingTotalDistance;
    Double bookingTotalFare;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
