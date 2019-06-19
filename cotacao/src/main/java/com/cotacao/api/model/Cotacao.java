package com.cotacao.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Cotacao")
public class Cotacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cotacao_id")
	private int cotacaoId; // id da cotacao
	@Column(name="peso")
	private int peso; // peso do produto
	@Column(name="cep")
	private int cep; // endereco de entrega
	@Column(name="valor")
	private float valor; // valor de transporte
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cot_valido")
	private Date valido;
	
	
	public int getCotacaoId() {
		return cotacaoId;
	}
	public void setCotacaoId(int cotacaoId) {
		this.cotacaoId = cotacaoId;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getValido() {
		return valido;
	}
	public void setValido(Date valido) {
		this.valido = valido;
	}
	
}
