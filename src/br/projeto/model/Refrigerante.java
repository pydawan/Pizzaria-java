package br.projeto.model;

public enum Refrigerante {

	COCA(6.99), PEPSI(8.49), KUAT(5.49), SPRITE(5.49), FANTA(6.49), ITUBAINA(4.50), DOLLY(4.49);
	
	public double preco;
	
	private Refrigerante(double d) {
		preco = d; 
	}
	public double getValue(){
        return preco;
    }
	
}
