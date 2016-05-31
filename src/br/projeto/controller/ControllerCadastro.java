package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.projeto.model.Cliente;
import br.projeto.view.FormCadastroCliente;

public class ControllerCadastro {
	
	/**
	 * @author Daniel
	 * @see FormCadastroCliente
	 * 
	 * A função dessa classe é pegar os valores que estiverem dentro dos campos de seu from respectivo
	 * e armazenar ele em variáveis de um objeto, sob as condições dos campos não estarem nulos e
	 * do cliente já existir*/
	
	FormCadastroCliente form;
	Cliente c;
	public static ArrayList <Cliente> clienteDB = new ArrayList<>();
	
	public ControllerCadastro() {
		form = new FormCadastroCliente();
		validacaoDeClienteExistente();
	}
	
	private void validacaoDeClienteExistente (){ 
		/*Verificar se já não há clientes cadastrados no programa
		 * Esse programa possui uma sobrescrita do método "equals" onde
		 * compara-se apenas o nome, e não o objeto inteiro*/ 
		
		form.btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c = new Cliente();
				c.setNome(form.txtNome.getText());
					if(clienteDB.contains(c)){
						JOptionPane.showMessageDialog(null, "Cliente já existe !");
					}else{
						validacaoDeCamposNulos();
					}
			}
		});
	}
	
	private void validacaoDeCamposNulos(){
        /*Verificar se não há nehum campo vazio ou nulo, para evitar armazenamento de dados nulos no cadastro*/
                if ((form.txtNome.getText() == null || form.txtNome.getText().trim().isEmpty()) ||
                        (form.txtEnd.getText() == null || form.txtEnd.getText().trim().isEmpty()) ||
                        (form.txtTel.getText() == null || form.txtTel.getText().trim().length() != 13))
                {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos !");
                } else {
                    eventosForm();
                }
            }
		 
	
	private void eventosForm(){
		/*Método que só será chamado depois das validações*/
				Cliente cliente = new Cliente();
				cliente.setNome(form.txtNome.getText());
				cliente.setEndereco(form.txtEnd.getText());
				cliente.setTelefone(form.txtTel.getText());
				clienteDB.add(cliente);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado !");
				form.setVisible(false);
			}
		
}

