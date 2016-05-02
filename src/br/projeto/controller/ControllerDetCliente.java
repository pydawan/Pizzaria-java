package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.projeto.model.Cliente;
import br.projeto.view.FormDetCliente;

public class ControllerDetCliente {
	FormDetCliente form;
	Cliente c;
	
	public ControllerDetCliente(Cliente cliente) {
		/*Essa classe é responsavel pela edição dos dados de um funcionário já existente
		 * onde o ControllerGridCliente chamará esta classe passando o cliente selecionado
		 * 
		 * O layout do form dessa classe é idêntico ao do cadastro, só muda o texto de um botão
		 * Classe Vinculada : FormDetCliente*/
		
		c = new Cliente();
		c = cliente;
		form = new FormDetCliente();
		chargeScreen(); 
		validacaoDeCamposNulos();
		
	}
	
	private void chargeScreen(){ //Carregar a janela co os dados do cliente selecionado
		form.txtNome.setText(c.getNome());
		form.txtEnd.setText(c.getEndereco());
		form.txtTel.setText(c.getTelefone());
	}
	
	private void validacaoDeCamposNulos(){
		form.btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*Verificar se não há nehum campo vazio ou nulo, para evitar armazenamento de dados nulos no cadastro*/
				if ((form.txtNome.getText() == null || form.txtNome.getText().trim().isEmpty()) ||
						(form.txtEnd.getText() == null || form.txtEnd.getText().trim().isEmpty()) ||
						(form.txtTel.getText() == null || form.txtTel.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos !");
				} else {
					initEvents();
				}
			}
		});
	}
	
	private void initEvents(){ //Esse método só será chamado se os dados não forem nulos
		c.setNome(form.txtNome.getText());
		c.setEndereco(form.txtEnd.getText());
		c.setTelefone(form.txtTel.getText());
		form.setVisible(false);
		JOptionPane.showMessageDialog(null, "Edição concluida !");
	}

}
