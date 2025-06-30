package com.example.projetonutricaoback.repositorys;

import com.example.projetonutricaoback.models.Preparacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PreparacaoRepository extends JpaRepository<Preparacao, Integer> {

    List<Preparacao> findAllByUsuarioCriadorPreparacaoId(int id);

}
