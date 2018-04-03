package br.com.bonejah.threads;

public class ImprimeNumeros {
	public static void main(String[] args) {
		new Thread(new TarefaNumeros()).start();
		new Thread(new TarefaNumeros()).start();
	}
}
