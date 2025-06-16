package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Entity
@Data
public class IngredienteNaPreparacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "ingrediente_id")
	private Ingrediente ingrediente;


	@ManyToOne
	@JoinColumn(nullable = false, name = "preparacao_id")
	private Preparacao preparacaoPertencente;

	private String MedidaCaseira;

	private double PesoBruto;

	private double PesoLiquido;

	private double CustoCompra;

	private double GramagemComprada;

	private double PerCapitaPL;

	private double CustoUso;

	private double FatorCoccao;

	public double CalculaFC() {
		this.FatorCoccao = this.PesoBruto / this.PesoLiquido;
		return FatorCoccao;
	}

	public double CaulculaCustoUso() {
		double VariavelApoio = this.CustoCompra * PesoBruto;
		double CustoUso = VariavelApoio / this.GramagemComprada;
		this.CustoUso = CustoUso;
		return CustoUso;
	}

	/*public double calculaPercapitaPL(){
		double numPorcoes = this.preparacaoPertencente.getNumPorcoes();
		this.PerCapitaPL = this.PesoLiquido / numPorcoes;
		return PerCapitaPL;
	}*/

}
