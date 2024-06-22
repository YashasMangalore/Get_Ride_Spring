package com.example.GetRide.Service;

import com.example.GetRide.Model.Coupon;
import com.example.GetRide.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService
{
    @Autowired
    private CouponRepository couponRepository;

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
