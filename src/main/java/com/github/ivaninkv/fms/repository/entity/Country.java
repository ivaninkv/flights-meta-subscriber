package com.github.ivaninkv.fms.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "code", length = 3)
    private String code;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "currency", length = 3)
    private String currency;

    @Column(name = "en_name", length = 50)
    private String enName;

    @Column(name = "ru_name", length = 50)
    private String ruName;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
