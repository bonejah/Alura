package br.com.alura.leitor.arquivos;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Properties;

public class Principal implements UncaughtExceptionHandler {
	public static void main(String[] args) {
		Properties properties = new Properties();
		Thread thread = new Thread(new LeitorPropriedades(properties, "arquivo.txt"));
		thread.setUncaughtExceptionHandler(new Principal());
		thread.start();
	}

	@Override
	public void uncaughtException(Thread thread, Throwable exception) {
		System.out.println("Exce��o " + exception + " capturada na Thread " + thread.getName());
	}
}
