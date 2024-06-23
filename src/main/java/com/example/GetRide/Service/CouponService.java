package com.example.GetRide.Service;

import com.example.GetRide.Model.Coupon;
import com.example.GetRide.Repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService
{
    private final CouponRepository couponRepository;

    public String addCoupon(String couponCode, int percentageDiscount)
    {
        Coupon coupon=Coupon.builder()
                .couponCode(couponCode)
                .couponPercentageDiscount(percentageDiscount)
                .build();
        couponRepository.save(coupon);
        return "The coupon has been successfully saved";
    }
}
