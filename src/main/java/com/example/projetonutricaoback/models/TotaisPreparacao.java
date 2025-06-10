package com.example.projetonutricaoback.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TotaisPreparacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Preparacao Preparacao;

	private double totalPorCento;

	private double totalGramas;

	public double ValorCaloricoTotal;

	public double TotalG() {
		return 0;
	}

	public double totalkcaal() {
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

}
