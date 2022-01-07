package com.github.ivaninkv.fms.service;

import com.github.ivaninkv.fms.dto.CountryDTO;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final String countryURL;

    @Autowired
    public CountryServiceImpl(@Value("${dictionary.countryURL}") String countryURL) {
        this.countryURL = countryURL;
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        List<CountryDTO> countries = Unirest.get(countryURL)
                .asObject(new GenericType<List<CountryDTO>>() {
                }).getBody();

        return countries;
    }
}
