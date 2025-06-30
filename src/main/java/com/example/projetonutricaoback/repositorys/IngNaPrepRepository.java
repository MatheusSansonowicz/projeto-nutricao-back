package com.example.projetonutricaoback.repositorys;

import com.example.projetonutricaoback.models.IngredienteNaPreparacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngNaPrepRepository extends JpaRepository<IngredienteNaPreparacao, Integer> {


}
