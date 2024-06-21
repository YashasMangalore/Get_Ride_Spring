package com.example.GetRide.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name="coupon")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Coupon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer couponId;

    String couponCode;
    Integer couponPercentageDiscount;
}
