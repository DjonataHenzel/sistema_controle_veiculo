package sistemaControleVeiculo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BDVeiculos {
	private static List<Passeio> BDPas = new ArrayList<Passeio>();
	private static List<Carga> BDCarg = new ArrayList<Carga>();
	private static String placaPasseio;
	private static String placaCarga;
	private static String placaRemover;
	private static boolean emprocessamento = false;

	// ------------------------------ METODO PARA CADASTROS ----------------------
	// Metodo para cadastrar veiculo de passeio
	public void cadastrarVecPasseio(Passeio passeio) {
		BDPas.add(passeio);

	}

	// Metodo para cadastrar veiculo de Carga
	public void cadastrarVecCarga(Carga carga) { // throws VelocException, VeicExistException {
		BDCarg.add(carga);
	}

	// ---------------------------METODO EXCLUIR-------------------------------
	// metodo para excluir registro Carga
	public static void excluirRegistroPorPlacaCarga() {
		placaRemover = getPlacaCarga();
		if (!emprocessamento) {
			for (int i = 0; i < BDCarg.size(); i++) {
				if (BDCarg.get(i) != null) {
					if (BDCarg.get(i).getPlaca().equalsIgnoreCase(placaRemover)) {
						BDCarg.remove(BDCarg.get(i));
						JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!!");
						emprocessamento = false;
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Placa não encontrada!!");
						emprocessamento = false;

					}
				} else {
					break;
				}
			}
		}
	}

	// metodo para excluir registro Passeio
	public static void excluirRegistroPorPlacaPasseio() {
		placaRemover = getPlacaPasseio();
		if (!emprocessamento) {
			for (int i = 0; i < BDPas.size(); i++) {
				if (BDPas.get(i) != null) {
					if (BDPas.get(i).getPlaca().equalsIgnoreCase(placaRemover)) {
						BDPas.remove(BDPas.get(i));
						JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!!");
						emprocessamento = false;
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Placa não encontrada!!");
						emprocessamento = false;
					}
				} else {
					break;
				}
			}
		}
	}

	// ---------------------------------Metodos para validar placa
	public void validaPlacaPasseio(String placa) throws VeicExistException {
		// -----------------------Passeio----------------------
		for (int i = 0; i < BDPas.size(); i++) {
			if (BDPas.get(i) != null) {
				if (BDPas.get(i).getPlaca().equalsIgnoreCase(placa)) {
					throw new VeicExistException();
				}
			}
		}

	}

	public void validaPlacaCarga(String placa) throws VeicExistException {
		// ----------------------Carga---------------------------
		for (int i = 0; i < BDCarg.size(); i++) {
			if (BDCarg.get(i) != null) {
				if (BDCarg.get(i).getPlaca().equalsIgnoreCase(placa)) {
					throw new VeicExistException();
				} else {
					return;
				}
			}
		}

	}

	public static String getPlacaPasseio() {
		return placaPasseio;
	}

	public static void setPlacaPasseio(String placaPasseio) {
		BDVeiculos.placaPasseio = placaPasseio;
	}

	public static String getPlacaCarga() {
		return placaCarga;
	}

	public static void setPlacaCarga(String placaCarga) {
		BDVeiculos.placaCarga = placaCarga;
	}

	public List<Passeio> getBDPas() {
		return BDPas;
	}

	public static void setBDPas(List<Passeio> bDPas) {
		BDPas = bDPas;
	}

	public List<Carga> getBDCarg() {
		return BDCarg;
	}

	public static void setBDCarg(List<Carga> bDCarg) {
		BDCarg = bDCarg;
	}

}
