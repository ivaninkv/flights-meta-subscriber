package com.github.ivaninkv.fms.service;

import com.github.ivaninkv.fms.dto.CityDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CityServiceImplTest {
    private final CityService cityService = new CityServiceImpl("https://api.travelpayouts.com/data/en/cities.json");
    private final int expectedCityCount = 8890;

    @Test
    void shouldProperlyCityCount() {
        List<CityDTO> cities = cityService.getAllCities();
        Assertions.assertEquals(expectedCityCount, cities.size());
    }
}
