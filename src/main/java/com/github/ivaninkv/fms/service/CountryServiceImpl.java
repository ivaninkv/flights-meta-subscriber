package com.github.ivaninkv.fms.service;

import com.github.ivaninkv.fms.dto.CountryDTO;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private String countryURL = "https://api.travelpayouts.com/data/en/countries.json";

    @Autowired
    public CountryServiceImpl() {
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        List<CountryDTO> countries = Unirest.get(countryURL)
                .asObject(new GenericType<List<CountryDTO>>() {
                }).getBody();

        return countries;
    }
}
