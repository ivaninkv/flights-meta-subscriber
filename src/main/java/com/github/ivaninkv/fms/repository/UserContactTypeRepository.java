package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.UserContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface UserContactTypeRepository extends JpaRepository<UserContactType, Integer> {
    List<UserContactType> findAllByIsActiveTrue();

    List<UserContactType> findAllByIsActiveFalse();
}
