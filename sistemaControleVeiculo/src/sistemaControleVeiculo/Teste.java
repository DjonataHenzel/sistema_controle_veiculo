package sistemaControleVeiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Teste implements ActionListener {
	private static Passeio passeio;
	private static Carga carga;
	private static BDVeiculos BDveic = new BDVeiculos();

	// -------------------------Componentes menu--------------------
	private static JMenuBar menuBar = new JMenuBar();
	private static JMenuItem menuItemSair = new JMenuItem();
	private static JMenu menuPrincipal = new JMenu();
	private static JMenu subMenuPasseio = new JMenu();
	private static JMenuItem menuItemCadastrarPasseio = new JMenuItem();
	private static JMenuItem menuItemConsultExclPasseio = new JMenuItem();
	private static JMenuItem menuItemImpExlTodoPasseio = new JMenuItem();

	private static JMenu subMenuCarga = new JMenu();
	private static JMenuItem menuItemCadastrarCarga = new JMenuItem();
	private static JMenuItem menuItemConsultExclCarga = new JMenuItem();
	private static JMenuItem menuItemImpExlTodoCarga = new JMenuItem();

	// ------------------------ JFrame------------------------------
	static Teste telaHome = new Teste();

	static JFrame home = new JFrame();

	public static void main(String[] args) throws VelocException, VeicExistException {
		homePrincipal();
	}
	

	public static void homePrincipal() {
		int lagura = 450;
		int altura = 500;
		home.setSize(lagura, altura);
		home.setTitle("Gestão de veiculos");
		home.setVisible(true);
		home.setExtendedState(JFrame.MAXIMIZED_BOTH); // Comando para deixar inicial maximizada

		menuPrincipal.setText("Veiculos");
		menuItemSair.setText("Sair");
		subMenuPasseio.setText("Passeio");
		menuItemCadastrarPasseio.setText("Cadastrar");
		menuItemConsultExclPasseio.setText("Consultar / Excluir pela placa");
		menuItemImpExlTodoPasseio.setText("Imprimir / Excluir todos");

		subMenuCarga.setText("Carga");
		menuItemCadastrarCarga.setText("Cadastrar");
		menuItemConsultExclCarga.setText("Consultar / Excluir pela placa");
		menuItemImpExlTodoCarga.setText("Imprimir / Excluir todos");

		// -------------------Add menu e submenu---------------------
		menuBar.add(menuPrincipal);
		menuPrincipal.add(subMenuPasseio);
		subMenuPasseio.add(menuItemCadastrarPasseio);
		menuItemCadastrarPasseio.addActionListener(telaHome);
		subMenuPasseio.add(menuItemConsultExclPasseio);
		menuItemConsultExclPasseio.addActionListener(telaHome);
		subMenuPasseio.add(menuItemImpExlTodoPasseio);
		menuItemImpExlTodoPasseio.addActionListener(telaHome);

		menuPrincipal.add(subMenuCarga);
		subMenuCarga.add(menuItemCadastrarCarga);
		menuItemCadastrarCarga.addActionListener(telaHome);
		subMenuCarga.add(menuItemConsultExclCarga);
		menuItemConsultExclCarga.addActionListener(telaHome);
		subMenuCarga.add(menuItemImpExlTodoCarga);
		menuItemImpExlTodoCarga.addActionListener(telaHome);

		menuPrincipal.add(menuItemSair);
		menuItemSair.addActionListener(telaHome);
		home.setJMenuBar(menuBar);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(menuItemSair)) {
			System.exit(0);
		}

		if (evt.getSource().equals(menuItemCadastrarPasseio)) {
			interfacePasseio.cadastroVeiculoPasseio();

		}

		if (evt.getSource().equals(menuItemConsultExclPasseio)) {
			interfacePasseio.telaConsultarExcluirPasseioPlaca();
		}

		if (evt.getSource().equals(menuItemImpExlTodoPasseio)) {
			interfacePasseio.consultaExcluiTodoPasseio();
		}

		if (evt.getSource().equals(menuItemCadastrarCarga)) {
			interfaceCarga.cadastroVeiculoCarga();
		}
		if (evt.getSource().equals(menuItemConsultExclCarga)) {
			interfaceCarga.consultaExcluiCargaPlaca();

		}
		if (evt.getSource().equals(menuItemImpExlTodoCarga)) {
			interfaceCarga.consultaExcluiTodoCarga();
		}

	}

}
