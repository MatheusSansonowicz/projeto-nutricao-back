package com.example.projetonutricaoback.security.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
    @NotBlank @Email String login,
    @NotBlank String password,
    @NotBlank String nome,
    @NotNull UserRole role
) {}