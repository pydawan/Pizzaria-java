package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.projeto.view.JanelaAvancado;

public class ControllerJanelaAvancado {
	/*A principal função dessa classe é
	 * setar alguns valores nos Txts de sua form e
	 * zerar os registros do ArrayList do programa*/
	
	JanelaAvancado form;
	
	public ControllerJanelaAvancado() {
		form = new JanelaAvancado();
		initEvents();
	}
	
	private void initEvents(){
		form.txtLucro.setText("R$ "+String.valueOf(ControllerPrincipal.caixa.getPrecoTotal())); //Mostrar lucro
		form.txtTotalCliente.setText(String.valueOf(ControllerCadastro.clienteDB.size()) + " clientes registrados"); //Mostrar quantidade de clientes
		
		form.btnResetar.addActionListener(new ActionListener() { //Limpar registros
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControllerCadastro.clienteDB.clear(); //Limpou ArrayList
				ControllerPrincipal.caixa.setPrecoTotal(0); //"Limpou" todos os lucros
				form.txtLucro.setText("R$ "+String.valueOf(ControllerPrincipal.caixa.getPrecoTotal())); 
				form.txtTotalCliente.setText(String.valueOf(ControllerCadastro.clienteDB.size()) + " clientes registrados");
			}
		});
	}
	
}
