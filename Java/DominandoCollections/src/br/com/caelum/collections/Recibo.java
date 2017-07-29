package br.com.caelum.collections;

public class Recibo implements Comparable<Recibo>{
	private String nome;

	public Recibo(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int compareTo(Recibo recibo) {
		return this.nome.compareTo(recibo.nome);
	}

	@Override
	public String toString() {
		return "Recibo [nome=" + nome + "]";
	}
}
