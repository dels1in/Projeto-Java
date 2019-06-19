package model;

public class ListStatus {
	private int statusId;
	private String situacao;

	public ListStatus() {
		
	}
	
	public ListStatus(int statusId) {
		this.statusId = statusId;
	}
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return "\n{\n"
				+ "statusId = "+ statusId +"\n"
				+ "situacao = "+ situacao +"\n"
				+ "}\n";
	}
}
