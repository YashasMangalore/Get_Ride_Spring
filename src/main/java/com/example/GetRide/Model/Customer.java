package com.example.GetRide.Model;

import com.example.GetRide.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerId;
    @Column(unique = true,nullable = false)
    String customerEmailId;
    @Column(unique = true,nullable = false)
    String customerMobileNumber;
    @Enumerated(EnumType.STRING)
    Gender customerGender;

    String customerName;
    Integer customerAge;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Booking> bookings=new ArrayList<>();
}
