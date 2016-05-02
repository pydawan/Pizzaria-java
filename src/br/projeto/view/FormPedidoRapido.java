package br.projeto.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.projeto.model.*;

public class FormPedidoRapido extends JFrame {
	
	/*Essa classe � uma das mais importantes para o programa
	 * Sua fun��o � exibir o valor dos itens na tela e armazenar numa vari�vel 
	 * do cliente atrav�s de seu controller respectivo
	 * 
	 * Classe Vinculada: ControllerPedidoRapido*/
	
	public JLabel lblNome, lblEnd, lblTel;
	JLabel lblPrecos, lblPizza, lblSuco, lblRefri;
	public JLabel lblPrecoPizza, lblPrecoSuco, lblPrecoRefri, lblPrecoTotal;
	public double precoPizza = 0;
	public double precoRefri = 0;
	public double precoSuco = 0;

	public JComboBox <Pizzas> cmbPizza;
	public JComboBox <Suco> cmbSuco;
	public JComboBox <Refrigerante> cmbRefri;
	
	public JCheckBox chkVip;
	
	public JTextField txtPrecoTotal;
	
	public JButton btnConfirmar, btnLimpar, btnCancelar, btnCalcular;
	
	public FormPedidoRapido() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Pedido R�pido");
		
		iniciarTela();
		iniciarEventos();
		
		setSize(620, 320);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(30,144,255)); //DodgerBlue
		
		lblNome = new JLabel();
		lblNome.setBounds(10, 10, 100, 20);
		lblNome.setForeground(new Color(25,25,112));
		add(lblNome);
		
		lblEnd = new JLabel();
		lblEnd.setBounds(250, 10, 150, 20);
		lblEnd.setForeground(new Color(25,25,112));
		add(lblEnd);
		
		lblTel = new JLabel();
		lblTel.setBounds(510, 10, 100, 20);
		lblTel.setForeground(new Color(25,25,112));
		add(lblTel);
		
		//Pedido
		lblPizza = new JLabel("Pizza:"); //Pizza
		lblPizza.setBounds(15, 70, 50, 20);
		lblPizza.setForeground(new Color(224,255,255));
		add(lblPizza);
		
		cmbPizza = new JComboBox <Pizzas>();
		cmbPizza.setBackground(new Color (240,248,255)); //AliceBlue
		cmbPizza.setBounds(65, 72, 130, 20);
		add(cmbPizza);
		
		lblPrecoPizza = new JLabel();
		lblPrecoPizza.setBounds(105, 105, 130, 20);
		lblPrecoPizza.setForeground(new Color(224,255,255));
		add(lblPrecoPizza);
		
		lblSuco = new JLabel("Suco:"); //Suco
		lblSuco.setBounds(215, 70, 50, 20);		
		lblSuco.setForeground(new Color(224,255,255));
		add(lblSuco);
		
		cmbSuco = new JComboBox <Suco>();
		cmbSuco.setBackground(new Color (240,248,255));
		cmbSuco.setBounds(265, 72, 130, 20);
		add(cmbSuco);
		
		lblPrecoSuco = new JLabel();
		lblPrecoSuco.setBounds(305, 105, 130, 20);
		lblPrecoSuco.setForeground(new Color(224,255,255));
		add(lblPrecoSuco);
		
		lblRefri = new JLabel("Refri:"); //Refri
		lblRefri.setBounds(415, 70, 50, 20);
		lblRefri.setForeground(new Color(224,255,255));
		add(lblRefri);
		
		cmbRefri = new JComboBox <Refrigerante>();
		cmbRefri.setBackground(new Color (240,248,255));
		cmbRefri.setBounds(465, 72, 130, 20);
		add(cmbRefri);
		
		lblPrecoRefri = new JLabel();
		lblPrecoRefri.setBounds(505, 105, 130, 20);
		lblPrecoRefri.setForeground(new Color(224,255,255));
		add(lblPrecoRefri);
		
		chkVip = new JCheckBox("Cliente VIP"); //CheckBox
		chkVip.setBounds(65, 150, 100, 20);
		chkVip.setBackground(new Color(30,144,255));
		chkVip.setForeground(new Color(224,255,255));
		add(chkVip);
		
		lblPrecoTotal = new JLabel("Total � pagar :"); //Pre�o Total
		lblPrecoTotal.setBounds(300, 150, 150, 20);
		lblPrecoTotal.setForeground(new Color(224,255,255));
		add(lblPrecoTotal);
		
		txtPrecoTotal = new JTextField();
		txtPrecoTotal.setEditable(false);
		txtPrecoTotal.setBounds(400, 151, 150, 20);
		txtPrecoTotal.setBackground(new Color(240,248,255));
		txtPrecoTotal.setForeground(new Color(25,25,112));
		txtPrecoTotal.setText("0.00");
		add(txtPrecoTotal);
		
		btnConfirmar = new JButton("Confirmar"); //Buttons
		btnConfirmar.setBounds(290, 230, 100, 30);
		btnConfirmar.setToolTipText("Confirmar pedido");
		btnConfirmar.setBackground(new Color(240,248,255));
		btnConfirmar.setEnabled(false);
		add(btnConfirmar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(392, 230, 100, 30);
		btnLimpar.setToolTipText("Limpar todos os campos");
		btnLimpar.setBackground(new Color(240,248,255));
		add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(494, 230, 100, 30);
		btnCancelar.setToolTipText("Cancelar pedido");
		btnCancelar.setBackground(new Color(240,248,255));
		add(btnCancelar);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(188, 230, 100, 30);
		btnCalcular.setToolTipText("Calcular valor do pedido");
		btnCalcular.setBackground(new Color(240,248,255));
		add(btnCalcular);
		
	}

	private void iniciarEventos(){
		
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				cmbPizza.setSelectedItem(null);
				cmbSuco.setSelectedItem(null);
				cmbRefri.setSelectedItem(null);
				chkVip.setSelected(false);
				txtPrecoTotal.setText("0.00");
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

