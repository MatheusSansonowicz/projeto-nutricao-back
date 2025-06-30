package com.example.projetonutricaoback.controllers;

import com.example.projetonutricaoback.models.Preparacao;
import com.example.projetonutricaoback.repositorys.PreparacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preparacoes")
public class PreparacaoController {

    private final PreparacaoRepository preparacaoRepository;

    public PreparacaoController(PreparacaoRepository preparacaoRepository) {
        this.preparacaoRepository = preparacaoRepository;
    }

    @GetMapping("/{usuario_id}")
    public List<Preparacao> listaPreparacoes(int id) {
        return preparacaoRepository.findAllByUsuarioCriadorPreparacaoId(id);
    }

    @GetMapping("/{id}")
    public Preparacao getPreparacao(int id) {
        return preparacaoRepository.findById(id).get();
    }

    @PostMapping("/criarPrepacaro")
    public Preparacao criarPreparacao(@RequestBody Preparacao preparacao) {
        return preparacaoRepository.save(preparacao);
    }

    @DeleteMapping("/deletarpreparacao/{id}")
    public void deletarPreparacao(@RequestBody Preparacao preparacao) {
        preparacaoRepository.delete(preparacao);
    }

    @PutMapping("/editarPreparacao")
    public Preparacao editarPreparacao(@RequestBody Preparacao preparacao) {
        preparacaoRepository.deleteById(preparacao.getId());
        return preparacaoRepository.save(preparacao);
    }
}
