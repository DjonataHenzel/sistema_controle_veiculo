package sistemaControleVeiculo;

public final class Passeio extends Veiculo implements Calc{
	private int qtdePassageiros;
	public int setVelocMax;
	
	// Constrututor
	public Passeio() {
		this.qtdePassageiros = 0;
	}
	
	public Passeio(int qtdePassageiros) {
		super();
		this.qtdePassageiros = qtdePassageiros;
	}

	//Getters e Setters
	public int getQtdePassageiros() {
		return qtdePassageiros;
	}

	public final void setQtdePassageiros(int qtdePassageiros) {
		this.qtdePassageiros = qtdePassageiros;
	}
	

	// Sobrescrita do metodo declarado como abstract na classe mãe 'Veiculo'
	@Override
	public float calcVel(int velocMax) {
		velocMax = (int) getVelocMax();
		//velocMax // vem em KM/h e precisa ser retornando em M/H
		return velocMax * 1000; // M/H (1km/h == 1000m/h)
	}
	
	// metodo calcular da classe calc
	public int calcular() {
		int somarLetras = 0;
		somarLetras = somarLetras + getMarca().length();
		somarLetras = somarLetras + getPlaca().length();
		somarLetras = somarLetras + getCor().length();
		somarLetras = somarLetras + getModelo().length();
		//somarLetras = + getMarca().length() + getPlaca().length() + getCor().length() + getModelo().length(); deixar esse
		return somarLetras ;
		
	}

}
