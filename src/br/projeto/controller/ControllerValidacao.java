package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.projeto.model.Cliente;
import br.projeto.view.FormValidacao;

public class ControllerValidacao {
	
	/**
	 * @author Daniel
	 * @see FormValidacao
	 * @see ControllerPedidoRapido
	 * 
	 * Essa janela será a transição entre a janela principal do programa e 
	 * a o formulário de pedido, que só será aberto se o nome do cliente
	 * estiver nos registros do sistema
	 * 
	 * Essa janela será aberta sempre que o usuário clicar em "Pedido Rápido"
	 * Sua função é validar se o cliente existe, em caso positivo, a mesma
	 * chamará a jenla de pedido, em caso negativo, não acontecerá nada (previsão de mudança na versão 1.2)*/

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
		/**
		 * @author Daniel
		 * 
		 * Esse método será chamado sempre que o usuário clicar no botão Ok 
		 * para validar a condição do cliente*/
		
		form.btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c.setNome(form.txtNome.getText()); //pegar nome para a validação
				
				for (int i = 0; i < ControllerCadastro.clienteDB.size(); i++) {
					/* Nesse caso, não utilizamos um foreach pois precisamos pegar o cliente de 
					 * determinado ínidce para setar seus dados no cabeçalho da janela de pedido*/
					
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
