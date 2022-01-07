package com.github.ivaninkv.fms.service;

import com.github.ivaninkv.fms.dto.CountryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Unit-test for getting countries from API")
class CountryServiceTest {
    private final CountryService countryService = new CountryServiceImpl("https://api.travelpayouts.com/data/en/countries.json");
    private final int expectedCountryCount = 251;

    @Test
    void shouldCitiesNotEmpty() {
        List<CountryDTO> countries = countryService.getAllCountries();
        Assertions.assertNotNull(countries);
        Assertions.assertFalse(countries.isEmpty());
    }

    @Test
    void shouldProperlyCountryCount() {
        List<CountryDTO> countries = countryService.getAllCountries();
        Assertions.assertNotNull(countries);
        Assertions.assertEquals(expectedCountryCount, countries.size());
    }
}
