package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Nome;

    private double Proteinas;

    private double Carboidratos;

    private double Lipidios;

    private double Sodio;

    private double GordSaturada;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCriador;

}
