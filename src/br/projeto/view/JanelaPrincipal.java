package br.projeto.view;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import br.projeto.controller.ControllerPrincipal;

public class JanelaPrincipal extends JFrame{
	
	/**
	 * @author Daniel
	 * @see ControllerPrincipal
	 * 
	 * A principal função dessa classe é apenas mandar a classe PrincipalController 
	 * chamar outros JFrames através de ActionListeners nos botões, onde cada um irá 
	 * chamar a classe com o nome correspondente
	 */

	JLabel lblTitulo, lblHora;
	public JButton btnPedidoRapido, btnCadastrar, btnListaDeClientes, btnAvancado;
	Date date = new Date();
	DateFormat formato = new SimpleDateFormat("HH:mm");
	String formattedDate = formato.format(date);
	
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Menu Principal");
		
		iniciarTela();
		
		setSize(300, 200);
		setResizable(false);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void iniciarTela(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(30,144,255));
		
		lblTitulo = new JLabel("PIZZA ICE");
		lblTitulo.setForeground(new Color(25,25,112)); 
		lblTitulo.setBounds(120,15,100,20);
		add(lblTitulo);
		
		lblHora = new JLabel(formattedDate);
		lblHora.setForeground(new Color(105,105,105));
		lblHora.setBounds(135, 140, 100, 20);
		add(lblHora);
		
		btnPedidoRapido = new JButton("Pedido Rápido");
		btnPedidoRapido.setBackground(new Color (240,248,255));
		btnPedidoRapido.setBounds(25, 50, 120, 30);
		btnPedidoRapido.setToolTipText("Selecione Se o Cliente Já Possuir Cadastro");
		add(btnPedidoRapido);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color (240,248,255));
		btnCadastrar.setBounds(25, 83, 120, 30);
		btnCadastrar.setToolTipText("Selecione Se o Cliente Não Possuir Cadastro");
		add(btnCadastrar);
		
		btnListaDeClientes = new JButton("Clientes");
		btnListaDeClientes.setBackground(new Color (240,248,255));
		btnListaDeClientes.setBounds(148, 50, 120, 30);
		btnListaDeClientes.setToolTipText("Selecione Para Ver Todos os Clientes Cadastrados");
		add(btnListaDeClientes);
		
		btnAvancado = new JButton("Avançado");
		btnAvancado.setBackground(new Color (240,248,255));
		btnAvancado.setBounds(148, 83, 120, 30);
		btnAvancado.setToolTipText("Selecione Para Visualizar o Relatório Da Pizzaria");
		add(btnAvancado);	
	}
	
}
