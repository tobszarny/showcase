package com.flywithus.reservation.discount;

import com.flywithus.reservation.ReservationBasket;

public abstract class AbstractDiscountRule {

    protected AbstractDiscountRule nextRule;


    public void applyDiscount(ReservationBasket basket) {
        if (isApplicable(basket)) {
            apply(basket);
        } else {
            if (nextRule != null) {
                nextRule.applyDiscount(basket);
            }
        }
    }

    protected abstract boolean isApplicable(ReservationBasket basket);


    abstract public void apply(ReservationBasket basket);

    public AbstractDiscountRule getNextRule() {
        return null;
    }

    public void setNextRule(AbstractDiscountRule rule) {
        this.nextRule = rule;
    }
}
