package com.flywithus.flight.search;

import java.util.Arrays;
import java.util.List;

public interface AirportLocationDefinition {
    AirportLocation LHR = AirportLocation.builder()
            .city("London")
            .country("Great Britain")
            .name("London Heathrow Airport")
            .aitaCode("LHR")
            .build();

    AirportLocation CDG = AirportLocation.builder()
            .city("Paris")
            .country("France")
            .name("Charles de Gaulle International Airport")
            .aitaCode("CDG")
            .build();

    AirportLocation MUC = AirportLocation.builder()
            .city("Munich")
            .country("Germany")
            .name("Munich Airport")
            .aitaCode("MUC")
            .build();

    AirportLocation FRA = AirportLocation.builder()
            .city("Frankfurt")
            .country("Germany")
            .name("Frankfurt am Main Airport")
            .aitaCode("FRA")
            .build();

    AirportLocation WAW = AirportLocation.builder()
            .city("Warsaw")
            .country("Poland")
            .name("Warsaw Chopin Airport")
            .aitaCode("WAW")
            .build();

    List<AirportLocation> INTERNATIONAL_TRANSIT_AIRPORTS = Arrays.asList(LHR, CDG, MUC, FRA, WAW);
}
