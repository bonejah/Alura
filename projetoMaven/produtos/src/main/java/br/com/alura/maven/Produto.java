package br.com.alura.maven;

public class Produto {
	private final String nome;
	private final double preco;
	private final String categoria = "Comida";

	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public double getPrecoComImposto() {
		return preco * 1.1;
	}
}
