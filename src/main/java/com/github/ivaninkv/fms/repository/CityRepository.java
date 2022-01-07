package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
    List<City> findAllByIsActiveTrue();

    List<City> findAllByIsActiveFalse();
}
