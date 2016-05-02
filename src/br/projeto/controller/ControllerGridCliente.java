package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import br.projeto.model.Cliente;
import br.projeto.view.JanelaGridCliente;

public class ControllerGridCliente {
	
	/*Esse Controller fará alterações nos dados dos clientes que estão
	 * armazenados no ArrayList "clienteDB"
	 * Ele também fará a exclusão dos mesmos
	 */
	
	/*Fazer o grid carregar sem nenhuma linha selecionada e ativar botões
	quando o usuário selecionar qualquer linha*/
	
	JanelaGridCliente gridCliente;
	ControllerDetCliente formEdicao;
	
	public ControllerGridCliente() {
		gridCliente = new JanelaGridCliente();
		initEvents();
		chargeScreen();
		gridCliente.grid.clearSelection(); //Foi adicionado esse método para que o grid não venha com nenhuma linha slecionada
	}
	
	private void initEvents(){
		gridCliente.btnEditar.addActionListener(new ActionListener() { //Editar dados do Cliente
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridCliente.grid.getSelectedRow();
				Cliente c = ControllerCadastro.clienteDB.get(posicao); 
				/*Pega o índice do cliente que está armazenado através 
					do índice da linha selecionada do grid*/
				
				formEdicao = new ControllerDetCliente(c); 
				formEdicao.form.setVisible(true);//Abrir JDialog só depois que fez as mudanças necessárias
				
				if(formEdicao.c != null){ //Atualizar grid caso o usuário não tenha colocado dados nulos no cliente
					ControllerCadastro.clienteDB.set(posicao, c);
					refreshGrid(ControllerCadastro.clienteDB);
				}
				
			}
		});
		
		gridCliente.btnExcluir.addActionListener(new ActionListener() { //Excluir cliente selecionado
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridCliente.grid.getSelectedRow();
				ControllerCadastro.clienteDB.remove(posicao); //Exclui o cliente com indice correspondente
				((DefaultTableModel) gridCliente.grid.getModel()).removeRow(posicao); //Exclui a linha
			}
		});
		
	}
	
	public void chargeScreen(){ 
		/*Carregar janela, foi criado apenas para 
		não ter que ficar instanciando o mesmo arraylist toda hora*/
		
		refreshGrid(ControllerCadastro.clienteDB);
	}
	
	public void refreshGrid(ArrayList<Cliente> lista){ 
		/*Atualizar grid quando usuário fechar a tela de edição e/ou
			quando houverem clientes no arraylist*/
		
		int x = gridCliente.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridCliente.dtm.removeRow(x);
		}

		for (Cliente c : lista) {
			gridCliente.dtm.addRow(new Object[] { c.getNome(), c.getEndereco(), c.getTelefone() });
		}
		if (gridCliente.dtm.getRowCount() > 0) {
			gridCliente.grid.setRowSelectionInterval(0, 0);
		}
	}
	
}
