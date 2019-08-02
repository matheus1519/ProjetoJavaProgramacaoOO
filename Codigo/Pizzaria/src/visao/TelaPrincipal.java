package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */	
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		
		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmGerenciarPedido = new JMenuItem("Gerenciar Pedido");
		mnPedido.add(mntmGerenciarPedido);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JMenuItem mntmGerenciarProduto = new JMenuItem("Gerenciar Produto");
		mntmGerenciarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProduto vProd = new TelaProduto();
				desktopPane.add(vProd);
				vProd.setVisible(true);
				vProd.setPosicao();
			}
		});
		mnProduto.add(mntmGerenciarProduto);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmGerenciarCliente = new JMenuItem("Gerenciar Cliente");
		mntmGerenciarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCliente vCli = new TelaCliente();
				desktopPane.add(vCli);
				vCli.setVisible(true);
				vCli.setPosicao();
			}
		});
		mnCliente.add(mntmGerenciarCliente);
		
		JMenu mnFuncionrio = new JMenu("Funcion\u00E1rio");
		menuBar.add(mnFuncionrio);
		
		JMenuItem mntmGerenciarFuncionrio = new JMenuItem("Gerenciar Funcion\u00E1rio");
		mnFuncionrio.add(mntmGerenciarFuncionrio);
		
		JMenu mnOutros = new JMenu("Outros");
		menuBar.add(mnOutros);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOutros.add(mntmSair);
	}
}
