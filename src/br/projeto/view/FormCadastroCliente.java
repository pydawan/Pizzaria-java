package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class FormCadastroCliente extends JFrame {
	
	/*Essa classe é uma simples janela onde sua principal função é
	 * pegar os valores dos seus três campos e armazená-los num ArrayList através
	 * de seu controller respectivo
	 * 
	 * Classe Vinculada : ControllerCadastro*/
	
	JLabel lblNome, lblEnd, lblTel;
	public JTextField txtNome, txtEnd;
	public JFormattedTextField txtTel;
	MaskFormatter mskTel;
	
	public JButton btnCadastrar, btnLimpar, btnCancelar;
	
	public FormCadastroCliente(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar");
		
		iniciarTela();
		iniciarEventos();
		
		setSize(318, 200);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(30,144,255)); //DodgerBlue
		
		lblNome = new JLabel("Nome:"); //Nome
		lblNome.setForeground(new Color(240,248,255)); //AliceBlue
		lblNome.setBounds(20, 20, 80, 20);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(140, 20, 150, 20);
		add(txtNome);
		
		lblEnd = new JLabel("Endereço:"); //Endereço
		lblEnd.setForeground(new Color (240,248,255));
		lblEnd.setBounds(20, 50, 100, 20);
		add(lblEnd);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(140, 50, 150, 20);
		add(txtEnd);
		
		lblTel = new JLabel("Telefone:"); //Telefone
		lblTel.setForeground(new Color (240,248,255));
		lblTel.setBounds(20, 80, 100, 20);
		add(lblTel);
		
		try {
			mskTel = new MaskFormatter("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtTel = new JFormattedTextField(mskTel);
		txtTel.setBounds(140, 80, 150, 20);
		add(txtTel);
		
		btnCadastrar = new JButton("Cadastrar"); //Buttons
		btnCadastrar.setBackground(new Color (240,248,255)); //AliceBlue
		btnCadastrar.setBounds(10, 125, 95, 25);
		btnCadastrar.setToolTipText("Clique para concluir cadastro");
		add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color (240,248,255));
		btnLimpar.setBounds(108, 125, 95, 25);
		btnLimpar.setToolTipText("Clique para limpar todos os campos");
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color (240,248,255));
		btnCancelar.setBounds(206, 125, 95, 25);
		btnCancelar.setToolTipText("Clique para cancelar o cadastro");
		add(btnCancelar);
		
	}
	
	public void iniciarEventos(){
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtEnd.setText("");
				txtTel.setText("");
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
	
}
