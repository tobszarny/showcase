package com.flywithus.reservation;

import com.flywithus.flight.search.Trip;
import com.flywithus.user.User;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        BigDecimal tripsPrice = trips.stream().map(Trip::getPrice).reduce(BigDecimal::add).get();
        BigDecimal servicesPrice = extraServices.stream().map(ExtraService::getPrice).reduce(BigDecimal::add).get();

        return tripsPrice.add(servicesPrice);
    }

    public boolean isUserRegistered() {
        return user.isRegistered();
    }
}
