package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByIsActiveTrue();

    List<User> findAllByIsActiveFalse();
}
