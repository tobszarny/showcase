package com.flywithus.payment;

import lombok.Builder;
import lombok.Getter;

/**
 * Operators response for payment confirmation request
 *
 * @author Tomasz Obszarny
 */
@Builder
@Getter
public class MerchantConfirmationResponse {
    private String transactionId;
    private ConfirmationStatus status;
}
