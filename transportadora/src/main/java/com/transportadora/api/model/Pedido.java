package com.transportadora.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedido")
@IdClass(PedidoId.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pedido_id")
	private Integer pedidoId; // id do pedido
	@Id
	@Column(name="item_id")
	private Integer itemId; // id de item da tabela
	@ManyToOne(targetEntity = ListStatus.class, cascade=CascadeType.ALL)
	@JoinColumn(name="status_id_status_id")
	private ListStatus statusId;
	private int clientId; // id do cliente
	@ManyToOne
	@JoinColumn(name="transp_id")
	@JsonBackReference
	private Transportadora transp; // id da transportadora
	private int cotacaoId; // id da cotacao
	private int ordemVendaId; // id da ordem de venda
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido; // data da atualização do pedido
	
	public Integer getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public ListStatus getStatusId() {
		return statusId;
	}
	public void setStatusId(ListStatus statusId) {
		this.statusId = statusId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Transportadora getTransp() {
		return transp;
	}
	public void setTransp(Transportadora transp) {
		this.transp = transp;
	}
	public int getCotacaoId() {
		return cotacaoId;
	}
	public void setCotacaoId(int cotacaoId) {
		this.cotacaoId = cotacaoId;
	}
	public int getOrdemVendaId() {
		return ordemVendaId;
	}
	public void setOrdemVendaId(int ordemVendaId) {
		this.ordemVendaId = ordemVendaId;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
}
