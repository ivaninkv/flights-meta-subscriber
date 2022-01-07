package com.github.ivaninkv.fms.service;

import com.github.ivaninkv.fms.dto.CityDTO;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final String cityURL;

    @Autowired
    public CityServiceImpl(@Value("${dictionary.cityURL}") String cityURL) {
        this.cityURL = cityURL;
    }

    @Override
    public List<CityDTO> getAllCities() {
        List<CityDTO> cities = Unirest.get(cityURL)
                .asObject(new GenericType<List<CityDTO>>() {
                }).getBody();

        return cities;
    }
}
