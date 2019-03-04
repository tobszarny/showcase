package com.flywithus.flight.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AirportLocation", schema = "AIRLINE_API")
public class AirportLocation {
    @Id
    private String aitaCode;
    private String city;
    private String country;
    private String name;
}
