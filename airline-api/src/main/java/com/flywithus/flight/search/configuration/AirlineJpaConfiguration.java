package com.flywithus.flight.search.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaRepositories("com.flywithus.flight.search")
@EntityScan("com.flywithus.flight.search")
public class AirlineJpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

}
