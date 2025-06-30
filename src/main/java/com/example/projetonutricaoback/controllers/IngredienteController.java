package com.example.projetonutricaoback.controllers;

import com.example.projetonutricaoback.models.Ingrediente;
import com.example.projetonutricaoback.repositorys.IngredienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    private final IngredienteRepository ingredienteRepository;

    public IngredienteController(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @GetMapping("/listaCompleta")
    public List<Ingrediente> listaCompleta() {
        return ingredienteRepository.findAll();
    }

    @PostMapping("/adicionarIngrediente")
    public Ingrediente adicionarIngrediente(@RequestBody Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    @DeleteMapping
    public void deletarIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteRepository.delete(ingrediente);
    }

    @PutMapping("/modificarIngrediente")
    public Ingrediente modificarIngrediente(@RequestBody Ingrediente ingrediente) {
        ingredienteRepository.delete(ingrediente);
        return ingredienteRepository.save(ingrediente);
    }

    @GetMapping("/buscarPorNome")
    public List<Ingrediente> buscarPorNome(@RequestParam String nome) {
        return ingredienteRepository.findByNomeContainingIgnoreCase(nome);
    }

}
