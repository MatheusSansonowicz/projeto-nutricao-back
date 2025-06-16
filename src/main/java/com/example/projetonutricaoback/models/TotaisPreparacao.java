package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TotaisPreparacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Preparacao Preparacao;

	@OneToOne
	private IngredienteNaPreparacao ingredienteNaPreparacao;

	//atributos que usam a lista de ingredientes para serem obtidos
	private double totalPorCento;

	private double totalGramas;

	public double ValorCaloricoTotal;

	/* CALCULOS E AFINS QUE DEVEM SER ADAPTADOS E REPASSADOS PARA OUTRAS CLASSES
	public double TotalG() {
		while(this.ingredienteNaPreparacao.size() > 0) {
			for(IngredienteNaPreparacao ing : ingredienteNaPreparacao) {
				ing.getIngrediente().get
			}
		}
		return 0;
	}

	public double totalkcaal() {

		while(this.ingredientesUsados.size() > 0) {
			for(IngredienteNaPreparacao ing : ingredientesUsados){
				ing.getIngrediente().get
			}
		}
		return 0;
	}

	public double totalPorCento() {
		return 0;
	}

	public double CalculaVCT(int TotalKcal) {
		return 0;
	}

	public double totalKcal() {
		return 0;
	}

	 */

}
