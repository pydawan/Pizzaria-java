package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.projeto.controller.ControllerJanelaAvancado;

public class JanelaAvancado extends JFrame{
	/**
	 * @author Daniel
	 * @see ControllerJanelaAvancado
	 * 
	 * Uma das classes menos importantes do programa
	 * sua principal função é apenas mostrar a quantidade de clientes cadastrados no sistema,
	 * mostrar os lucros da empresa, e dar a opção para o usuário de zerar todos os registros */
	
	JLabel lblTotalCliente, lblLucro;
	public JTextField txtTotalCliente, txtLucro;
	public JButton btnResetar, btnCancel;
	
	public JanelaAvancado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Avançado");
		
		initComponents();
		initEvents();
		
		setSize(300, 200);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initComponents(){
		setLayout(null);
		getContentPane().setBackground(new Color(30,144,255));
		
		lblTotalCliente = new JLabel("Total de clientes :"); //Labels
		lblTotalCliente.setBounds(15, 25, 100, 20);
		lblTotalCliente.setForeground(new Color(240,248,255));
		add(lblTotalCliente);
		
		lblLucro = new JLabel("Lucro da Pizzaria :"); 
		lblLucro.setBounds(15, 65, 120, 20);
		lblLucro.setForeground(new Color(240,248,255));
		add(lblLucro);
		
		txtTotalCliente = new JTextField(); //Texts
		txtTotalCliente.setBounds(125, 26, 150, 20);
		txtTotalCliente.setBackground(new Color(240,248,255));
		txtTotalCliente.setEditable(false);
		add(txtTotalCliente);
		
		txtLucro = new JTextField();
		txtLucro.setBounds(125, 66, 150, 20);
		txtLucro.setBackground(new Color(240,248,255));
		txtLucro.setEditable(false);
		add(txtLucro);
		
		btnResetar = new JButton("Resetar"); //Buttons
		btnResetar.setBounds(25, 120, 120, 40);
		btnResetar.setBackground(new Color(240,248,255));
		btnResetar.setToolTipText("Clique Para Resetar Todos os Registros - Cuidado! Essa Ação Não Pode Ser Desfeita !");
		add(btnResetar);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(147, 120, 120, 40);
		btnCancel.setBackground(new Color(240,248,255));
		btnCancel.setToolTipText("Clique para fechar");
		add(btnCancel);
	}
	
	private void initEvents(){
		
		btnCancel.addActionListener(new ActionListener() { //Fechar janela
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
	}
	
}
