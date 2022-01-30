package com.github.ivaninkv.fms.repository;

import com.github.ivaninkv.fms.repository.entity.UserContact;
import com.github.ivaninkv.fms.repository.entity.UserContactPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface UserContactRepository extends JpaRepository<UserContact, UserContactPK> {
    List<UserContact> findAllByIsActiveTrue();

    List<UserContact> findAllByIsActiveFalse();
}
