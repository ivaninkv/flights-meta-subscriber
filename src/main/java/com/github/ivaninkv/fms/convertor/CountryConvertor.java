package com.github.ivaninkv.fms.convertor;

import com.github.ivaninkv.fms.dto.CountryDTO;
import com.github.ivaninkv.fms.repository.entity.Country;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryConvertor {
    private final ModelMapper modelMapper;

    @Autowired
    public CountryConvertor() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    public Country toEntity(CountryDTO countryDTO) {
        return modelMapper.map(countryDTO, Country.class);
    }

    public CountryDTO toDto(Country country) {
        return modelMapper.map(country, CountryDTO.class);
    }
}
