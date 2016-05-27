package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.Severity;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormValidacao extends JFrame {
	
	JLabel lblNome;
	public JTextField txtNome;
	public JButton btnOk, btnCancel;
	
	public FormValidacao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Validação");
		
		iniciarTela();
		iniciarEventos();
		
		setSize(318, 190);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(30,144,255));
		
		lblNome = new JLabel("Digite o nome do cliente:");
		lblNome.setBounds(85, 25, 150, 20);
		lblNome.setForeground(new Color(240,248,255));
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(40, 60, 230, 20);
		txtNome.setBackground(new Color(240,248,255));
		add(txtNome);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(40, 100, 114, 30);
		btnOk.setBackground(new Color(240,248,255));
		btnOk.setToolTipText("Clique para confirmar a validação");
		add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(156, 100, 114, 30);
		btnCancel.setBackground(new Color(240,248,255));
		btnCancel.setToolTipText("Clique para cancelar");
		add(btnCancel);
	}
	
	private void iniciarEventos(){
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
	}
	
	
	
}
