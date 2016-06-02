package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.projeto.controller.ControllerDetCliente;

public class FormDetCliente extends JDialog{ 
	
	/**
	 * @author Daniel
	 * @see ControllerDetCliente
	 * 
	 * Essa janela terá o mesmo layout da tela de cadastro, porém ela já subirá com os dados do cliente
	 * Quem chamará ela é o ControllerGridCliente, através do btnEditar
	 * Essa janela só será chamada quando o que chamar tiver um cliente como parâmetro*/

	JLabel lblNome, lblEnd, lblTel;
	public JTextField txtNome, txtEnd;
	public JFormattedTextField txtTel;
	MaskFormatter mskTel;
	
	public JButton btnOk, btnLimpar, btnCancelar;
	
	public FormDetCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Editar");
		
		iniciarTela();
		iniciarEventos();
		
		setSize(318, 200);
		setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(30,144,255));
		
		lblNome = new JLabel("Nome:"); //Nome
		lblNome.setForeground(new Color(240,248,255));
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
			mskTel = new MaskFormatter("(##) ####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTel = new JFormattedTextField(mskTel);
		txtTel.setBounds(140, 80, 150, 20);
		add(txtTel);
		
		btnOk = new JButton("Ok"); //Buttons
		btnOk.setBackground(new Color (240,248,255));
		btnOk.setBounds(10, 125, 95, 25);
		btnOk.setToolTipText("Clique para concluir a edição");
		add(btnOk);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color (240,248,255));
		btnLimpar.setBounds(108, 125, 95, 25);
		btnLimpar.setToolTipText("Clique para limpar todos os campos");
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color (240,248,255));
		btnCancelar.setBounds(206, 125, 95, 25);
		btnCancelar.setToolTipText("Clique para cancelar a edição");
		add(btnCancelar);
	}
	
	public void iniciarEventos(){
		btnLimpar.addActionListener(new ActionListener() { //Limpar campos
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtEnd.setText("");
				txtTel.setText("");
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() { //Fechar janela
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}
	
}
