package com.example.projetonutricaoback.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetonutricaoback.models.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}
