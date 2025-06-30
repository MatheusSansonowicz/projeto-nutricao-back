package com.example.projetonutricaoback.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetonutricaoback.models.Ingrediente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    Ingrediente findByNomeIsContaining(String nome);

    List<Ingrediente> findByNomeContaining(String nome);

}
