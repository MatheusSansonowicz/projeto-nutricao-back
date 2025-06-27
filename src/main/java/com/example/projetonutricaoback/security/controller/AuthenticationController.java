package com.example.projetonutricaoback.security.controller;

import com.example.projetonutricaoback.models.Usuario;
import com.example.projetonutricaoback.repositorys.UsuarioRepository;
import com.example.projetonutricaoback.security.domain.AuthenticationDTO;
import com.example.projetonutricaoback.security.domain.LoginResponseDTO;
import com.example.projetonutricaoback.security.domain.RegisterDTO;
import com.example.projetonutricaoback.security.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        try {
            if (this.usuarioRepository.findByEmail(data.login()).isPresent()) {
                return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Email already registered"));
            }

            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            Usuario newUser = new Usuario(encryptedPassword, data.nome(), data.login(), data.role());

            this.usuarioRepository.save(newUser);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(new ErrorResponse("Error during registration: " + e.getMessage()));
        }
    }

    private record ErrorResponse(String message) {}
}