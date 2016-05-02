package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.projeto.model.Caixa;
import br.projeto.model.Cliente;
import br.projeto.view.JanelaGridCliente;
import br.projeto.view.JanelaPrincipal;

public class ControllerPrincipal {
	
	/*A principal função desse Controller é abrir outros Controllers de outras janelas
	 * e no caso do "btnPedidoRapido, carregar alguns valores à janela, quando a mesma abrir [linha 53]*/
	
	JanelaPrincipal form;
	ControllerPedidoRapido formPedido;
	Cliente c = new Cliente(); //Foi criado esse cliente apenas para uma validação [linha 45]
	static Caixa caixa = new Caixa();
	
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
			/*A principal função desse método é chamar a Janela de Pedido apenas
			 * se o cliente já for cadastrado, se for, ele abre já setando os dados
			 * do cliente no topo da janela, caso contrário, ele não abrirá a janela*/
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("Digite o nome do cliente :");
				c.setNome(nome);
				for (int i = 0; i < ControllerCadastro.clienteDB.size(); i++) {
				/*Nesse caso, o "for" substitui o "contains" do ArrayList pois nós precisaremos pegar certos
				 * dados desse objeto, como nome, Endereço e cpf. Coisa que seria impossivel com o "contains",
				 * já que o mesmo retorna um boolean, e não um objeto ... */
					
					if(c.equals(ControllerCadastro.clienteDB.get(i))){ 
						/*[Resolver] Por razões desconhecidas, quando o usuário clica em cancelar na janela do JOptionPane
						 * O programa acusa NullPointerException na condição acima, e na linha 51 da classe modelo Cliente
						 * o que não faz sentido, pois todos os objetos usados são instanciados ... */
						formPedido = new ControllerPedidoRapido();
						ControllerPedidoRapido.form.lblNome.setText(nome);
						ControllerPedidoRapido.form.lblEnd.setText(ControllerCadastro.clienteDB.get(i).getEndereco());
						ControllerPedidoRapido.form.lblTel.setText(ControllerCadastro.clienteDB.get(i).getTelefone());
					}
				}	
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
