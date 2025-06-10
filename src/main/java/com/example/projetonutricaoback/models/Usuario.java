package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {

    @Id
    private int id;


    private String Nome;

    private String Senha;

    private String email;

    public boolean Login() {
        return false;
    }

    public boolean Deslogar() {
        return false;
    }

    @OneToMany(mappedBy = "usuarioCriador", cascade = CascadeType.ALL)
    private List<Ingrediente> IngredientesCriados;

}
