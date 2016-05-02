package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.projeto.model.Caixa;
import br.projeto.model.Cliente;
import br.projeto.view.JanelaGridCliente;
import br.projeto.view.JanelaPrincipal;

public class ControllerPrincipal {
	
	/*A principal fun��o desse Controller � abrir outros Controllers de outras janelas
	 * e no caso do "btnPedidoRapido, carregar alguns valores � janela, quando a mesma abrir [linha 53]*/
	
	JanelaPrincipal form;
	ControllerPedidoRapido formPedido;
	Cliente c = new Cliente(); //Foi criado esse cliente apenas para uma valida��o [linha 45]
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
			/*A principal fun��o desse m�todo � chamar a Janela de Pedido apenas
			 * se o cliente j� for cadastrado, se for, ele abre j� setando os dados
			 * do cliente no topo da janela, caso contr�rio, ele n�o abrir� a janela*/
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nome = JOptionPane.showInputDialog("Digite o nome do cliente :");
				c.setNome(nome);
				for (int i = 0; i < ControllerCadastro.clienteDB.size(); i++) {
				/*Nesse caso, o "for" substitui o "contains" do ArrayList pois n�s precisaremos pegar certos
				 * dados desse objeto, como nome, Endere�o e cpf. Coisa que seria impossivel com o "contains",
				 * j� que o mesmo retorna um boolean, e n�o um objeto ... */
					
					if(c.equals(ControllerCadastro.clienteDB.get(i))){ 
						/*[Resolver] Por raz�es desconhecidas, quando o usu�rio clica em cancelar na janela do JOptionPane
						 * O programa acusa NullPointerException na condi��o acima, e na linha 51 da classe modelo Cliente
						 * o que n�o faz sentido, pois todos os objetos usados s�o instanciados ... */
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
			/*Chamar janela onde est�o alguns registros e a op��o de zerar os registros*/
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControllerJanelaAvancado();
			}
		});
		
	}
	
}
