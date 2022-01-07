package com.github.ivaninkv.fms.job;

import com.github.ivaninkv.fms.convertor.CityConvertor;
import com.github.ivaninkv.fms.convertor.CountryConvertor;
import com.github.ivaninkv.fms.dto.CityDTO;
import com.github.ivaninkv.fms.dto.CountryDTO;
import com.github.ivaninkv.fms.repository.CityRepository;
import com.github.ivaninkv.fms.repository.CountryRepository;
import com.github.ivaninkv.fms.repository.entity.City;
import com.github.ivaninkv.fms.repository.entity.Country;
import com.github.ivaninkv.fms.service.CityService;
import com.github.ivaninkv.fms.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class GetDictionaryJob {
    private final CountryService countryService;
    private final CountryConvertor countryConvertor;
    private final CountryRepository countryRepository;
    private final CityService cityService;
    private final CityConvertor cityConvertor;
    private final CityRepository cityRepository;

    @Autowired
    public GetDictionaryJob(CountryService countryService, CountryConvertor countryConvertor, CountryRepository countryRepository, CityService cityService, CityConvertor cityConvertor, CityRepository cityRepository) {
        this.countryService = countryService;
        this.countryConvertor = countryConvertor;
        this.countryRepository = countryRepository;
        this.cityService = cityService;
        this.cityConvertor = cityConvertor;
        this.cityRepository = cityRepository;
    }

    @Scheduled(fixedRateString = "${dictionary.fixedRateString}")
    public void getAllCountry() {
        log.info("Method getAllCountry started");
        List<CountryDTO> countriesDTO = countryService.getAllCountries();
        log.info(String.format("Getting %d countries from API", countriesDTO.size()));
        List<Country> countriesEntity = countriesDTO.stream()
                .peek(CountryDTO::fillNames)
                .map(countryConvertor::toEntity)
                .collect(Collectors.toList());
        int countryQty = countryRepository.saveAll(countriesEntity).size();
        log.info(String.format("Saved %d countries to DB", countryQty));
        log.info("Method getAllCountry finished");
    }

    @Scheduled(fixedRateString = "${dictionary.fixedRateString}")
    public void getAllCity() {
        log.info("Method getAllCity started");
        List<CityDTO> citiesDTO = cityService.getAllCities();
        log.info(String.format("Getting %d cities from API", citiesDTO.size()));
        List<City> citiesEntity = citiesDTO.stream()
                .peek(CityDTO::fillNames)
                .map(cityConvertor::toEntity)
                .collect(Collectors.toList());
        int citiesQty = cityRepository.saveAll(citiesEntity).size();
        log.info(String.format("Saved %d cities to DB", citiesQty));
        log.info("Method getAllCity finished");
    }
}
