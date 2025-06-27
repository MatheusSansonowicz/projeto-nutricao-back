package com.example.projetonutricaoback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class IngredienteNaPreparacao {

	//1 - Identificaçoes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(nullable = false, name = "ingrediente_id")
	private Ingrediente ingrediente;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(nullable = false, name = "preparacao_id")
	private Preparacao preparacaoPertencente;

	//2 - Primeira metade da ficha

	private String medidaCaseira;

	private double pesoBruto;

	private double pesoLiquido;

	private double custoCompra;

	private double gramagemComprada;
	//Nota: não aparece na ficha
	// mas é necessário p calcular o custo uso.

	private double custoUso;

	private double fatorCoccao;

	public double CalculaFC() {
		this.fatorCoccao = this.pesoBruto / this.pesoLiquido;
		return fatorCoccao;
	}

	public double CaulculaCustoUso() {
		double VariavelApoio = this.custoCompra * pesoBruto;
		double CustoUso = VariavelApoio / this.gramagemComprada;
		this.custoUso = CustoUso;
		return CustoUso;
	}

	//3 - Segunda metade da ficha
	//Nota: apenas de cada ingrediente,
	//os totais por preparação ficam na
	//classe preparação.

	private double PerCapitaPL;

	public double calculaPercapitaPL(){
		double numPorcoes = this.preparacaoPertencente.getNumPorcoes();
		this.PerCapitaPL = this.pesoLiquido / numPorcoes;
		return PerCapitaPL;
	}

	private double proteinasIngPrep;

	public double calculaProteinas(){
		this.proteinasIngPrep = this.ingrediente.getProteinas()*this.getPesoLiquido();
		return proteinasIngPrep;
	}

	private double carboidratosIngPrep;
	public double calculaCarboidratos(){
		this.carboidratosIngPrep = this.ingrediente.getCarboidratos()*this.getPesoLiquido();
		return carboidratosIngPrep;
	}

	private double lipidiosIngPrep;
	public double calculaLipidios(){
		this.lipidiosIngPrep = this.ingrediente.getLipidios()*this.getPesoLiquido();
		return lipidiosIngPrep;
	}

	private double sodioIngPrep;
	public double calculaSodio(){
		this.sodioIngPrep = this.ingrediente.getSodio()*this.getPesoLiquido();
		return sodioIngPrep;
	}

	private double gorduraSatIngPrep;
	public double calculaGorduraSat(){
		this.gorduraSatIngPrep = this.ingrediente.getGordSaturada()*this.getPesoLiquido();
		return gorduraSatIngPrep;
	}

}
