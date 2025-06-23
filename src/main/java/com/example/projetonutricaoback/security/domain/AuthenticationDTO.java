package com.example.projetonutricaoback.security.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String login,
    
    @NotBlank(message = "Senha é obrigatória")
    String password
) {}