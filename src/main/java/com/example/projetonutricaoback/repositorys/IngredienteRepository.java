package com.example.projetonutricaoback.repositorys;

import com.example.projetonutricaoback.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    List<Ingrediente> findByNomeContainingIgnoreCase(String nome);


    Ingrediente findByNomeIsContaining(String nome);

    List<Ingrediente> findByNomeContaining(String nome);


}
