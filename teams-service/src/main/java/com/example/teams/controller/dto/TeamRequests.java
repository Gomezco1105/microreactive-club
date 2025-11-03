package com.example.teams.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class TeamRequests {
    public record Create(@NotBlank String name, @NotBlank String city) {}
    public record Update(@NotBlank String name, @NotBlank String city) {}
}
