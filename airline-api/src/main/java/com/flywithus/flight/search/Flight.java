package com.flywithus.flight.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Flight", schema = "AIRLINE_API")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightNumber;
    private String operator;
    @ManyToOne
    private AirportLocation departureLocation;
    private LocalDateTime departureTime;
    @ManyToOne
    private AirportLocation destinationLocation;
    private LocalDateTime arrivalTime;
    private int passengersCount;
}
