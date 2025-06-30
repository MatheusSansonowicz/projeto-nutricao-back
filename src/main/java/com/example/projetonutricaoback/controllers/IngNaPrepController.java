package com.example.projetonutricaoback.controllers;

import com.example.projetonutricaoback.models.IngredienteNaPreparacao;
import com.example.projetonutricaoback.models.Preparacao;
import com.example.projetonutricaoback.repositorys.IngNaPrepRepository;
import com.example.projetonutricaoback.repositorys.IngredienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredienteTratado")
public class IngNaPrepController {

    private final IngNaPrepRepository ingNaPrepRepository;


    public IngNaPrepController(IngNaPrepRepository ingNaPrepRepository) {
        this.ingNaPrepRepository = ingNaPrepRepository;
    }

//    @GetMapping
//    public List<IngredienteNaPreparacao> getIngNaPrep(@RequestParam Preparacao preparacao) {
//        return ingNaPrepRepository.findAllByPreparacaoPertencente(preparacao.getId());
//    }

    @GetMapping
    public List<IngredienteNaPreparacao> listaIngNaPreparacoes() {
        return ingNaPrepRepository.findAll();
    }

    @PostMapping
    private IngredienteNaPreparacao inserir(@RequestBody IngredienteNaPreparacao ingNaPreparacao) {
        return ingNaPrepRepository.save(ingNaPreparacao);
    }

    @PutMapping
    private IngredienteNaPreparacao modificar(@RequestBody IngredienteNaPreparacao ingNaPreparacao) {
        ingNaPrepRepository.deleteById(ingNaPreparacao.getId());
        return ingNaPrepRepository.save(ingNaPreparacao);
    }

    @DeleteMapping
    private void deletar(@RequestParam IngredienteNaPreparacao ingNaPreparacao) {
        ingNaPrepRepository.deleteById(ingNaPreparacao.getId());
    }
}
