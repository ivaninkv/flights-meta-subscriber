package com.github.ivaninkv.fms.service;

import com.github.ivaninkv.fms.dto.AirportDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Unit-test for getting airports from API")
class AirportServiceImplTest {
    private final AirportService airportService = new AirportServiceImpl("https://api.travelpayouts.com/data/en/airports.json");
    private final int minExpectedAirportCount = 1000;

    @Test
    void shouldAirportsNotEmpty() {
        List<AirportDTO> airports = airportService.getAllAirports();
        Assertions.assertNotNull(airports);
        Assertions.assertFalse(airports.isEmpty());
    }

    @Test
    void shouldProperlyAirportCount() {
        List<AirportDTO> airports = airportService.getAllAirports();
        Assertions.assertNotNull(airports);
        Assertions.assertTrue(airports.size() > minExpectedAirportCount);
    }
}
