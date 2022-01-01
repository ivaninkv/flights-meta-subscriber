package com.github.ivaninkv.fms.job;

import com.github.ivaninkv.fms.dto.Country;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCountryJob {
    private String countryURL = "https://api.travelpayouts.com/data/en/countries.json";

    @Autowired
    public GetAllCountryJob() {
    }

    @Scheduled(fixedRateString = "60000")
    public void getAllCountry() {
        List<Country> countries = Unirest.get(countryURL)
                .asObject(new GenericType<List<Country>>() {
                }).getBody();

        System.out.println(String.format("Size of countries: %s", countries.size()));
        Country zeroCountry = countries.get(0);
        System.out.println(zeroCountry);
        zeroCountry.fillNames();
        System.out.println(zeroCountry);
    }
}
