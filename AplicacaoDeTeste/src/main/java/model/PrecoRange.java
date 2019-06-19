package model;

public class PrecoRange {
	private int cepMin;
	private int cepMax;
	private int pesoMin;
	private int pesoMax;
	private float valor;
	
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
	
	@Override
	public String toString() {
		return "\n{\n"
				+ "cepMin = "+ cepMin +"\n"
				+ "cepMax = "+ cepMax +"\n"
				+ "pesoMin = "+ pesoMin +"\n"
				+ "pesoMax = "+ pesoMax +"\n"
				+ "valor = "+ valor +"\n"
				+ "}\n";
	}
}
