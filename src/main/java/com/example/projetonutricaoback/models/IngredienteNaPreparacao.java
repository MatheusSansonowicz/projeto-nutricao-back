package com.example.projetonutricaoback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Entity
public class IngredienteNaPreparacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "ingrediente_id")
	private Ingrediente ingrediente;


	@ManyToOne
	@JoinColumn(nullable = false, name = "preparacao_id")
	@JsonBackReference
	private Preparacao preparacaoPertencente;

	private String medidaCaseira;

	private double pesoBruto;

	private double pesoLiquido;

	private double custoCompra;

	private double gramagemComprada;

	private double perCapitaPL;

	private double custoUso;

	private double fatorCoccao;

	public double CalculaFC() {
		this.fatorCoccao = this.pesoBruto / this.pesoLiquido;
		return fatorCoccao;
	}

	public double calculaCustoUso() {
		double variavelApoio = this.custoCompra * pesoBruto;
		double custoUso = variavelApoio / this.gramagemComprada;
		this.custoUso = custoUso;
		return custoUso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Preparacao getPreparacaoPertencente() {
		return preparacaoPertencente;
	}

	public void setPreparacaoPertencente(Preparacao preparacaoPertencente) {
		this.preparacaoPertencente = preparacaoPertencente;
	}

	public String getMedidaCaseira() {
		return medidaCaseira;
	}

	public void setMedidaCaseira(String medidaCaseira) {
		this.medidaCaseira = medidaCaseira;
	}

	public double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public double getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public double getCustoCompra() {
		return custoCompra;
	}

	public void setCustoCompra(double custoCompra) {
		this.custoCompra = custoCompra;
	}

	public double getGramagemComprada() {
		return gramagemComprada;
	}

	public void setGramagemComprada(double gramagemComprada) {
		this.gramagemComprada = gramagemComprada;
	}

	public double getPerCapitaPL() {
		return perCapitaPL;
	}

	public void setPerCapitaPL(double perCapitaPL) {
		this.perCapitaPL = perCapitaPL;
	}

	public double getCustoUso() {
		return custoUso;
	}

	public void setCustoUso(double custoUso) {
		this.custoUso = custoUso;
	}

	public double getFatorCoccao() {
		return fatorCoccao;
	}

	public void setFatorCoccao(double fatorCoccao) {
		this.fatorCoccao = fatorCoccao;
	}

	/*public double calculaPercapitaPL(){
		double numPorcoes = this.preparacaoPertencente.getNumPorcoes();
		this.PerCapitaPL = this.PesoLiquido / numPorcoes;
		return PerCapitaPL;
	}*/

}
