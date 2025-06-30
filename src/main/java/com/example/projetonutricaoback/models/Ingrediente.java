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
    private String nome;
    @Column(nullable = false)
    private double proteinas;
    @Column(nullable = false)
    private double carboidratos;
    @Column(nullable = false)
    private double lipidios;

    //atributos nao obrigatorios - nao encontrados na taco
    @Column(nullable = true)
    private double sodio;
    @Column(nullable = true)
    private Double gordSaturada;

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
        this.carboidratos = carboidratos;
    }

    public double getLipidios() {
        return lipidios;
    }

    public void setLipidios(double lipidios) {
        this.lipidios = lipidios;
    }

    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public Double getGordSaturada() {
        return gordSaturada;
    }

    public void setGordSaturada(Double gordSaturada) {
        this.gordSaturada = gordSaturada;
    }

    public Usuario getUsuarioCriadorIngrediente() {
        return usuarioCriadorIngrediente;
    }

    public void setUsuarioCriadorIngrediente(Usuario usuarioCriadorIngrediente) {
        this.usuarioCriadorIngrediente = usuarioCriadorIngrediente;
    }
}
