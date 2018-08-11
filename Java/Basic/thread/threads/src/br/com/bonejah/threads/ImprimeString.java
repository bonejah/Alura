package br.com.bonejah.threads;

public class ImprimeString implements Runnable {
	@Override
	public void run() {
		System.out.println("resposta");
	}
}
