package com.example.arch.ddd.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BoardEntity {

    @Id
    private Long id;
}
