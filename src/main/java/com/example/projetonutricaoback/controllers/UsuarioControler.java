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

//    @PostMapping("/registrar")
//    public Usuario registrar(@RequestBody Usuario usuario) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        usuario.setSenha(encoder.encode(usuario.getSenha()));
//        return usuarioRepository.save(usuario);
//    }

     @GetMapping("/{email}")
    public Usuario findByEmail(@PathVariable String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado com email: " + email
                ));
    }

    @GetMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String password) {
        return usuarioRepository.findByEmailAndSenha(email, password);
    }
}