package br.com.alura.servidor;

import java.lang.Thread.UncaughtExceptionHandler;

public class TratadorDeExcecao implements UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread thread, Throwable e) {
		System.out.println("Exce��o na thread " + thread.getName() + ", " + e.getMessage());
	}
}
