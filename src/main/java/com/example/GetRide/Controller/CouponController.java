package com.example.GetRide.Controller;

import com.example.GetRide.Service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupon")
public class CouponController
{
    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestParam("code") String couponCode,
                                    @RequestParam("discount") int percentageDiscount)//if not mandatory then "code",required=false)
    {
        String response=couponService.addCoupon(couponCode,percentageDiscount);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
