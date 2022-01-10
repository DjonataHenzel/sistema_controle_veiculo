package sistemaControleVeiculo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class interfacePasseio implements ActionListener {
	private static String placaPasseio;
	private boolean emprocessamento = false;
	private static Passeio passeio = new Passeio();
	private static BDVeiculos BDveic = new BDVeiculos();
	private static interfacePasseio interPass = new interfacePasseio();
	private static JFrame cadPasseio = new JFrame();
	private static JFrame consExcadPasseio = new JFrame();
	private static JFrame consExcTodosPasseio = new JFrame();
	private static JButton btLimpar = new JButton();
	private static JButton btCadastrar = new JButton();
	private static JButton btConsultar = new JButton();
	private static JButton btExcluir = new JButton();
	private static JButton btSair = new JButton();
	private static JButton btImprimirTodos = new JButton();
	private static JButton btExcluirTodos = new JButton();
	private static JLabel lbQtPasseg = new JLabel();
	private static JLabel lbPlaca = new JLabel();
	private static JLabel lbMarca = new JLabel();
	private static JLabel lbModelo = new JLabel();
	private static JLabel lbCor = new JLabel();
	private static JLabel lbQtRodas = new JLabel();
	private static JLabel lbVelMax = new JLabel();
	private static JLabel lbQtPistao = new JLabel();
	private static JLabel lbPotencia = new JLabel();

	private static JTextField txtQtPassageiro = new JTextField(15);
	private static JTextField txtPlaca = new JTextField(21);
	private static JTextField txtPlacaCons = new JTextField(18);
	private static JTextField txtMarca = new JTextField(20);
	private static JTextField txtModelo = new JTextField(22);
	private static JTextField txtCor = new JTextField(22);
	private static JTextField txtQtRodas = new JTextField(19);
	private static JTextField txtVelMax = new JTextField(18);
	private static JTextField txtQtPistao = new JTextField(19);
	private static JTextField txtPotencia = new JTextField(20);

	private static String[] colunas = { "Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc Max", "Qtd Pistão",
			"Potencia", "Qtd Passag" };
	private static DefaultTableModel model = new DefaultTableModel(colunas, 10);
	private static JTable viewPasseio = new JTable(model);
	private static JScrollPane barraRolagem = new JScrollPane(viewPasseio);

	public static void cadastroVeiculoPasseio() {
		int lagura = 340;
		int altura = 305;
		cadPasseio.setSize(lagura, altura);
		cadPasseio.setLayout(new FlowLayout());
		cadPasseio.setLocationRelativeTo(null);
		cadPasseio.setTitle("Cadastro de passeio");

		lbQtPasseg.setText("Qtd. Passageiros: ");
		txtQtPassageiro.setText(null);
		lbPlaca.setText("Placa: ");
		txtPlaca.setText(null);
		lbMarca.setText("Marca: ");
		txtMarca.setText(null);
		lbModelo.setText("Modelo: ");
		txtModelo.setText(null);
		lbCor.setText("Cor: ");
		txtCor.setText(null);
		lbQtRodas.setText("Qtd. Rodas: ");
		txtQtRodas.setText(null);
		lbVelMax.setText("Velocidade Max: ");
		txtVelMax.setText(null);
		lbQtPistao.setText("Qtd. Pistões: ");
		txtQtPistao.setText(null);
		lbPotencia.setText("Potencia: ");
		txtPotencia.setText(null);

		cadPasseio.add(lbQtPasseg);
		cadPasseio.add(txtQtPassageiro);
		cadPasseio.add(lbPlaca);
		cadPasseio.add(txtPlaca);
		cadPasseio.add(lbMarca);
		cadPasseio.add(txtMarca);
		cadPasseio.add(lbModelo);
		cadPasseio.add(txtModelo);
		cadPasseio.add(lbCor);
		cadPasseio.add(txtCor);
		cadPasseio.add(lbQtRodas);
		cadPasseio.add(txtQtRodas);
		cadPasseio.add(lbVelMax);
		cadPasseio.add(txtVelMax);
		cadPasseio.add(lbQtPistao);
		cadPasseio.add(txtQtPistao);
		cadPasseio.add(lbPotencia);
		cadPasseio.add(txtPotencia);

		btCadastrar.setText("Cadastrar");
		cadPasseio.add(btCadastrar);
		btLimpar.setText("Limpar");
		cadPasseio.add(btLimpar);
		btSair.setText("Sair");
		cadPasseio.add(btSair);

		// função botao
		btCadastrar.addActionListener(interPass);
		btLimpar.addActionListener(interPass);
		btSair.addActionListener(interPass);

		cadPasseio.setVisible(true);

	}

	public static void telaConsultarExcluirPasseioPlaca() {
		int lagura = 340;
		int altura = 300;
		consExcadPasseio.setSize(lagura, altura);
		consExcadPasseio.setLayout(new FlowLayout());

		consExcadPasseio.setLocationRelativeTo(null);
		consExcadPasseio.setTitle("Consultar / Excluir pela placa");

		lbPlaca.setText("Informe a Placa: ");
		txtPlacaCons.setText(null);
		lbQtPasseg.setText("Qtd. Passageiros: ");
		txtQtPassageiro.setText(null);
		lbMarca.setText("Marca: ");
		txtMarca.setText(null);
		lbModelo.setText("Modelo: ");
		txtModelo.setText(null);
		lbCor.setText("Cor: ");
		txtCor.setText(null);
		lbQtRodas.setText("Qtd. Rodas: ");
		txtQtRodas.setText(null);
		lbVelMax.setText("Velocidade Max: ");
		txtVelMax.setText(null);
		lbQtPistao.setText("Qtd. Pistões: ");
		txtQtPistao.setText(null);
		lbPotencia.setText("Potencia: ");
		txtPotencia.setText(null);

		consExcadPasseio.add(lbPlaca);
		consExcadPasseio.add(txtPlacaCons);
		consExcadPasseio.add(lbQtPasseg);
		consExcadPasseio.add(txtQtPassageiro);
		consExcadPasseio.add(lbMarca);
		consExcadPasseio.add(txtMarca);
		consExcadPasseio.add(lbModelo);
		consExcadPasseio.add(txtModelo);
		consExcadPasseio.add(lbCor);
		consExcadPasseio.add(txtCor);
		consExcadPasseio.add(lbQtRodas);
		consExcadPasseio.add(txtQtRodas);
		consExcadPasseio.add(lbVelMax);
		consExcadPasseio.add(txtVelMax);
		consExcadPasseio.add(lbQtPistao);
		consExcadPasseio.add(txtQtPistao);
		consExcadPasseio.add(lbPotencia);
		consExcadPasseio.add(txtPotencia);

		btConsultar.setText("Consultar");
		consExcadPasseio.add(btConsultar);
		btExcluir.setText("Excluir");
		consExcadPasseio.add(btExcluir);
		btLimpar.setText("Limpar");
		consExcadPasseio.add(btLimpar);
		btSair.setText("Sair");
		consExcadPasseio.add(btSair);

		// função botao
		btConsultar.addActionListener(interPass);
		btExcluir.addActionListener(interPass);
		btLimpar.addActionListener(interPass);
		btSair.addActionListener(interPass);

		consExcadPasseio.setVisible(true);
	}

	public static void consultaExcluiTodoPasseio() {
		int lagura = 450;
		int altura = 500;
		consExcTodosPasseio.setSize(lagura, altura);
		consExcTodosPasseio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consExcTodosPasseio.setLayout(new GridLayout(4, 1, 10, 10));
		consExcTodosPasseio.setLocationRelativeTo(null);
		consExcTodosPasseio.setTitle("Imprime / Excluir todos");
		consExcTodosPasseio.setExtendedState(JFrame.MAXIMIZED_BOTH); // Comando para deixar inicial maximizada
		consExcTodosPasseio.getContentPane().setBackground(Color.WHITE);
		consExcTodosPasseio.add(barraRolagem);
		btImprimirTodos.setText("Imprimir Todos");
		btImprimirTodos.setMnemonic('I');
		consExcTodosPasseio.add(btImprimirTodos);
		btExcluirTodos.setText("Excluir Todos");
		btExcluirTodos.setMnemonic('E');
		consExcTodosPasseio.add(btExcluirTodos);
		btSair.setText("Sair");
		consExcTodosPasseio.add(btSair);

		btImprimirTodos.addActionListener(interPass);
		btExcluirTodos.addActionListener(interPass);
		btSair.addActionListener(interPass);

		consExcTodosPasseio.setVisible(true);
	}

	// @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(btSair)) {
			cadPasseio.dispose();
			consExcadPasseio.dispose();
			consExcTodosPasseio.dispose();
		}
		if (evt.getSource().equals(btConsultar)) {
			placaPasseio = txtPlacaCons.getText();
			consultarPlacaPasseio();

		}
		if (evt.getSource().equals(btExcluir)) {
			BDVeiculos.setPlacaPasseio(txtPlacaCons.getText());
			BDVeiculos.excluirRegistroPorPlacaPasseio();

		}
		if (evt.getSource().equals(btCadastrar)) {
			if (!emprocessamento) {
				try {
					passeio = new Passeio();
					passeio.setPlaca(txtPlaca.getText());
					BDveic.validaPlacaPasseio(passeio.getPlaca());
					passeio.setMarca(txtMarca.getText());
					passeio.setModelo(txtModelo.getText());
					passeio.setCor(txtCor.getText());
					passeio.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
					passeio.getMotor().setQtdPist(Integer.parseInt(txtQtPistao.getText()));
					passeio.setQtdePassageiros(Integer.parseInt(txtQtPassageiro.getText()));
					passeio.setQtdRodas(Integer.parseInt(txtQtRodas.getText()));
					passeio.setVelocMax(Integer.parseInt(txtVelMax.getText()));
					BDveic.cadastrarVecPasseio(passeio);
					JOptionPane.showMessageDialog(null, "Cadastro finalizado com sucesso!!");
					emprocessamento = true;
					return;

				} catch (VeicExistException exi) {
					JOptionPane.showMessageDialog(null, "Ja existe um veiculo com essa placa ");
					emprocessamento = false;
					return;

				}

				catch (VelocException e) {
					JOptionPane.showMessageDialog(null,
							"A velocidade maxima esta fora dos limites brasileiros!! \n Cadastro finalizado com sucesso!!");
					try {
						passeio.setVelocMax(100);
						BDveic.cadastrarVecPasseio(passeio);
						emprocessamento = true;
						return;
					} catch (VelocException e1) {
						emprocessamento = true;
						return;

					}
				}

			}
			emprocessamento = false;
		}

		if (evt.getSource().equals(btLimpar)) {
			txtPlaca.setText(null);
			txtPlacaCons.setText(null);
			txtQtPassageiro.setText(null);
			txtMarca.setText(null);
			txtModelo.setText(null);
			txtCor.setText(null);
			txtQtRodas.setText(null);
			txtVelMax.setText(null);
			txtQtPistao.setText(null);
			txtPotencia.setText(null);
		}
		if (evt.getSource().equals(btImprimirTodos)) {
			imprimeTodosPasseio();

		}
		if (evt.getSource().equals(btExcluirTodos)) {
			if (excluirTodosDadosPasseio()) {
				JOptionPane.showMessageDialog(null, "Dados removidos", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel model = new DefaultTableModel(colunas, 0);
				viewPasseio.setModel(model);
			}
		}
	}

	public void imprimeTodosPasseio() {
		if (!emprocessamento) {
			if (BDveic.getBDPas().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não há veículos de passeio cadastrados.", "ERRO",
						JOptionPane.ERROR_MESSAGE);
				emprocessamento = false;
			} else {
				model = new DefaultTableModel(colunas, 0);

				for (Passeio passeio : BDveic.getBDPas()) {

					String[] dados = { passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(), passeio.getCor(),
							String.valueOf(passeio.getQtdRodas()), String.valueOf(passeio.getVelocMax()),
							String.valueOf(passeio.getMotor().getQtdPist()),
							String.valueOf(passeio.getMotor().getPotencia()),
							String.valueOf(passeio.getQtdePassageiros()) };
					model.addRow(dados);

				}
				viewPasseio.setModel(model);
			}
		}
	}

	public boolean excluirTodosDadosPasseio() {
		Passeio p = new Passeio();

		for (int i = 0; i < BDveic.getBDPas().size(); i++) {
			if (BDveic.getBDPas().get(i) != null) {

				BDveic.getBDPas().removeAll(BDveic.getBDPas());
				JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!!");
				break;
			}

		}

		return true;
	}

	// metodo para consultar por placa veiculo passeio
	public static void consultarPlacaPasseio() {
		boolean existPlacaPasseio = false;
		for (int i = 0; i < BDveic.getBDPas().size(); i++) {
			if (BDveic.getBDPas().get(i) != null) {
				if (BDveic.getBDPas().get(i).getPlaca().equalsIgnoreCase(placaPasseio)) {
					// retornando valores
					txtPlacaCons.setText(BDveic.getBDPas().get(i).getPlaca());
					txtQtPassageiro.setText(Integer.toString(BDveic.getBDPas().get(i).getQtdePassageiros()));
					txtMarca.setText(BDveic.getBDPas().get(i).getMarca());
					txtModelo.setText(BDveic.getBDPas().get(i).getModelo());
					txtCor.setText(BDveic.getBDPas().get(i).getCor());
					txtQtRodas.setText(Integer.toString(BDveic.getBDPas().get(i).getQtdRodas()));
					txtVelMax.setText(Integer.toString(BDveic.getBDPas().get(i).getVelocMax()));
					txtQtPistao.setText(Integer.toString(BDveic.getBDPas().get(i).getMotor().getQtdPist()));
					txtPotencia.setText(Integer.toString(BDveic.getBDPas().get(i).getMotor().getPotencia()));

					existPlacaPasseio = true;
					break;
				}
			} else {
				break;
			}

		}

		if (!existPlacaPasseio) {
			JOptionPane.showMessageDialog(null, "Não existe veiculo de passeio com essa placa!!");
		}
	}

}
