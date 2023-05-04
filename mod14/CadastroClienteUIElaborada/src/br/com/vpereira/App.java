package br.com.vpereira;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class App {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTable table;
	private JTextField txtTelefone;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private int rowSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 255, 255));
		frame.setResizable(false);
		frame.setBounds(100, 100, 720, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Menu
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemSair = new JMenuItem("Sair");
		menuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(
						menuItemSair, 
						"Deseja realmente sair ?", 
						"Sair", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(menuItemSair);
		frame.getContentPane().setLayout(null);
		
		//Tabela
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 176, 672, 247);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(){
	         /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	         }
	    };
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "Telefone", "CEP", "Cidade", "Estado"
			}
		));
		table.setToolTipText("");
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
			
		table.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 2) {     
	               JTable target = (JTable)me.getSource();
	               rowSelected = target.getSelectedRow(); 
	               //int column = target.getSelectedColumn(); 
	               setTextFilds(model, rowSelected);
	            }
	         }
	     });
		
		//Labels
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(16, 88, 52, 16);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(376, 16, 46, 16);
		frame.getContentPane().add(lblCEP);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(376, 52, 46, 16);
		frame.getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(376, 88, 46, 16);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(16, 16, 46, 16);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(16, 52, 46, 16);
		frame.getContentPane().add(lblCPF);
		
		//TextFields
		txtCEP = new JTextField();
		txtCEP.setBounds(432, 16, 240, 20);
		frame.getContentPane().add(txtCEP);
		txtCEP.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(76, 88, 240, 20);
		frame.getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(432, 52, 240, 20);
		frame.getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(432, 88, 240, 20);
		frame.getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(76, 16, 240, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(76, 52, 240, 20);
		frame.getContentPane().add(txtCPF);
		
		//Buttons
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTexts())
				{
					if(!getCliente(model, txtCPF.getText())) {
						model.addRow(new Object[]{txtNome.getText().trim(), txtCPF.getText().trim(), txtTelefone.getText().trim(), 
								txtCEP.getText().trim(), txtCidade.getText().trim(), txtEstado.getText().trim()});
						resetarTextFilds();
						JOptionPane.showMessageDialog(
								null, 
								"Cliente cadastrado com sucesso!", 
								"Cadastrar", 
								JOptionPane.INFORMATION_MESSAGE
								);
					}
					else 
					{
						JOptionPane.showMessageDialog(
								null, 
								"Cliente ja existe.", 
								"Cadastrar", 
								JOptionPane.INFORMATION_MESSAGE
								);
					}
				}
				else {
					JOptionPane.showMessageDialog(
							null, 
							"Preencha todos os campos.", 
							"Cadastrar", 
							JOptionPane.INFORMATION_MESSAGE
							);
				}
			}
		});
		btnCriar.setBounds(16, 136, 80, 24);
		frame.getContentPane().add(btnCriar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getTexts())
				{
					if(getCliente(model, txtCPF.getText())) {
						model.setValueAt(txtNome.getText().trim(), rowSelected, 0);
						model.setValueAt(txtCPF.getText().trim(), rowSelected, 1);
						model.setValueAt(txtTelefone.getText().trim(), rowSelected, 2);
						model.setValueAt(txtCEP.getText().trim(), rowSelected, 3);
						model.setValueAt(txtCidade.getText().trim(), rowSelected, 4);
						model.setValueAt(txtEstado.getText().trim(), rowSelected, 5);
						resetarTextFilds();
						JOptionPane.showMessageDialog(
								null, 
								"Cliente alterado com sucesso!", 
								"Alterar", 
								JOptionPane.INFORMATION_MESSAGE
								);
					}
					else 
					{
						JOptionPane.showMessageDialog(
								null, 
								"Naõ existe nenhum cliente com este cpf.", 
								"Alterar", 
								JOptionPane.INFORMATION_MESSAGE
								);
					}
				}
				else {
					JOptionPane.showMessageDialog(
							null, 
							"Preencha todos os campos.", 
							"Alterar", 
							JOptionPane.INFORMATION_MESSAGE
							);
				}
			}
		});
		btnAlterar.setBounds(112, 136, 80, 24);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getCliente(model, txtCPF.getText())) {
					int result = JOptionPane.showConfirmDialog(
							menuItemSair, 
							"Deseja realmente excluir este cliente ? Nome: " + model.getValueAt(rowSelected, 0) + " CPF: " + model.getValueAt(rowSelected, 1), 
							"Excluir", 
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE);
					if(result == JOptionPane.YES_OPTION)
					{
						model.removeRow(rowSelected);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(
							null, 
							"Naõ existe nenhum cliente com este cpf.", 
							"Excluir", 
							JOptionPane.INFORMATION_MESSAGE
							);
				}
			}
		});
		btnExcluir.setBounds(420, 136, 80, 24);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resposta = JOptionPane.showInputDialog(
						null, 
						"Escreve cpf do cliente",
						"Pesquisar", JOptionPane.INFORMATION_MESSAGE
						);
				if(getCliente(model, resposta)) {
					setTextFilds(model, rowSelected);
				}
				else {
					JOptionPane.showMessageDialog(
							null, 
							"Naõ existe nenhum cliente com este cpf.", 
							"Excluir", 
							JOptionPane.INFORMATION_MESSAGE
							);
				}
			}
		});
		btnPesquisar.setBounds(208, 136, 100, 24);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(
						menuItemSair, 
						"Deseja realmente limpar os dados ?", 
						"Limpar", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION)
				{
					resetarTextFilds();
				}
			}
		});
		btnLimpar.setBounds(324, 137, 80, 24);
		frame.getContentPane().add(btnLimpar);
	}
	
	public void resetarTextFilds() {
		txtNome.setText(null);
		txtCPF.setText(null);
		txtTelefone.setText(null);
		txtCEP.setText(null);
		txtCidade.setText(null);
		txtEstado.setText(null);
	}
	
	public void setTextFilds(DefaultTableModel model, int row) {
		txtNome.setText((String)model.getValueAt(row, 0));
        txtCPF.setText((String)model.getValueAt(row, 1));
	    txtTelefone.setText((String)model.getValueAt(row, 2));
	    txtCEP.setText((String)model.getValueAt(row, 3));
	    txtCidade.setText((String)model.getValueAt(row, 4));
	    txtEstado.setText((String)model.getValueAt(row, 5));
	}
	
	public boolean getCliente(DefaultTableModel model, String cpf) {
		for (int i = 0; i < model.getRowCount(); i++) {
			if(model.getValueAt(i, 1).equals(cpf.trim())){
				rowSelected = i;
				return true;
			}
		}
		return false;
	}
	
	public boolean getTexts() {
		if(!txtNome.getText().trim().equals("") && !txtCPF.getText().trim().equals("") &&  !txtTelefone.getText().trim().equals("") &&
				 !txtCEP.getText().trim().equals("") && !txtCidade.getText().trim().equals("") && !txtEstado.getText().trim().equals(""))
		{
			return true;
		}
		return false;
	}
}
