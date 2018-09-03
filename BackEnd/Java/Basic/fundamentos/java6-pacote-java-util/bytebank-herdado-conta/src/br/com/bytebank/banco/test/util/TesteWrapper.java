package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapper {

	public static void main(String[] args) {
		int idade = 29; // Integer
		Integer idadeRef = Integer.valueOf(idade); // AutoBoxing
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(idadeRef);
		
		
		
		System.out.println("Tamanho da lista: " + numeros.size());
		System.out.println("Pegando o valor do indice 0: " + numeros.get(0));
		System.out.println("Realizando unboxing: " + idadeRef.intValue()); // Unboxing
		
		System.out.println("Min value: " + Integer.MIN_VALUE);
		System.out.println("Max value: " + Integer.MAX_VALUE);
		System.out.println("Size: " + Integer.SIZE);
		System.out.println("Bytes: " + Integer.BYTES);
	}
}
