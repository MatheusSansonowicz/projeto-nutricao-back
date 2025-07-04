package com.example.projetonutricaoback.controllers;

import com.example.projetonutricaoback.models.Usuario;
import com.example.projetonutricaoback.repositorys.UsuarioRepository;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuarioControler {

    private final UsuarioRepository usuarioRepository;


    public UsuarioControler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @GetMapping("/{email}")
    public Usuario findByEmail(@PathVariable String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado com email: " + email
                ));
    }

}