package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Preparacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

    @OneToMany(mappedBy = "preparacaoPertencente")
    private List<IngredienteNaPreparacao> ingredientesUsados;

	private String NomePreparacao;

	private String Categoria;

	private int Numero;

    @Column(columnDefinition = "TEXT")
	private String EquipUtensilios;

    @Column(columnDefinition = "TEXT")
	private String ModoPreparo;

	private double CustoTotal;

	private double numPorcoes;

	private double CustoPerCapta;

	private double Rendimento;

	private double TempoPorcoes;

	private String MedidaCaseira;

	private double FccPreparacao;

}
