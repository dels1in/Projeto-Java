package com.transportadora.api.model;

import java.io.Serializable;

public class PedidoId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer pedidoId;
	private Integer itemId;
	
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
}
