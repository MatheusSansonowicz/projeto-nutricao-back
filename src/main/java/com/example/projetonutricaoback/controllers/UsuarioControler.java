package com.example.projetonutricaoback.controllers;


import com.example.projetonutricaoback.models.Usuario;
import com.example.projetonutricaoback.repositorys.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuarioControler {

    private final UsuarioRepository usuarioRepository;

    public UsuarioControler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/criarconta")
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}