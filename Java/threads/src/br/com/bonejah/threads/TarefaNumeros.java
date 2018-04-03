package br.com.bonejah.threads;

public class TarefaNumeros implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {
			Thread threadAtual = Thread.currentThread();
			System.out.println("Número: " + i + " ID thread: " + threadAtual);
		}
	}
}
