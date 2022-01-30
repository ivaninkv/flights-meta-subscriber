package com.github.ivaninkv.fms.repository.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class UserContactPK implements Serializable {
    protected User user;
    protected UserContactType userContactType;
}
