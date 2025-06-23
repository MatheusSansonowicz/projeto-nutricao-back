package com.example.projetonutricaoback.security.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
    @NotBlank(message = "Nome é obrigatório")
    String nome,
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String login,
    
    @NotBlank(message = "Senha é obrigatória")
    String password,
    
    UserRole role
) {}