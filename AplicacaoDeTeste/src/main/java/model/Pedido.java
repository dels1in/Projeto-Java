package model;

public class Pedido {
	private int pedidoId;
	private ListStatus statusId;
	private int clientId;
	private Transportadora transp;
	private int cotacaoId;
	private int ordemVendaId;
	private String dataPedido;
	
	
	public int getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}
	public ListStatus getListStatus() {
		return statusId;
	}
	public void setListStatus(ListStatus listStatus) {
		this.statusId = listStatus;
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
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	@Override
	public String toString() {
		return "\n{\n"
				+ "pedidoId = "+ pedidoId +"\n"
				+ "statusId = "+ statusId +"\n"
				+ "clientId = "+ clientId +"\n"
				+ "transp = "+ transp +"\n"
				+ "cotacaoId = "+ cotacaoId +"\n"
				+ "ordemVendaId ="+ ordemVendaId +"\n"
				+ "dataPedido ="+ dataPedido +"\n"
				+ "}\n";
	}
}
