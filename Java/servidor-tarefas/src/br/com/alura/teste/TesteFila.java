package br.com.alura.teste;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TesteFila {
	public static void main(String[] args) throws InterruptedException {
		// capacidade de 3 elementos apenas
		BlockingQueue<String> fila = new ArrayBlockingQueue<>(3);
		
		fila.offer("c1");
		fila.offer("c2");
		fila.offer("c3");

//		System.out.println(fila.poll());
//		System.out.println(fila.poll());
//		System.out.println(fila.poll());
//		System.out.println(fila.poll());//devolve null
//		
		System.out.println(fila.take());
		System.out.println(fila.take());
		System.out.println(fila.take());
		System.out.println(fila.take());//devolve null

		System.out.println(fila.size());// imprime 0
	}
}
