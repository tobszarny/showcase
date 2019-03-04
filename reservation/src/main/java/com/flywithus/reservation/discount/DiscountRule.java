package com.flywithus.reservation.discount;

public interface DiscountRule {
    void applyDiscount();

    DiscountRule nextRule();
}
