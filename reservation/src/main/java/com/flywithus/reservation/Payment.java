package com.flywithus.reservation;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class Payment {
    private String transactionId;
    private BigDecimal amount;

}