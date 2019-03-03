package com.flywithus.flight.search;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class AirportLocation {
    private String city;
    private String country;
    private String name;
    private String aitaCode;
}
