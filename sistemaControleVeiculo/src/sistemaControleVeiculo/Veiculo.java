package sistemaControleVeiculo;

public abstract class Veiculo {
	private static BDVeiculos BDVeic = new BDVeiculos();
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private int qtdRodas;
	private int velocMax;
	private Motor motor;

	public Veiculo() {
		this.placa = ("");
		this.marca = ("");
		this.modelo = ("");
		this.cor = ("");
		this.qtdRodas = 0;
		this.velocMax = 0;
		this.motor = new Motor();

	}

	// ------- Contrutores------
	public Veiculo(String placa, String marca, String modelo, String cor, int qtdRodas, int velocMax, Motor motor) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.qtdRodas = qtdRodas;
		this.velocMax = velocMax;
		this.motor = new Motor();
	}

	// ------ Getters e Setters-----
	public String getPlaca() {
		return placa;
	}

	public final void setPlaca(String placa) { //
		this.placa = placa;

	} // fim setlaca

	public String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String carga() {
		return modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public int getVelocMax() {
		return velocMax;
	}

	public final void setVelocMax(int VelocMax) throws VelocException {
		if (VelocMax < 80 || VelocMax > 100) {
			throw new VelocException();

		} else {
			this.velocMax = VelocMax;
		}
	}

	public Motor passeio() {
		return motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Motor getMotor() {
		return motor;
	}

	public abstract float calcVel(int velocMax);

}
