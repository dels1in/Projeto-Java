package model;

public class Transportadora {
	private int transpId;
	private String transpNome;

	public Transportadora() {
		
	}
	
	public Transportadora(int transpId) {
		this.transpId = transpId;
	}
	
	public int getTranspId() {
		return transpId;
	}

	public void setTranspId(int transpId) {
		this.transpId = transpId;
	}

	public String getTranspNome() {
		return transpNome;
	}

	public void setTranspNome(String transpNome) {
		this.transpNome = transpNome;
	}

	@Override
	public String toString() {
		return "\n{\n"
				+ "transpId = "+ transpId +"\n"
				+ "transpNome = "+ transpNome +"\n"
				+ "}\n";
	}
}
