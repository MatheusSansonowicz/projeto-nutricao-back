package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity

public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    //atributos puxados da taco ou inseridos p usuario
    @Column(unique = true, nullable = false)
    private String Nome;
    @Column(nullable = false)
    private double Proteinas;
    @Column(nullable = false)
    private double Carboidratos;
    @Column(nullable = false)
    private double Lipidios;

    //atributos nao obrigatorios - nao encontrados na taco
    @Column(nullable = true)
    private double Sodio;
    @Column(nullable = true)
    private double GordSaturada;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCriadorIngrediente;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public double getProteinas() {
        return Proteinas;
    }

    public void setProteinas(double proteinas) {
        Proteinas = proteinas;
    }

    public double getCarboidratos() {
        return Carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        Carboidratos = carboidratos;
    }

    public double getLipidios() {
        return Lipidios;
    }

    public void setLipidios(double lipidios) {
        Lipidios = lipidios;
    }

    public double getSodio() {
        return Sodio;
    }

    public void setSodio(double sodio) {
        Sodio = sodio;
    }

    public double getGordSaturada() {
        return GordSaturada;
    }

    public void setGordSaturada(double gordSaturada) {
        GordSaturada = gordSaturada;
    }

    public Usuario getUsuarioCriadorIngrediente() {
        return usuarioCriadorIngrediente;
    }

    public void setUsuarioCriadorIngrediente(Usuario usuarioCriadorIngrediente) {
        this.usuarioCriadorIngrediente = usuarioCriadorIngrediente;
    }

    public Ingrediente(int id, String nome, double proteinas, double carboidratos, double lipidios, double sodio, double gordSaturada, Usuario usuarioCriadorIngrediente) {
        Id = id;
        Nome = nome;
        Proteinas = proteinas;
        Carboidratos = carboidratos;
        Lipidios = lipidios;
        Sodio = sodio;
        GordSaturada = gordSaturada;
        this.usuarioCriadorIngrediente = usuarioCriadorIngrediente;
    }

    public Ingrediente() {
    }

    public Ingrediente(String nome, double proteinas, double carboidratos, double lipidios, double sodio, double gordSaturada, Usuario usuarioCriadorIngrediente) {
        Nome = nome;
        Proteinas = proteinas;
        Carboidratos = carboidratos;
        Lipidios = lipidios;
        Sodio = sodio;
        GordSaturada = gordSaturada;
        this.usuarioCriadorIngrediente = usuarioCriadorIngrediente;
    }

    public Ingrediente(String nome, double proteinas, double carboidratos, double lipidios, double sodio, double gordSaturada) {
        Nome = nome;
        Proteinas = proteinas;
        Carboidratos = carboidratos;
        Lipidios = lipidios;
        Sodio = sodio;
        GordSaturada = gordSaturada;
    }
}
