package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@DisplayName("Integrated test for Airport Repository")
class AirportRepositoryTest {
    @Autowired
    private AirportRepository airportRepository;

    @Sql(scripts = {"/sql/ClearAirport.sql",
            "/sql/ClearCity.sql",
            "/sql/InsertCity.sql",
            "/sql/InsertAirport.sql"})
    @Test
    public void shouldProperlyActiveAirportCount() {
        List<Airport> airports = airportRepository.findAllByIsActiveTrue();
        Assertions.assertEquals(5, airports.size());
    }

    @Sql(scripts = {"/sql/ClearAirport.sql",
            "/sql/ClearCity.sql",
            "/sql/InsertCity.sql",
            "/sql/InsertAirport.sql"})
    @Test
    public void shouldProperlyInActiveAirportCount() {
        List<Airport> airports = airportRepository.findAllByIsActiveFalse();
        Assertions.assertEquals(1, airports.size());
    }
}
