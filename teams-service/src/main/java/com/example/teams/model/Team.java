package com.example.teams.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("teams")
public record Team(
        @Id Integer id,
        String name,
        String city
) {}
