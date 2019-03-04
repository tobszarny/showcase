package com.flywithus.reservation.discount;

import com.flywithus.reservation.ReservationBasket;

import java.math.BigDecimal;

public class RegisteredUserDiscountRule extends AbstractDiscountRule {

    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.05);

    @Override
    protected boolean isApplicable(ReservationBasket basket) {
        return basket.isUserRegistered();
    }

    @Override
    public void apply(ReservationBasket basket) {
        BigDecimal add = basket.calculateTotalAmount();
        BigDecimal amount = add.multiply(BigDecimal.ONE.subtract(DISCOUNT));
        basket.setTotal(amount);
    }


}
