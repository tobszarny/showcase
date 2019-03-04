package com.flywithus.reservation;

import com.flywithus.reservation.discount.DiscountCalculator;
import com.flywithus.reservation.discount.RegisteredUserDiscountRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationConfiguration {

    @Bean
    public DiscountCalculator discountCalculator() {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addDiscountRule(new RegisteredUserDiscountRule());

        return discountCalculator;
    }
}
