package com.github.ivaninkv.fms.convertor;

import com.github.ivaninkv.fms.dto.CityDTO;
import com.github.ivaninkv.fms.repository.entity.City;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityConvertor {
    private final ModelMapper modelMapper;

    @Autowired
    public CityConvertor() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    public City toEntity(CityDTO cityDTO) {
        return modelMapper.map(cityDTO, City.class);
    }

    public CityDTO toDto(City city) {
        return modelMapper.map(city, CityDTO.class);
    }
}
