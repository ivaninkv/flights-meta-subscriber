package com.github.ivaninkv.fms.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @Column(length = 3)
    private String code;

    @Column(length = 3, nullable = false)
    private String country_code;

    @Column(length = 3, nullable = false)
    private String city_code;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "en_name", length = 50)
    private String enName;

    @Column(name = "ru_name", length = 50)
    private String ruName;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
