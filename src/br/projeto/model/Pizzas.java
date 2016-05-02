package br.projeto.model;

public enum Pizzas {

	CALABRESA(25.99), MUSSARELA(25.99), PALMITO(19.99), PORTUGUESA(19.99), CATUPIRY(21.99), PROVOLONE(19.99), LOMBO(29.99);
	
	public double preco;
	
	private Pizzas(Double d) {
		preco = d; 
	}
	public double getValue(){
        return preco;
    }
	
}
