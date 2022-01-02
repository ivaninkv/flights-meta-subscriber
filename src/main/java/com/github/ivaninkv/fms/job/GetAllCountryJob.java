package com.github.ivaninkv.fms.job;

import com.github.ivaninkv.fms.convertor.CountryConvertor;
import com.github.ivaninkv.fms.dto.CountryDTO;
import com.github.ivaninkv.fms.repository.CountryRepository;
import com.github.ivaninkv.fms.repository.entity.Country;
import com.github.ivaninkv.fms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllCountryJob {
    private CountryService countryService;
    private CountryConvertor countryConvertor;
    private CountryRepository countryRepository;

    @Autowired
    public GetAllCountryJob(CountryService countryService, CountryConvertor countryConvertor, CountryRepository countryRepository) {
        this.countryService = countryService;
        this.countryConvertor = countryConvertor;
        this.countryRepository = countryRepository;
    }

    @Scheduled(fixedRateString = "60000")
    public void getAllCountry() {
        List<CountryDTO> countriesDTO = countryService.getAllCountries();
        List<Country> countriesEntity = countriesDTO.stream()
                .peek(CountryDTO::fillNames)
                .map(countryConvertor::convertToEntity)
                .collect(Collectors.toList());
        countryRepository.saveAll(countriesEntity);
    }
}
