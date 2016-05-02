package br.projeto.model;

public enum Suco {

	LARANJA(4.99), MARACUJA(3.99), UVA(4.99), CAJU(4.99), PERA(3.49), MANGA(3.99), ABACAXI(4.50);

	public double preco;
	
	private Suco(double d) {
		preco = d; 
	}
	public double getValue(){
        return preco;
    }
	
}
