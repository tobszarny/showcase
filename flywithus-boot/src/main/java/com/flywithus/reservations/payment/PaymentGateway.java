package com.flywithus.reservations.payment;

import java.math.BigDecimal;

/**
 * Payment operator endpoint wrapper API for merchants use
 *
 * @author Tomasz Obszarny
 */
public interface PaymentGateway {
    /**
     * Operator order payment merchant endpoint wrapper
     *
     * @return MerchantOrderResponse order response
     */
    MerchantOrderResponse orderPayment(BigDecimal amount);

    /**
     * Operator payment confirmation merchant endpoint wrapper
     *
     * @return MerchantConfirmationResponse confirmation response
     */
    MerchantConfirmationResponse confirmPayment(String transactionId);

}
