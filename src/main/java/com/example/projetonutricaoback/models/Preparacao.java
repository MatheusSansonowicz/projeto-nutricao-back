package com.example.projetonutricaoback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Preparacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// 1 - Cabeçalho
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioCriadorPreparacao;

	private String nomePreparacao;

	private String categoria;

	private int numero;

	// 2- Primeira metade da ficha
	@OneToMany(mappedBy = "preparacaoPertencente")
	private List<IngredienteNaPreparacao> ingredientesUsados;

    @Column(columnDefinition = "TEXT")
	private String equipUtensilios;

    @Column(columnDefinition = "TEXT")
	private String modoPreparo;

	private double custoTotal;

	private double numPorcoes;

	private double custoPerCapta;

	private double rendimento;

	private double tempoPorcoes;

	private String medidaCaseira;

	private double fccPreparacao;

	// 3 - segunda metade da ficha

	private double totalGramasProteinas;
	private double totalKcalProteinas;
	private double totalPorCentProteinas;

	private double totalGramasCarboidratos;
	private double totalKcalCarboidratos;
	private double totalPorCentCarboidratos;

	private double totalGramasLipidios;
	private double totalKcalLipidios;
	private double totalPorCentLipidios;

	public void setTotais() {

		totalGramasProteinas = 0;
		totalGramasCarboidratos = 0;
		totalGramasLipidios = 0;

		for (IngredienteNaPreparacao i : ingredientesUsados){
			totalGramasProteinas += i.getProteinasIngPrep();
			totalGramasCarboidratos += i.getCarboidratosIngPrep();
			totalGramasLipidios += i.getLipidiosIngPrep();
		}

		totalKcalProteinas = totalGramasProteinas * 4;
		totalKcalCarboidratos = totalGramasCarboidratos * 4;
		totalKcalLipidios = totalGramasLipidios * 9;
	}

	private double totalGramasSodio;
	@Column(nullable = true)
	private double totalKcalSodio;

	public void setTotalGramasSodio() {
		totalGramasSodio = 0;
		for (IngredienteNaPreparacao i : ingredientesUsados){
			totalGramasSodio += i.getSodioIngPrep();
		}
	}

	private double totalGramasGordSaturada;
	@Column(nullable = true)
	private double totalKcalGordSaturada;

	public void setTotalGramasGordSaturada() {
		totalGramasGordSaturada = 0;
		for (IngredienteNaPreparacao i : ingredientesUsados){
			totalGramasGordSaturada += i.getGorduraSatIngPrep();
		}
	}

}
