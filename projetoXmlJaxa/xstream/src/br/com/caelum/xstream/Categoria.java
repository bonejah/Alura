package br.com.caelum.xstream;

public class Categoria {
	private Categoria pai;
	private String nome;

	public Categoria(Categoria pai, String nome) {
		super();
		this.pai = pai;
		this.nome = nome;
	}

	public void setPai(Categoria geral) {
		this.pai = geral;
	}
}
