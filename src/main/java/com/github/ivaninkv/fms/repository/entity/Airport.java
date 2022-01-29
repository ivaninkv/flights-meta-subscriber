package com.github.ivaninkv.fms.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "airport", schema = "public")
public class Airport {
    @Id
    @Column(length = 3)
    private String code;

    @ManyToOne
    private Country country;

    @ManyToOne
    private City city;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "en_name", length = 50)
    private String enName;

    @Column(name = "ru_name", length = 50)
    private String ruName;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}
