package com.github.ivaninkv.fms.convertor;

import com.github.ivaninkv.fms.dto.AirportDTO;
import com.github.ivaninkv.fms.repository.entity.Airport;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirportConvertor {
    private final ModelMapper modelMapper;

    @Autowired
    public AirportConvertor() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    public Airport toEntity(AirportDTO airportDTO) {
        return modelMapper.map(airportDTO, Airport.class);
    }

    public AirportDTO toDto(Airport airport) {
        return modelMapper.map(airport, AirportDTO.class);
    }
}
