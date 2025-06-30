package com.example.projetonutricaoback.controllers;


import com.example.projetonutricaoback.models.Ingrediente;
import com.example.projetonutricaoback.models.IngredienteNaPreparacao;
import com.example.projetonutricaoback.models.Preparacao;
import com.example.projetonutricaoback.repositorys.IngredienteRepository;
import com.example.projetonutricaoback.repositorys.PreparacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/preparacoes")
public class PreparacaoController {

    private final PreparacaoRepository preparacaoRepository;


    private final IngredienteRepository ingredienteRepository;

    public PreparacaoController(PreparacaoRepository preparacaoRepository, IngredienteRepository ingredienteRepository) {
        this.preparacaoRepository = preparacaoRepository;
        this.ingredienteRepository = ingredienteRepository;

    }

    @GetMapping
    public List<Preparacao> listaPreparacoes() {
        return preparacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Preparacao getPreparacao(@PathVariable Integer id) {
        return preparacaoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receita não encontrada"));
    }

    @PostMapping("/criarPreparacao")
    public Preparacao criarPreparacao(@RequestBody Preparacao preparacao) {
        if (preparacao.getIngredientesUsados() != null) {
            for (IngredienteNaPreparacao ingPrep : preparacao.getIngredientesUsados()) {
                if (ingPrep.getIngrediente() != null && ingPrep.getIngrediente().getId() != 0) {
                    Ingrediente ingredienteReal = ingredienteRepository.findById(ingPrep.getIngrediente().getId())
                            .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));
                    ingPrep.setIngrediente(ingredienteReal);
                } else {
                    throw new RuntimeException("Ingrediente invalido");
                }
                ingPrep.setPreparacaoPertencente(preparacao);
            }
        }
        return preparacaoRepository.save(preparacao);
    }

    @DeleteMapping("/{id}")
    public void deletarPreparacao(@PathVariable Integer id) {
        preparacaoRepository.deleteById(id);
    }

    @GetMapping("/{usuario_id}")
    public List<Preparacao> listaPreparacoes(int id) {
        return preparacaoRepository.findAllByUsuarioCriadorPreparacaoId(id);
    }

    @GetMapping("/{id}")
    public Preparacao getPreparacao(int id) {
        return preparacaoRepository.findById(id).get();
    }

    @DeleteMapping("/deletarpreparacao/{id}")
    public void deletarPreparacao(@RequestBody Preparacao preparacao) {
        preparacaoRepository.delete(preparacao);

    }

    @PutMapping("/editarPreparacao")
    public Preparacao editarPreparacao(@RequestBody Preparacao preparacao) {

        Preparacao existente = preparacaoRepository.findById(preparacao.getId())
                .orElseThrow(() -> new RuntimeException("Preparação não encontrada"));

        return preparacaoRepository.save(preparacao);
    }
}
