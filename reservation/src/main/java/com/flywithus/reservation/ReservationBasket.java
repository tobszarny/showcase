package com.flywithus.reservation;

import com.flywithus.flight.search.Trip;
import com.flywithus.user.User;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class ReservationBasket {
    private User user;
    private List<Trip> trips = new ArrayList<>();
    private List<ExtraService> extraServices = new ArrayList<>();
    private Payment payment;
    private BigDecimal total;

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setTotal(BigDecimal amount) {
        this.total = amount;
    }

    public BigDecimal calculateTotalAmount() {
        BigDecimal tripsPrice = BigDecimal.ZERO;
        if (trips != null) {
            tripsPrice = trips.stream().map(Trip::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        }

        BigDecimal servicesPrice = BigDecimal.ZERO;
        if (extraServices != null) {
            servicesPrice = extraServices.stream().map(ExtraService::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        }

        return tripsPrice.add(servicesPrice);
    }

    public boolean isUserRegistered() {
        return user.isRegistered();
    }
}
