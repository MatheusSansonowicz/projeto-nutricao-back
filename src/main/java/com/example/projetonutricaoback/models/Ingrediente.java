package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

}
