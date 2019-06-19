package com.cotacao.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="precoRange")
public class PrecoRange implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="range_id")
	private int rangeId; // id do range
	@Column(name="cep_min")
	private int cepMin; // cep range minimo
	@Column(name="cep_max")
	private int cepMax; // cep range maximo
	@Column(name="peso_min")
	private int pesoMin; // peso range minimo
	@Column(name="peso_max")
	private int pesoMax; // peso range maximo
	@Column(name="valor")
	private float valor; // valor de transporte para o endereço
	
	public int getRangeId() {
		return rangeId;
	}
	public void setRangeId(int rangeId) {
		this.rangeId = rangeId;
	}
	public int getCepMin() {
		return cepMin;
	}
	public void setCepMin(int cepMin) {
		this.cepMin = cepMin;
	}
	public int getCepMax() {
		return cepMax;
	}
	public void setCepMax(int cepMax) {
		this.cepMax = cepMax;
	}
	public int getPesoMin() {
		return pesoMin;
	}
	public void setPesoMin(int pesoMin) {
		this.pesoMin = pesoMin;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
