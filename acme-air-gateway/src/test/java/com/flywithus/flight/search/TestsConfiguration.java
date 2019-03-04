package com.flywithus.flight.search;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource({
        "classpath:application-test.properties"
})
@AutoConfigureDataJpa
@ComponentScan("com.flywithus.flight.search")
@EnableJpaRepositories("com.flywithus.flight.search")
@EntityScan("com.flywithus.flight.search")
public class TestsConfiguration {
//    @PersistenceContext
//    private EntityManager entityManager;
}
