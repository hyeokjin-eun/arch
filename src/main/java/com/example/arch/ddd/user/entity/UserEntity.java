package com.example.arch.ddd.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

    @Id
    private Long id;
}
