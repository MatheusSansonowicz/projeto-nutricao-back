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

    @GetMapping
    public List<Preparacao> listaPreparacoes() {
        return preparacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Preparacao getPreparacao(int id) {
        return preparacaoRepository.findById(id).get();
    }

    @PostMapping("/criarPrepacaro")
    public Preparacao criarPreparacao(@RequestBody Preparacao preparacao) {
        return preparacaoRepository.save(preparacao);
    }

    @DeleteMapping
    public void deletarPreparacao(@RequestBody Preparacao preparacao) {
        preparacaoRepository.delete(preparacao);
    }

    @PutMapping("/editarPreparacao")
    public Preparacao editarPreparacao(@RequestBody Preparacao preparacao) {
        preparacaoRepository.deleteById(preparacao.getId());
        return preparacaoRepository.save(preparacao);
    }
}
