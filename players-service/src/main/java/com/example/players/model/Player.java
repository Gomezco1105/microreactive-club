package com.example.players.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("players")
public record Player(
        @Id Integer id,
        String fullName,
        String position,
        Integer teamId
) {}
