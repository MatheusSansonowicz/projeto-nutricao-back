package com.example.projetonutricaoback.controllers;


import com.example.projetonutricaoback.models.Usuario;
import com.example.projetonutricaoback.repositorys.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioControler {

    private final UsuarioRepository usuarioRepository;


    public UsuarioControler(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public Usuario post(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


}