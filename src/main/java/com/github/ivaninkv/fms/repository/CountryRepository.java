package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findAllByIsActiveTrue();

    List<Country> findAllByIsActiveFalse();
}
