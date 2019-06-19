package com.transportadora.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="transportadora")
public class Transportadora implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="transp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transpId;
	private String transpNome;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "transp")
	private List<Pedido> pedido;
	
	
	public Integer getTranspId() {
		return transpId;
	}
	public void setTranspId(Integer transpId) {
		this.transpId = transpId;
	}
	public String getTranspNome() {
		return transpNome;
	}
	public void setTranspNome(String transpNome) {
		this.transpNome = transpNome;
	}
	public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido.add(pedido);
	}
}
