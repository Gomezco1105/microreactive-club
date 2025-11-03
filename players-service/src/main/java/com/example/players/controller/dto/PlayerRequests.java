package com.example.players.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class PlayerRequests {
    public record Create(@NotBlank String fullName,
                         @NotBlank String position,
                         Integer teamId) {}
    public record Update(@NotBlank String fullName,
                         @NotBlank String position,
                         Integer teamId) {}
}
