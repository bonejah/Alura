package br.com.bonejah.threads.lista;

public class Lista {
	private String[] elementos = new String[1000];
	private int indice = 0;

	public synchronized void adicionaElementos(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;
	}

	public int tamanho() {
		return this.elementos.length;
	}

	public String pegaElementos(int posicao) {
		return this.elementos[posicao];
	}
}
