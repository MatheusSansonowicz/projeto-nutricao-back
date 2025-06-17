package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    //@GeneratedValue(strategy = GenerationType.UUID)
    //private String Login;

    private String senha;

    @Column(unique = true)
    private String email;

    public boolean Login() {
        return false;
    }

    public boolean Deslogar() {
        return false;
    }

    @OneToMany(mappedBy = "usuarioCriadorIngrediente")
    private List<Ingrediente> ingredientesCriados;

    @OneToMany(mappedBy = "usuarioCriadorPreparacao")
    private List<Preparacao> preparacoesCriadas;

}
