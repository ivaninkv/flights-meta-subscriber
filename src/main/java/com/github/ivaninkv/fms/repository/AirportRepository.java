package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface AirportRepository extends JpaRepository<Airport, String> {
    List<Airport> findAllByIsActiveTrue();

    List<Airport> findAllByIsActiveFalse();
}
