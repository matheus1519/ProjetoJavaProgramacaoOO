package apresentacao;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import modelo.Funcionario;
import persistencia.*;

import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class TelaFuncionario extends JInternalFrame 
{
	private JTextField tIdFuncionario, tNome, tCpf, tNascimento, tSalario, tFuncao,tPesquisa;
	private JTable tableResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFuncionario() {
		setClosable(true);
		setTitle("Gerenciar Funcion\u00E1rio");
		setSize(750,400);
		
		JPanel pPrincipal = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pPrincipal, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pPrincipal, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
		);
		
		JLabel lId = new JLabel("ID do Funcion\u00E1rio");
		lId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tIdFuncionario = new JTextField();
		tIdFuncionario.setEditable(false);
		tIdFuncionario.setColumns(10);
		
		JLabel lNome = new JLabel("Nome:");
		lNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tNome = new JTextField();
		tNome.setColumns(10);
		tNome.grabFocus();
		
		JLabel lCpf = new JLabel("CPF:");
		lCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lNascimento = new JLabel("Data de Nascimento:");
		lNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tCpf = new JTextField();
		tCpf.setColumns(10);
		
		tNascimento = new JTextField();
		tNascimento.setColumns(10);
		
		JPanel panel = new JPanel();
		
		tableResultado = new JTable();
		tableResultado.setFillsViewportHeight(true);
		tableResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableResultado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tIdFuncionario.setText((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),0));
				tNome.setText((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),1));
				tCpf.setText((String) tableResultado.getValueAt(tableResultado.getSelectedRow(),2));
				tNascimento.setText((String)tableResultado.getValueAt(tableResultado.getSelectedRow(),3));
				tSalario.setText(tableResultado.getValueAt(tableResultado.getSelectedRow(),4).toString());
				tFuncao.setText((String)tableResultado.getValueAt(tableResultado.getSelectedRow(),5));
			}
		});
		tableResultado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableResultado.setAutoscrolls(true);
		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "CPF", "Data de Nascimento", "Sal�rio", "Fun��o"
				}
			) {
				boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
			
		tableResultado.setModel(modelo);
		tableResultado.getColumnModel().getColumn(0).setPreferredWidth(53);
		tableResultado.getColumnModel().getColumn(1).setPreferredWidth(115);
		tableResultado.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableResultado.getColumnModel().getColumn(3).setPreferredWidth(98);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDescrio_1 = new JLabel("Cpf");
		lblDescrio_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPreo_1 = new JLabel("Nascimento");
		lblPreo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("Salario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tSalario = new JTextField();
		tSalario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fun\u00E7\u00E3o:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tFuncao = new JTextField();
		tFuncao.setColumns(10);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel label = new JLabel("Fun\u00E7\u00E3o");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_pPrincipal = new GroupLayout(pPrincipal);
		gl_pPrincipal.setHorizontalGroup(
			gl_pPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPrincipal.createSequentialGroup()
					.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pPrincipal.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lCpf)
								.addComponent(lNascimento)
								.addComponent(lNome)
								.addComponent(lId))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tIdFuncionario, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(tNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tCpf, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
								.addComponent(tNome)
								.addComponent(tSalario, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(tFuncao, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pPrincipal.createSequentialGroup()
									.addComponent(lblId)
									.addGap(31)
									.addComponent(lblNome_1)
									.addGap(45)
									.addComponent(lblDescrio_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblPreo_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(label))
								.addComponent(tableResultado, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pPrincipal.setVerticalGroup(
			gl_pPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPrincipal.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pPrincipal.createSequentialGroup()
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescrio_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPreo_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSalario, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tableResultado, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(Alignment.TRAILING, gl_pPrincipal.createSequentialGroup()
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(tIdFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lId))
							.addGap(18)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(tNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lNome))
							.addGap(18)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lCpf)
								.addComponent(tCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lNascimento)
								.addComponent(tNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(tSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_pPrincipal.createParallelGroup(Alignment.LEADING)
								.addComponent(tFuncao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addGap(1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnInserir = new JButton("Salvar");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tIdFuncionario.getText().equalsIgnoreCase(""))
				{
					if(!(tNome.getText().equals("") || tCpf.getText().equals("") || tNascimento.getText().equals("") || tSalario.getText().equals("")|| tFuncao.getText().equals("")))
					{
						Funcionario fun = new Funcionario(tNome.getText(), tCpf.getText(), tNascimento.getText(), Float.parseFloat(tSalario.getText()), tFuncao.getText());
						if(fun.salvar())
						{
							JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
							limpar();
							carregarTabela(modelo);
							tNome.grabFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erro ao Salvar");
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
						tNome.grabFocus();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Funcionario Existente!\nUse o bot�o 'Editar'");
				}
				
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Funcionario fun = new Funcionario(tIdFuncionario.getText(),tNome.getText(), tCpf.getText(), tNascimento.getText(), Float.parseFloat(tSalario.getText()), tFuncao.getText());
				if(fun.atualizar())
				{
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
					limpar();
					carregarTabela(modelo);
					tNome.grabFocus();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
				}
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tIdFuncionario.getText().equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela!");
				}
				else
				{
					int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse funcionario?\nA Exclus�o ser� permanente!", "Aten��o", JOptionPane.WARNING_MESSAGE);
					if(resposta == JOptionPane.YES_OPTION)
					{
						Funcionario fun = new Funcionario(tIdFuncionario.getText());
						if(fun.apagar())
						{
							JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
							limpar();
							carregarTabela(modelo);
							tNome.grabFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Erro ao Deletar");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Opera��o de apagar cancelada!");
					}
				}
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarTabela(modelo);
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tPesquisa = new JTextField();
		tPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				carregarTabelaPesquisa(modelo);
			}
		});
		tPesquisa.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnLimpar)
							.addGap(56)
							.addComponent(btnInserir)
							.addGap(60)
							.addComponent(btnEditar)
							.addGap(52)
							.addComponent(btnConsultar)
							.addGap(59)
							.addComponent(btnApagar))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPesquisar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tPesquisa, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPesquisar))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnApagar)
						.addComponent(btnConsultar)
						.addComponent(btnLimpar)
						.addComponent(btnInserir)
						.addComponent(btnEditar))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		pPrincipal.setLayout(gl_pPrincipal);
		getContentPane().setLayout(groupLayout);
		carregarTabela(modelo);
	}
	
	public void setPosicao() {
	    Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
	}
	
	public void limpar()
	{
		tIdFuncionario.setText("");
		tNome.setText("");
		tNascimento.setText("");
		tCpf.setText("");
		tFuncao.setText("");
		tSalario.setText("");
		tNome.grabFocus();
	}
	
	
	public void carregarTabela(DefaultTableModel modelo)
	{
		modelo.setRowCount(0);
		DMFuncionario dmFun = new DMFuncionario();
		for(Funcionario fun: dmFun.consultar())
		{
			modelo.addRow(new Object[] {
					fun.getIdFuncionario(),
					fun.getNome(),
					fun.getCpf(),
					fun.getDataNascimento(),
					fun.getSalario(),
					fun.getFuncao()
			});
		}
	}
	public void carregarTabelaPesquisa(DefaultTableModel modelo)
	{
		modelo.setRowCount(0);
		DMFuncionario dmFun = new DMFuncionario();
		for(Funcionario fun: dmFun.consultar(tPesquisa.getText()))
		{
			modelo.addRow(new Object[] {
					fun.getIdFuncionario(),
					fun.getNome(),
					fun.getCpf(),
					fun.getDataNascimento(),
					fun.getSalario(),
					fun.getFuncao()
			});
		}
	}
}
