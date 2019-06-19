package model;


public class Cotacao {
	private Integer cep;
	private Integer peso;
	private String valido;
	
	
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public String getValido() {
		return valido;
	}
	public void setValido(String valido) {
		this.valido = valido;
	}
	@Override
	public String toString() {
		return "\n{\n"
				+ "cep = "+ cep +"\n"
				+ "peso = "+ peso +"\n"
				+ "valido = "+ valido +"\n"
				+ "}\n";
	}
}
