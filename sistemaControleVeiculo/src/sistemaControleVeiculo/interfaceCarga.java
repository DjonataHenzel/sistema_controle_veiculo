package sistemaControleVeiculo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class interfaceCarga implements ActionListener {
	private static String placaCarga;
	private boolean emprocessamento = false;
	private static Carga carga = new Carga();
	private static BDVeiculos BDveic = new BDVeiculos();
	private static interfaceCarga interCarga = new interfaceCarga();
	private static JFrame cadCarga = new JFrame();
	private static JFrame consExcadCarg = new JFrame();
	private static JFrame consExcTodosCarga = new JFrame();
	private static JButton btLimpar = new JButton();
	private static JButton btCadastrar = new JButton();
	private static JButton btConsultar = new JButton();
	private static JButton btExcluir = new JButton();
	private static JButton btSair = new JButton();
	private static JButton btImprimirTodos = new JButton();
	private static JButton btExcluirTodos = new JButton();
	private static JLabel lbTara = new JLabel();
	private static JLabel lbPlaca = new JLabel();
	private static JLabel lbCargMax = new JLabel();
	private static JLabel lbMarca = new JLabel();
	private static JLabel lbModelo = new JLabel();
	private static JLabel lbCor = new JLabel();
	private static JLabel lbQtRodas = new JLabel();
	private static JLabel lbVelMax = new JLabel();
	private static JLabel lbQtPistao = new JLabel();
	private static JLabel lbPotencia = new JLabel();

	private static JTextField txtTara = new JTextField(21);
	private static JTextField txtPlaca = new JTextField(21);
	private static JTextField txtPlacaCons = new JTextField(18);
	private static JTextField txtCargaMax = new JTextField(19);
	private static JTextField txtMarca = new JTextField(20);
	private static JTextField txtModelo = new JTextField(22);
	private static JTextField txtCor = new JTextField(22);
	private static JTextField txtQtRodas = new JTextField(19);
	private static JTextField txtVelMax = new JTextField(18);
	private static JTextField txtQtPistao = new JTextField(19);
	private static JTextField txtPotencia = new JTextField(20);

	private static String[] colunas = { "Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Veloc Max", "Qtd Pistão",
			"Potencia", "Tara", "Carga Max" };
	private static DefaultTableModel model = new DefaultTableModel(colunas, 10);
	private static JTable viewCarga = new JTable(model);
	private static JScrollPane barraRolagem = new JScrollPane(viewCarga);

	public static void cadastroVeiculoCarga() {
		int lagura = 340;
		int altura = 350;
		cadCarga.setSize(lagura, altura);
		cadCarga.setLayout(new FlowLayout());
		cadCarga.setLocationRelativeTo(null);
		cadCarga.setTitle("Cadastro de carga");

		lbTara.setText("Tara: ");
		txtTara.setText(null);
		lbCargMax.setText("Carga Max: ");
		txtCargaMax.setText(null);
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

		cadCarga.add(lbTara);
		cadCarga.add(txtTara);
		cadCarga.add(lbCargMax);
		cadCarga.add(txtCargaMax);
		cadCarga.add(lbPlaca);
		cadCarga.add(txtPlaca);
		cadCarga.add(lbMarca);
		cadCarga.add(txtMarca);
		cadCarga.add(lbModelo);
		cadCarga.add(txtModelo);
		cadCarga.add(lbCor);
		cadCarga.add(txtCor);
		cadCarga.add(lbQtRodas);
		cadCarga.add(txtQtRodas);
		cadCarga.add(lbVelMax);
		cadCarga.add(txtVelMax);
		cadCarga.add(lbQtPistao);
		cadCarga.add(txtQtPistao);
		cadCarga.add(lbPotencia);
		cadCarga.add(txtPotencia);

		btCadastrar.setText("Cadastrar");
		cadCarga.add(btCadastrar);
		btLimpar.setText("Limpar");
		cadCarga.add(btLimpar);
		btSair.setText("Sair");
		cadCarga.add(btSair);

		// função botao
		btCadastrar.addActionListener(interCarga);
		btLimpar.addActionListener(interCarga);
		btSair.addActionListener(interCarga);

		cadCarga.setVisible(true);

	}

	public static void consultaExcluiCargaPlaca() {
		int lagura = 340;
		int altura = 350;
		consExcadCarg.setSize(lagura, altura);
		consExcadCarg.setLayout(new FlowLayout());

		consExcadCarg.setLocationRelativeTo(null);
		consExcadCarg.setTitle("Consultar / Excluir pela placa");

		lbPlaca.setText("Informe a Placa: ");
		txtPlacaCons.setText(null);
		lbTara.setText("Tara: ");
		txtTara.setText(null);
		lbCargMax.setText("Carga Max: ");
		txtCargaMax.setText(null);
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

		consExcadCarg.add(lbPlaca);
		consExcadCarg.add(txtPlacaCons);
		consExcadCarg.add(lbTara);
		consExcadCarg.add(txtTara);
		consExcadCarg.add(lbCargMax);
		consExcadCarg.add(txtCargaMax);
		consExcadCarg.add(lbMarca);
		consExcadCarg.add(txtMarca);
		consExcadCarg.add(lbModelo);
		consExcadCarg.add(txtModelo);
		consExcadCarg.add(lbCor);
		consExcadCarg.add(txtCor);
		consExcadCarg.add(lbQtRodas);
		consExcadCarg.add(txtQtRodas);
		consExcadCarg.add(lbVelMax);
		consExcadCarg.add(txtVelMax);
		consExcadCarg.add(lbQtPistao);
		consExcadCarg.add(txtQtPistao);
		consExcadCarg.add(lbPotencia);
		consExcadCarg.add(txtPotencia);

		btConsultar.setText("Consultar");
		consExcadCarg.add(btConsultar);
		btExcluir.setText("Excluir");
		consExcadCarg.add(btExcluir);
		btLimpar.setText("Limpar");
		consExcadCarg.add(btLimpar);
		btSair.setText("Sair");
		consExcadCarg.add(btSair);

		// função botao
		btConsultar.addActionListener(interCarga);
		btExcluir.addActionListener(interCarga);
		btLimpar.addActionListener(interCarga);
		btSair.addActionListener(interCarga);

		consExcadCarg.setVisible(true);
	}

	public static void consultaExcluiTodoCarga() {
		int lagura = 450;
		int altura = 500;
		consExcTodosCarga.setSize(lagura, altura);

		consExcTodosCarga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consExcTodosCarga.setLayout(new GridLayout(4, 1, 10, 10));
		consExcTodosCarga.setLocationRelativeTo(null);
		consExcTodosCarga.setTitle("Imprime / Excluir todos");
		consExcTodosCarga.setExtendedState(JFrame.MAXIMIZED_BOTH); // Comando para deixar inicial maximizada
		consExcTodosCarga.getContentPane().setBackground(Color.WHITE);
		consExcTodosCarga.add(barraRolagem);
		btImprimirTodos.setText("Imprimir Todos");
		btImprimirTodos.setMnemonic('I');
		consExcTodosCarga.add(btImprimirTodos);
		btExcluirTodos.setText("Excluir Todos");
		btExcluirTodos.setMnemonic('E');
		consExcTodosCarga.add(btExcluirTodos);
		btSair.setText("Sair");
		consExcTodosCarga.add(btSair);

		btImprimirTodos.addActionListener(interCarga);
		btExcluirTodos.addActionListener(interCarga);
		btSair.addActionListener(interCarga);

		consExcTodosCarga.setVisible(true);
	}

	// @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(btSair)) {
			cadCarga.dispose();
			consExcadCarg.dispose();
			consExcTodosCarga.dispose();
		}
		if (evt.getSource().equals(btConsultar)) {
			placaCarga = txtPlacaCons.getText();
			consultarPlacaCarga();

		}
		if (evt.getSource().equals(btExcluir)) {
			BDVeiculos.setPlacaCarga(txtPlacaCons.getText());
			BDVeiculos.excluirRegistroPorPlacaCarga();
		}
		if (evt.getSource().equals(btCadastrar)) {
			if (!emprocessamento) {
				try {
					carga = new Carga();
					carga.setPlaca(txtPlaca.getText());
					BDveic.validaPlacaCarga(carga.getPlaca());
					carga.setMarca(txtMarca.getText());
					carga.setModelo(txtModelo.getText());
					carga.setCor(txtCor.getText());
					carga.getMotor().setPotencia(Integer.parseInt(txtPotencia.getText()));
					carga.getMotor().setQtdPist(Integer.parseInt(txtQtPistao.getText()));
					carga.setCargaMax(Integer.parseInt(txtCargaMax.getText()));
					carga.setTara(Integer.parseInt(txtTara.getText()));
					carga.setQtdRodas(Integer.parseInt(txtQtRodas.getText()));
					carga.setVelocMax(Integer.parseInt(txtVelMax.getText()));
					BDveic.cadastrarVecCarga(carga);
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
						carga.setVelocMax(100);
						BDveic.cadastrarVecCarga(carga);
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
			txtTara.setText(null);
			txtCargaMax.setText(null);
			txtMarca.setText(null);
			txtModelo.setText(null);
			txtCor.setText(null);
			txtQtRodas.setText(null);
			txtVelMax.setText(null);
			txtQtPistao.setText(null);
			txtPotencia.setText(null);
		}

		if (evt.getSource().equals(btImprimirTodos)) {
			imprimeTodosCarga();

		}
		if (evt.getSource().equals(btExcluirTodos)) {
			if (excluirTodosDadosCarga()) {

				JOptionPane.showMessageDialog(null, "Dados removidos", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel model = new DefaultTableModel(colunas, 0);
				viewCarga.setModel(model);
			}

		}
	}

	public void imprimeTodosCarga() {
		if (!emprocessamento) {
			if (BDveic.getBDCarg().isEmpty())
				JOptionPane.showMessageDialog(null, "Não há veículos de passeio cadastrados.", "ERRO",
						JOptionPane.ERROR_MESSAGE);
			emprocessamento = false;
		} else {
			model = new DefaultTableModel(colunas, 0);

			for (Carga carga : BDveic.getBDCarg()) {

				String[] dados = { carga.getPlaca(), carga.getMarca(), carga.getModelo(), carga.getCor(),
						String.valueOf(carga.getQtdRodas()), String.valueOf(carga.getVelocMax()),
						String.valueOf(carga.getMotor().getQtdPist()), String.valueOf(carga.getMotor().getPotencia()),
						String.valueOf(carga.getTara()), String.valueOf(carga.getCargaMax()) };
				model.addRow(dados);

			}
			viewCarga.setModel(model);
		}
	}

	

	public boolean excluirTodosDadosCarga() {
		Carga c = new Carga();

		for (int i = 0; i < BDveic.getBDCarg().size(); i++) {
			if (BDveic.getBDCarg().get(i) != null) {

				BDveic.getBDCarg().removeAll(BDveic.getBDCarg());
				JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!!");
				break;
			}

		}

		return true;
	}

	// metodo para consultar por placa veiculo carga
	public static void consultarPlacaCarga() {
		boolean existPlacaCarga = false;
		for (int i = 0; i < BDveic.getBDCarg().size(); i++) {
			if (BDveic.getBDCarg().get(i) != null) {
				if (BDveic.getBDCarg().get(i).getPlaca().equalsIgnoreCase(placaCarga)) {
					// retornando valores
					txtPlacaCons.setText(BDveic.getBDCarg().get(i).getPlaca());
					txtTara.setText(Integer.toString(BDveic.getBDCarg().get(i).getTara()));
					txtCargaMax.setText(Integer.toString(BDveic.getBDCarg().get(i).getCargaMax()));
					txtMarca.setText(BDveic.getBDCarg().get(i).getMarca());
					txtModelo.setText(BDveic.getBDCarg().get(i).getModelo());
					txtCor.setText(BDveic.getBDCarg().get(i).getCor());
					txtQtRodas.setText(Integer.toString(BDveic.getBDCarg().get(i).getQtdRodas()));
					txtVelMax.setText(Integer.toString(BDveic.getBDCarg().get(i).getVelocMax()));
					txtQtPistao.setText(Integer.toString(BDveic.getBDCarg().get(i).getMotor().getQtdPist()));
					txtPotencia.setText(Integer.toString(BDveic.getBDCarg().get(i).getMotor().getPotencia()));

					existPlacaCarga = true;
					break;
				}
			} else {
				break;
			}

		}

		if (!existPlacaCarga) {
			JOptionPane.showMessageDialog(null, "Não existe veiculo de passeio com essa placa!!");
		}
	}

}
