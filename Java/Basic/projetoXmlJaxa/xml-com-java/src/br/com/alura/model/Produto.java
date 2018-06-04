package br.com.alura.model;

public class Produto {
	private double preco;
	private String nome;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public double getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + " Preço: " + this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
