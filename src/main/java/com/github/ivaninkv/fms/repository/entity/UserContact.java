package com.github.ivaninkv.fms.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(UserContactPK.class)
@Table(name = "user_contact", schema = "public")
public class UserContact {
    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private UserContactType userContactType;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;
}
