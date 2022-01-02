package com.github.ivaninkv.fms.job;

import com.github.ivaninkv.fms.convertor.CountryConvertor;
import com.github.ivaninkv.fms.dto.CountryDTO;
import com.github.ivaninkv.fms.repository.CountryRepository;
import com.github.ivaninkv.fms.repository.entity.Country;
import com.github.ivaninkv.fms.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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

    @Scheduled(fixedRateString = "${dictionary.fixedRateString}")
    public void getAllCountry() {
        log.info("Method getAllCountry started");
        List<CountryDTO> countriesDTO = countryService.getAllCountries();
        log.info(String.format("Getting %d records from API", countriesDTO.size()));
        List<Country> countriesEntity = countriesDTO.stream()
                .peek(CountryDTO::fillNames)
                .map(countryConvertor::toEntity)
                .collect(Collectors.toList());
        log.info(String.format("Saved %d records to DB", countryRepository.saveAll(countriesEntity).size()));
        log.info("Method getAllCountry finished");
    }
}
