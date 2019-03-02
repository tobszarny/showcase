package com.flywithus.payment;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import static com.flywithus.core.Profile.SANDBOX;

@Service
@Profile(SANDBOX)
public class MockupPaymentService implements PaymentGateway {

    public static final String HTTP_MOCKUP_MERCHANT_WEB_ENDPOINT = "http://mockup.merchant.com/";
    private long randomSalt = System.currentTimeMillis();
    private Random random = new Random(randomSalt);

    private Set<String> pendingTransactionIds = new HashSet<>();

    @Override
    public MerchantOrderResponse orderPayment(BigDecimal amount) {
        MerchantOrderResponse merchantOrderResponse = MerchantOrderResponse.builder()
                .operatorWebInterfaceUrl(HTTP_MOCKUP_MERCHANT_WEB_ENDPOINT)
                .transactionId(generateTransactionId())
                .build();

        pendingTransactionIds.add(merchantOrderResponse.getTransactionId());
        return merchantOrderResponse;
    }

    @Override
    public MerchantConfirmationResponse confirmPayment(String transactionId) {
        return MerchantConfirmationResponse.builder()
                .status(generateStatus(transactionId))
                .transactionId(transactionId)
                .build();
    }

    private ConfirmationStatus generateStatus(String transactionId) {
        if (!pendingTransactionIds.contains(transactionId)) {
            return ConfirmationStatus.UNKNOWN;
        }
        return ConfirmationStatus.values()[nextInt(1, ConfirmationStatus.values().length)];
    }

    int nextInt(int from, int to) {
        return from + (Math.abs(random.nextInt()) % (to - from));
    }

    private String generateTransactionId() {
        String stringUUID;
        do {
            stringUUID = UUID.randomUUID().toString();
        } while (pendingTransactionIds.contains(stringUUID));
        return stringUUID;
    }
}
