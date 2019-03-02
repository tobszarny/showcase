package com.flywithus.payment;

import lombok.Builder;
import lombok.Getter;

/**
 * Payment operator response with web interface url for completing the payment
 *
 * @author Tomasz Obszarny
 **/
@Builder
@Getter
public class MerchantOrderResponse {
    private String operatorWebInterfaceUrl;
    private String transactionId;
}
