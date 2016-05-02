package br.projeto.model;

public class Cliente {

	/* A finalidade dessa classe é armazenar todas a informações do cliente
	 * que serão settadas por classes do pacote view através de um ArrayList*/
	
	private String nome;
	private String endereco;
	private String telefone;
	private double totalGasto;
	
	public double getTotalGasto() {
		return totalGasto;
	}
	public void setTotalGasto(double totalGasto) {
		this.totalGasto = totalGasto;
	}
	
	public Cliente() {
	}
	public Cliente(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object o) {
		Cliente c = new Cliente();
		c = (Cliente) o;
		return (this.getNome().equals(c.getNome()));
	}

}
