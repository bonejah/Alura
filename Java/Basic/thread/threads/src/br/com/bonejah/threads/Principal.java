package br.com.bonejah.threads;

public class Principal {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread MAIN --- Executando");
		Thread.sleep(3000);
		System.out.println("Thread MAIN --- Finalizando");
	}
}
 