package com.flywithus.reservation;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class FastCheckoutService implements ExtraService {
    private static final BigDecimal PRICE = BigDecimal.valueOf(50.00f);
    private BigDecimal price = PRICE;
}
