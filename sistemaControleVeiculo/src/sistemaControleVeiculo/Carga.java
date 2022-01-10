package sistemaControleVeiculo;

public final class Carga extends Veiculo implements Calc {
	private int tara;
	private int cargaMax;

	// Construtor
	public Carga() {
		this.tara = 0;
		this.cargaMax = 0;
	}

	public Carga(int tara, int cargaMax) {
		this.tara = tara;
		this.cargaMax = cargaMax;
	}

	// Getters e Setters
	public int getTara() {
		return tara;
	}

	public final void setTara(int tara) {
		this.tara = tara;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	// Sobrescrita do metodo declarado como abstract na classe mãe 'Veiculo'
	@Override
	public float calcVel(int velocMax) {
		velocMax = (int) getVelocMax();
		//velocMax // vem em KM/h e precisa ser retornando em CM/H
		return velocMax * 100000; // M/H (1km/h == 100000cm/h)
	}
	
	// metodo calcular da classe calc
	public int calcular() {
		int somarNumeros = 0; 
		somarNumeros = somarNumeros + getMotor().getPotencia();
		somarNumeros = somarNumeros + getMotor().getQtdPist();
		somarNumeros = somarNumeros + getQtdRodas();
		somarNumeros = somarNumeros + getTara();
		somarNumeros = somarNumeros + getVelocMax();
		somarNumeros = somarNumeros + getCargaMax();
		return somarNumeros ;
		
	}
	
}
