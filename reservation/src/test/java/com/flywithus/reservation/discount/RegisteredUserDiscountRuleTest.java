package com.flywithus.reservation.discount;

import com.flywithus.flight.search.Trip;
import com.flywithus.reservation.ReservationBasket;
import com.flywithus.user.User;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RegisteredUserDiscountRuleTest {

    RegisteredUserDiscountRule registeredUserDiscountRule = new RegisteredUserDiscountRule();

    @Test
    public void apply_registered_user() {
        User user = User.builder().registered(true).build();
        ReservationBasket basket = ReservationBasket.builder()
                .user(user)
                .extraServices(new ArrayList<>())
                .trips(Arrays.asList(Trip.builder().price(BigDecimal.TEN).build()))
                .build();

        registeredUserDiscountRule.applyDiscount(basket);

        Assert.assertThat(basket.getTotal().setScale(2), is(equalTo(BigDecimal.valueOf(9.50f).setScale(2))));
    }

    @Test
    public void apply_not_registered_user() {
        User user = User.builder().registered(false).build();
        ReservationBasket basket = ReservationBasket.builder()
                .user(user)
                .extraServices(new ArrayList<>())
                .trips(Arrays.asList(Trip.builder().price(BigDecimal.TEN).build()))
                .build();

        registeredUserDiscountRule.applyDiscount(basket);

        Assert.assertThat(basket.getTotal(), is(equalTo(BigDecimal.TEN.setScale(2))));
    }
}