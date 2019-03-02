package com.flywithus.payment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

public class MockupPaymentServiceTest {

    private MockupPaymentService service;

    @Before
    public void setUp() {
        service = new MockupPaymentService();
    }

    @Test
    public void orderPayment_returns_response() {
        MerchantOrderResponse merchantOrderResponse = service.orderPayment(new BigDecimal("10.50"));
        Assert.assertThat(merchantOrderResponse, not(nullValue()));
    }

    @Test
    public void confirmPayment_returns_response_order_unknown() {
        MerchantConfirmationResponse merchantConfirmationResponse = service.confirmPayment("testTrxId");
        Assert.assertThat(merchantConfirmationResponse, not(nullValue()));
        Assert.assertThat(merchantConfirmationResponse.getStatus(), is(equalTo(ConfirmationStatus.UNKNOWN)));
    }

    @Test
    public void confirmPayment_response_order_known() {
        MerchantOrderResponse merchantOrderResponse = service.orderPayment(new BigDecimal("8.75"));
        MerchantConfirmationResponse merchantConfirmationResponse = service.confirmPayment(merchantOrderResponse.getTransactionId());
        Assert.assertThat(merchantConfirmationResponse, not(nullValue()));
        Assert.assertThat(merchantConfirmationResponse.getStatus(), is(not(equalTo(ConfirmationStatus.UNKNOWN))));
    }

    @Test
    public void nextInt_in_range() {
        int actual = service.nextInt(2, 4);
        Assert.assertThat(actual, is(greaterThanOrEqualTo(2)));
        Assert.assertThat(actual, is(lessThan(4)));

    }

    @Test
    public void nextInt_exactly2() {
        int actual = service.nextInt(2, 3);
        Assert.assertThat(actual, is(equalTo(2)));

    }
}