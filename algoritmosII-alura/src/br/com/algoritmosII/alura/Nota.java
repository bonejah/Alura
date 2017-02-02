package br.com.algoritmosII.alura;

public class Nota {
	public Nota(String aluno, double valor) {
		this.aluno = aluno;
		this.valor = valor;
	}

	public String getAluno() {
		return aluno;
	}

	public double getValor() {
		return valor;
	}

	private String aluno;
	private double valor;

}
