package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.projeto.model.Cliente;
import br.projeto.view.FormValidacao;

public class ControllerValidacao {
	
	/*Essa janela ser� a transi��o entre a janela principal do programa e 
	 * a o formul�rio de pedido, que s� ser� aberto se o nome do cliente
	 * estiver nos registros do sistema
	 * 
	 * Essa janela ser� aberta sempre que o usu�rio clicar em "Pedido R�pido"
	 * Sua fun��o � validar se o cliente existe, em caso positivo, a mesma
	 * chamar� a jenla de pedido, em caso negativo, n�o acontecer� nada (previs�o de mudan�a na vers�o 1.2)*/

	FormValidacao form;
	Cliente c;
	ControllerPedidoRapido formPR;
	
	public ControllerValidacao() {
		form = new FormValidacao();
		formPR = new ControllerPedidoRapido();
		c = new Cliente();
		
		iniciarEventos();
	}
	
	private void iniciarEventos(){
		form.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c.setNome(form.txtNome.getText()); //pegar nome para a valida��o
				
				for (int i = 0; i < ControllerCadastro.clienteDB.size(); i++) {
					/*Nesse caso, n�o utilizamos um foreach pois precisamos pegar o cliente de 
					 * determinado �nidce para setar seus dados no cabe�alho da janela de pedido*/
					
					if(c.equals(ControllerCadastro.clienteDB.get(i))){
						/*A propriedade "equals" compara apenas o nome do cliente, de acordo com a 
						 * sobrescrita do mesmo na classe "Cliente"*/
						c = ControllerCadastro.clienteDB.get(i);
						formPR.form.setVisible(true);
						formPR.form.lblNome.setText(c.getNome());
						formPR.form.lblEnd.setText(c.getEndereco());
						formPR.form.lblTel.setText(c.getTelefone());
						
						form.setVisible(false); //Sechar janela depois de abrir o JFrame do pedido
					}
				}
			}
		});
	}
	
}
