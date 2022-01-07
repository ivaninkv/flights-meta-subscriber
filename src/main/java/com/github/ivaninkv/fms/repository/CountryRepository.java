package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findAllByIsActiveTrue();

    List<Country> findAllByIsActiveFalse();
}
