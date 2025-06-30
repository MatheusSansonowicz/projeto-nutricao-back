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

	private int Id;

	// 1 - Cabeçalho
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioCriadorPreparacao;

	private String nomePreparacao;

	private String categoria;

	private int numero;

	// 2- Primeira metade da ficha
	@OneToMany(mappedBy = "preparacaoPertencente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
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
			totalGramasProteinas += i.getIngrediente().getProteinas();
			totalGramasCarboidratos += i.getIngrediente().getCarboidratos();
			totalGramasLipidios += i.getIngrediente().getLipidios();
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
			totalGramasSodio += i.getIngrediente().getSodio();
		}
	}

	private double totalGramasGordSaturada;
	@Column(nullable = true)
	private double totalKcalGordSaturada;

	public void setTotalGramasGordSaturada() {
		totalGramasGordSaturada = 0;
		for (IngredienteNaPreparacao i : ingredientesUsados){
			totalGramasGordSaturada += i.getIngrediente().getGordSaturada();
		}
	}


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = Id;
	}

	public List<IngredienteNaPreparacao> getIngredientesUsados() {
		return ingredientesUsados;
	}

	public void setIngredientesUsados(List<IngredienteNaPreparacao> ingredientesUsados) {
		this.ingredientesUsados = ingredientesUsados;
	}

	public Usuario getUsuarioCriadorPreparacao() {
		return usuarioCriadorPreparacao;
	}

	public void setUsuarioCriadorPreparacao(Usuario usuarioCriadorPreparacao) {
		this.usuarioCriadorPreparacao = usuarioCriadorPreparacao;
	}

	public String getNomePreparacao() {
		return nomePreparacao;
	}

	public void setNomePreparacao(String nomePreparacao) {
		this.nomePreparacao = nomePreparacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEquipUtensilios() {
		return equipUtensilios;
	}

	public void setEquipUtensilios(String equipUtensilios) {
		this.equipUtensilios = equipUtensilios;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public double getCustoTotal() {
		return custoTotal;
	}

	public void setCustoTotal(double custoTotal) {
		this.custoTotal = custoTotal;
	}

	public double getNumPorcoes() {
		return numPorcoes;
	}

	public void setNumPorcoes(double numPorcoes) {
		this.numPorcoes = numPorcoes;
	}

	public double getCustoPerCapta() {
		return custoPerCapta;
	}

	public void setCustoPerCapta(double custoPerCapta) {
		this.custoPerCapta = custoPerCapta;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public double getTempoPorcoes() {
		return tempoPorcoes;
	}

	public void setTempoPorcoes(double tempoPorcoes) {
		this.tempoPorcoes = tempoPorcoes;
	}

	public String getMedidaCaseira() {
		return medidaCaseira;
	}

	public void setMedidaCaseira(String medidaCaseira) {
		this.medidaCaseira = medidaCaseira;
	}

	public double getFccPreparacao() {
		return fccPreparacao;
	}

	public void setFccPreparacao(double fccPreparacao) {
		this.fccPreparacao = fccPreparacao;
	}
}
