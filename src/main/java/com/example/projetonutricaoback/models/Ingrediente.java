package com.example.projetonutricaoback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity

public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //atributos puxados da taco ou inseridos p usuario
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(nullable = false)
    private double proteinas;
    @Column(nullable = false)
    private double carboidratos;
    @Column(nullable = false)
    private double lipidios;

    //atributos nao obrigatorios - nao encontrados na taco
    @Column(nullable = true)
    private Double sodio;
    @Column(nullable = true)
    private Double gordSaturada;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCriadorIngrediente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        carboidratos = carboidratos;
    }

    public double getLipidios() {
        return lipidios;
    }

    public void setLipidios(double lipidios) {
        this.lipidios = lipidios;
    }

    public double getSodio() {
        if (sodio == null) {
            return 0.0;
        }
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public double getGordSaturada() {
        if (gordSaturada == null) {
            return 0.0;
        }
        return gordSaturada;
    }

    public void setGordSaturada(double gordSaturada) {
        this.gordSaturada = gordSaturada;
    }

    public Usuario getUsuarioCriadorIngrediente() {
        return usuarioCriadorIngrediente;
    }

    public void setUsuarioCriadorIngrediente(Usuario usuarioCriadorIngrediente) {
        this.usuarioCriadorIngrediente = usuarioCriadorIngrediente;
    }

    public Ingrediente(int id, String nome, double proteinas, double carboidratos, double lipidios, Double sodio, Double gordSaturada, Usuario usuarioCriadorIngrediente) {
        this.id = id;
        this.nome = nome;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.lipidios = lipidios;
        this.sodio = sodio;
        this.gordSaturada = gordSaturada;
        this.usuarioCriadorIngrediente = usuarioCriadorIngrediente;
    }

    public Ingrediente() {
    }

    public Ingrediente(String nome, double proteinas, double carboidratos, double lipidios, Double sodio, Double gordSaturada, Usuario usuarioCriadorIngrediente) {
        this.nome = nome;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.lipidios = lipidios;
        this.sodio = sodio;
        this.gordSaturada = gordSaturada;
        this.usuarioCriadorIngrediente = usuarioCriadorIngrediente;
    }

    public Ingrediente(String nome, double proteinas, double carboidratos, double lipidios, Double sodio, Double gordSaturada) {
        this.nome = nome;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.lipidios = lipidios;
        this.sodio = sodio;
        this.gordSaturada = gordSaturada;
    }
}
