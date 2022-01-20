package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByIsActiveTrue();

    List<User> findAllByIsActiveFase();
}
