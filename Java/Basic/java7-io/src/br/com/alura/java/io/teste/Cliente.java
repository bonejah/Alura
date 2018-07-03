package br.com.alura.java.io.teste;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 5744123521558940146L;
	private String profissao;
	private int rg;
	private String nome;

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public int getRg() {
		return rg;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Cliente [profissao=" + profissao + ", rg=" + rg + ", nome=" + nome + "]";
	}

}
