package com.flywithus.flight.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Trip", schema = "airline_api")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Flight> flightsToDestination;

    @OneToMany
    private List<Flight> returningFlights;

    private BigDecimal price;
    private String currency;
    private int passengersCount;
}
