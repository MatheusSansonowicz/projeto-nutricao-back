package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

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

    //@Column(unique = true)
    private String email;

//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String Login;
//
//    public boolean Login() {
//        return false;
//    }
//
//    public boolean Deslogar() {
//        return false;
//    }

    @OneToMany(mappedBy = "usuarioCriadorIngrediente")
    private List<Ingrediente> ingredientesCriados;

    @OneToMany(mappedBy = "usuarioCriadorPreparacao")
    private List<Preparacao> preparacoesCriadas;

    public boolean equals(String senha) {
        if (senha == null) return false;
        return Objects.equals(senha, this.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(senha);
    }
}
