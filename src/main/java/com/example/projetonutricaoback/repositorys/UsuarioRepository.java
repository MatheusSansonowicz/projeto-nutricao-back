package com.example.projetonutricaoback.repositorys;

import com.example.projetonutricaoback.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
