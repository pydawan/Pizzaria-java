package br.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JOptionPane;

import br.projeto.model.Caixa;
import br.projeto.model.Cliente;
import br.projeto.model.Pizzas;
import br.projeto.model.Refrigerante;
import br.projeto.model.Suco;
import br.projeto.view.FormPedidoRapido;

public class ControllerPedidoRapido {
	
	/*Um dos principais controllers do projeto
	 * Só abrirá se já tiver um cliente cadastrado no sistema e se seu
	 * nome for digitado da maneira correta
	 * 
	 * Essa classe tem um objeto estático pois o mesmo objeto usa essa classe para a manipulação de eventos
	 * e carregar a tela com valores padrão que será usada em outro controller (ControllerPrincipal)
	 * 
	 * Sua função é pegar o valor de constantes de enums
	 * apresentá-los na janela, somar esses valores e armazená-lo na variável 
	 * totalGasto do objeto Cliente, tirando trechos irrelevantes e, por fim
	 * armazenar esse mesmo valor num "Caixa" do sistema
	 * 
	 * */
	
	public static FormPedidoRapido form;
	Cliente c = new Cliente();
	DecimalFormat df = new DecimalFormat();
	
	public ControllerPedidoRapido() {
		form = new FormPedidoRapido();
		iniciarEventos();
		carregarTela();
	}
	
	private Locale localeBrasil = new Locale("pt", "BR");
	private NumberFormat formatoMonetario = NumberFormat.getCurrencyInstance(localeBrasil);
	double precoSoma;
	
	// Método utilitário
	public double parseValor(String str){
	    Number valor = 0;
	    try {
	        valor = formatoMonetario.parse(str);
	    } catch (ParseException e) {
	    	e.getMessage();
	    }
	    return valor.doubleValue();
	}

	
	private void iniciarEventos(){ //Apresentar valor do item	
		//Se você tem amor a sua vida, nunca mais toque em nada desse método
		
		ControllerPedidoRapido.form.cmbPizza.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Pizzas p = (Pizzas) e.getItem();
					ControllerPedidoRapido.form.lblPrecoPizza.setText(formatoMonetario.format(p.getValue()));
				} else {
					ControllerPedidoRapido.form.lblPrecoPizza.setText(formatoMonetario.format(0));
				}
			}
		});
		
		ControllerPedidoRapido.form.cmbSuco.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Suco s = (Suco) e.getItem();
					ControllerPedidoRapido.form.lblPrecoSuco.setText(formatoMonetario.format(s.getValue()));
				}else{
					ControllerPedidoRapido.form.lblPrecoSuco.setText(formatoMonetario.format(0));				}
			}
		});
		
		ControllerPedidoRapido.form.cmbRefri.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Refrigerante r = (Refrigerante) e.getItem();
					ControllerPedidoRapido.form.lblPrecoRefri.setText(formatoMonetario.format(r.getValue()));
				}else{
					ControllerPedidoRapido.form.lblPrecoRefri.setText(formatoMonetario.format(0));
				}
			}
		});
		
		ControllerPedidoRapido.form.btnCalcular.addActionListener(new ActionListener() { //Apresentar soma dos produtos
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControllerPedidoRapido.form.precoPizza = parseValor(ControllerPedidoRapido.form.lblPrecoPizza.getText());
				ControllerPedidoRapido.form.precoSuco = parseValor(ControllerPedidoRapido.form.lblPrecoSuco.getText());
				ControllerPedidoRapido.form.precoRefri = parseValor(ControllerPedidoRapido.form.lblPrecoRefri.getText());
				precoSoma = ControllerPedidoRapido.form.precoPizza 
						+ ControllerPedidoRapido.form.precoSuco + ControllerPedidoRapido.form.precoRefri; 
				
				ControllerPedidoRapido.form.txtPrecoTotal.setText(formatoMonetario.format(precoSoma));
				
				if(ControllerPedidoRapido.form.chkVip.isSelected()){
					double desconto = (precoSoma)*0.15;
					precoSoma -= desconto;
					ControllerPedidoRapido.form.txtPrecoTotal.setText(formatoMonetario.format(precoSoma));
				}
				ControllerPedidoRapido.form.btnConfirmar.setEnabled(true);
			}
		});
		
		ControllerPedidoRapido.form.btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControllerPrincipal.caixa.setPrecoTotal(ControllerPrincipal.caixa.getPrecoTotal() +
						precoSoma);
				ControllerPedidoRapido.form.setVisible(false);
				JOptionPane.showMessageDialog(null ,"Pedido realizado com sucesso !");
			}
		});
		
	}
	
	private void carregarTela(){ //Carregar JComboBox com Enums
		
		for(Pizzas pizza : Pizzas.values()){
			ControllerPedidoRapido.form.cmbPizza.addItem(pizza);
		}
		for(Suco suco : Suco.values()){
			ControllerPedidoRapido.form.cmbSuco.addItem(suco);
		}
		for(Refrigerante refri : Refrigerante.values()){
			ControllerPedidoRapido.form.cmbRefri.addItem(refri);
		}
	}
	
}
