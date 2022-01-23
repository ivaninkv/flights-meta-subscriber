package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.City;
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
@DisplayName("Integrated test for City Repository")
class CityRepositoryTest {
    @Autowired
    private CityRepository cityRepository;

    @Sql(scripts = {"/sql/ClearCity.sql", "/sql/InsertCity.sql"})
    @Test
    public void shouldProperlyActiveCityCount() {
        List<City> cities = cityRepository.findAllByIsActiveTrue();
        Assertions.assertNotNull(cities);
        Assertions.assertEquals(5, cities.size());
    }

    @Sql(scripts = {"/sql/ClearCity.sql", "/sql/InsertCity.sql"})
    @Test
    public void shouldProperlyInActiveCityCount() {
        List<City> cities = cityRepository.findAllByIsActiveFalse();
        Assertions.assertNotNull(cities);
        Assertions.assertEquals(1, cities.size());
    }
}
