package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.Country;
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
@DisplayName("Integrated test for Country Repository")
class CountryRepositoryTest {
    @Autowired
    private CountryRepository countryRepository;

    @Sql(scripts = {"/sql/ClearCountry.sql", "/sql/InsertCountry.sql"})
    @Test
    public void shouldProperlyActiveCountryCount() {
        List<Country> countries = countryRepository.findAllByIsActiveTrue();
        Assertions.assertEquals(5, countries.size());
    }

    @Sql(scripts = {"/sql/ClearCountry.sql", "/sql/InsertCountry.sql"})
    @Test
    public void shouldProperlyInActiveCountryCount() {
        List<Country> countries = countryRepository.findAllByIsActiveFalse();
        Assertions.assertEquals(1, countries.size());
    }
}
