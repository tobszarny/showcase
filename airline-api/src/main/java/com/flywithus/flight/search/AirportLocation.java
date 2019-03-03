package com.flywithus.flight.search;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AirportLocation {
    private String city;
    private String country;
    private String name;
    private String aitaCode;
}
