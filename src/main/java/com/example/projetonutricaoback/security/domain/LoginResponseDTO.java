package com.example.projetonutricaoback.security.domain;

public record LoginResponseDTO(
    String token
) {
    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
