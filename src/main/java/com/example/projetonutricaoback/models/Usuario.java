package com.example.projetonutricaoback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Column(nullable = false)
    private String senha;

    @Column(unique = true)
    private String email;

    //@GeneratedValue(strategy = GenerationType.UUID)
    //private String Login;

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
    @JsonBackReference
    private List<Ingrediente> ingredientesCriados;

    @OneToMany(mappedBy = "usuarioCriadorPreparacao")
    @JsonBackReference
    private List<Preparacao> preparacoesCriadas;

//    public boolean equals(String senha) {
//        if (senha == null) return false;
//        return Objects.equals(senha, this.senha);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(senha);
//    }


    public Usuario() {

    }

    public Usuario(String senha, String nome, String email) {
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }

    public Usuario(List<Preparacao> preparacoesCriadas, List<Ingrediente> ingredientesCriados, String email, String senha, String nome, int id) {
        this.preparacoesCriadas = preparacoesCriadas;
        this.ingredientesCriados = ingredientesCriados;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ingrediente> getIngredientesCriados() {
        return ingredientesCriados;
    }

    public void setIngredientesCriados(List<Ingrediente> ingredientesCriados) {
        this.ingredientesCriados = ingredientesCriados;
    }

    public List<Preparacao> getPreparacoesCriadas() {
        return preparacoesCriadas;
    }

    public void setPreparacoesCriadas(List<Preparacao> preparacoesCriadas) {
        this.preparacoesCriadas = preparacoesCriadas;
    }
}
