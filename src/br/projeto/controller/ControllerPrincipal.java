package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.projeto.model.Caixa;
import br.projeto.view.JanelaPrincipal;

public class ControllerPrincipal {
	
	/*A principal função desse Controller é abrir outros Controllers de outras janelas*/
	
	JanelaPrincipal form;
	ControllerPedidoRapido formPedido;
	static Caixa caixa = new Caixa();
	/*O objeto caixa é estático pois ele vai somar todos os valores pagos pelos clientes
	 * portanto, ele tem que estar sempre em execução*/
	
	public ControllerPrincipal() {
		form = new JanelaPrincipal();
		iniciarEventos();
	}
	
	private void iniciarEventos(){
		form.btnCadastrar.addActionListener(new ActionListener() {	
			/*Chamar tela de cadastro*/
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerCadastro();
			}
		});
		
		form.btnPedidoRapido.addActionListener(new ActionListener() {
			/*Chamar janela de validação de cliente registrado*/
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerValidacao();
			}
		});
		
		form.btnListaDeClientes.addActionListener(new ActionListener() {
			/*Chamar janela onde se encontram todos os clientes armazenados no sistema*/
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerGridCliente();
			}
		});
		
		form.btnAvancado.addActionListener(new ActionListener() {	
			/*Chamar janela onde estão alguns registros e a opção de zerar os registros*/
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerJanelaAvancado();
			}
		});
		
	}
	
}
