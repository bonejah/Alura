package br.com.caelum.collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TesteListas {
	public static void main(String[] args) {
		System.out.println("**** ArrayList vs LinkedList");
		List<Integer> numerosArrayList = new ArrayList<>();
		List<Integer> numerosLinkedList = new LinkedList<>();
		int qtdeElementos = 1000000;
		
		long tempoArrayList = insereElementosNo(numerosArrayList, qtdeElementos);
		long tempoLinkedList = insereElementosNo(numerosLinkedList, qtdeElementos);
		
		System.out.println("Insercao na ArrayList demorou " + tempoArrayList);
		System.out.println("Insercao no LinkedList demorou " + tempoLinkedList);
		
		tempoArrayList = removePrimeirosElementosNo(numerosArrayList);
		tempoLinkedList = removePrimeirosElementosNo(numerosLinkedList);
		
		System.out.println("Remocao na ArrayList demorou " + tempoArrayList);
		System.out.println("Remocao no LinkedList demorou " + tempoLinkedList);
	}

	private static long removePrimeirosElementosNo(List<Integer> numeros) {
		long ini = System.currentTimeMillis();
		
		for (int i = 0; i < 100; i++) {
			numeros.remove(i);
		}
		
		long fim = System.currentTimeMillis();
		
		return fim - ini;
	}

	private static long insereElementosNo(List<Integer> numeros, int qtdeElementos) {
		long ini = System.currentTimeMillis();
		
		for (int i = 0; i < qtdeElementos; i++) {
			numeros.add(i);		
		}
		
		long fim = System.currentTimeMillis();
		return fim - ini;
	}	
}
