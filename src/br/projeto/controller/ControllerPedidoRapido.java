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
	
	public FormPedidoRapido form;
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
		
		form.cmbPizza.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Pizzas p = (Pizzas) e.getItem();
					form.lblPrecoPizza.setText(formatoMonetario.format(p.getValue()));
				} else {
					form.lblPrecoPizza.setText(formatoMonetario.format(0));
				}
			}
		});
		
		form.cmbSuco.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Suco s = (Suco) e.getItem();
					form.lblPrecoSuco.setText(formatoMonetario.format(s.getValue()));
				}else{
					form.lblPrecoSuco.setText(formatoMonetario.format(0));				}
			}
		});
		
		form.cmbRefri.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Refrigerante r = (Refrigerante) e.getItem();
					form.lblPrecoRefri.setText(formatoMonetario.format(r.getValue()));
				}else{
					form.lblPrecoRefri.setText(formatoMonetario.format(0));
				}
			}
		});
		
		form.btnCalcular.addActionListener(new ActionListener() { //Apresentar soma dos produtos
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				form.precoPizza = parseValor(form.lblPrecoPizza.getText());
				form.precoSuco = parseValor(form.lblPrecoSuco.getText());
				form.precoRefri = parseValor(form.lblPrecoRefri.getText());
				precoSoma = form.precoPizza 
						+ form.precoSuco + form.precoRefri; 
				
				form.txtPrecoTotal.setText(formatoMonetario.format(precoSoma));
				
				if(form.chkVip.isSelected()){
					double desconto = (precoSoma)*0.15;
					precoSoma -= desconto;
					form.txtPrecoTotal.setText(formatoMonetario.format(precoSoma));
				}
				form.btnConfirmar.setEnabled(true);
			}
		});
		
		form.btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControllerPrincipal.caixa.setPrecoTotal(ControllerPrincipal.caixa.getPrecoTotal() +
						precoSoma);
				form.setVisible(false);
				JOptionPane.showMessageDialog(null ,"Pedido realizado com sucesso !");
			}
		});
		
	}
	
	private void carregarTela(){ //Carregar JComboBox com Enums
		
		for(Pizzas pizza : Pizzas.values()){
			form.cmbPizza.addItem(pizza);
		}
		for(Suco suco : Suco.values()){
			form.cmbSuco.addItem(suco);
		}
		for(Refrigerante refri : Refrigerante.values()){
			form.cmbRefri.addItem(refri);
		}
	}
	
}
