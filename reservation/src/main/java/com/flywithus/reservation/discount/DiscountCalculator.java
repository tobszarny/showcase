package com.flywithus.reservation.discount;

import com.flywithus.reservation.ReservationBasket;

import java.util.LinkedList;

public class DiscountCalculator {
    private LinkedList<AbstractDiscountRule> discountRules = new LinkedList<>();

    public void calculateDiscount(ReservationBasket basket) {
        discountRules.peekFirst().applyDiscount(basket);
    }

    public void addDiscountRule(AbstractDiscountRule rule) {
        AbstractDiscountRule last = discountRules.peekLast();
        if (last == null) {
            discountRules.add(rule);
        } else {
            last.setNextRule(rule);
            discountRules.add(rule);
        }
    }
}
