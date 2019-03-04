package com.flywithus.reservation.discount;

public class RegisteredUserDiscountRule implements DiscountRule {

    @Override
    public void applyDiscount() {

    }

    @Override
    public DiscountRule nextRule() {
        return null;
    }
}
