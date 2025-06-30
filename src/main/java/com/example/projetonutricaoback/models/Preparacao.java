package com.example.projetonutricaoback.models;

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

	@OneToMany(mappedBy = "preparacaoPertencente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<IngredienteNaPreparacao> ingredientesUsados;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioCriadorPreparacao;

	private String nomePreparacao;

	private String categoria;

	private int numero;

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

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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
