package br.com.alura.algoritmosI;

public class Pessoa {
	private String nome;
	private double salario;

	public Pessoa(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", salario=" + salario + "]";
	}
}
