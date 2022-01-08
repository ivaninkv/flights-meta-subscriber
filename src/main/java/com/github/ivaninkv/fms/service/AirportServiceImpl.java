package com.github.ivaninkv.fms.service;

import com.github.ivaninkv.fms.dto.AirportDTO;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {
    private final String airportURL;

    @Autowired
    public AirportServiceImpl(@Value("${dictionary.airportURL}") String airportURL) {
        this.airportURL = airportURL;
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        List<AirportDTO> airports = Unirest.get(airportURL)
                .asObject(new GenericType<List<AirportDTO>>() {
                }).getBody();

        return airports;
    }
}
