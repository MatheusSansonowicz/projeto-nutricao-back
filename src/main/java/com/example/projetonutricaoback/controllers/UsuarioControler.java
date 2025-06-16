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

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/perfil")
    public List<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @PostMapping("/criarconta")
    public Usuario criar(@PathVariable Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{email}")
    public Usuario exibirPerfil(@PathVariable String email) {
        return (Usuario) usuarioRepository.findByEmail(email);
    }

}