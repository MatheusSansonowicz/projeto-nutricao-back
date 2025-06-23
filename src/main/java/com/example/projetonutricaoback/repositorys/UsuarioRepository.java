package com.example.projetonutricaoback.repositorys;

import com.example.projetonutricaoback.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    Usuario findByEmailAndSenha(String email, String senha);
}
