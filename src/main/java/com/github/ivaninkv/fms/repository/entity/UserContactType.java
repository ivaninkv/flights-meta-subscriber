package com.github.ivaninkv.fms.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_contact_type", schema = "public")
public class UserContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;
}
