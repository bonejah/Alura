package br.com.caelum.collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {
	private static int qtde = 10000;
	
	public static void main(String[] args) {
		validaPerformanceHasSet();
		validaPerformanceArrayList();
	}
	
	private static void validaPerformanceHasSet() {
		System.out.println("******************************");
		System.out.println("Entrou no metodo validaPerformanceHasSet()");
		Collection<Integer> numeros = new HashSet<Integer>();
				
		long inicio = System.currentTimeMillis();

		for (int i = 0; i <= qtde; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		long fim = System.currentTimeMillis();

		long tempoExecucao = fim - inicio;

		System.out.println("Tempo gasto: " + tempoExecucao);
		System.out.println("Saindo no metodo validaPerformanceHasSet()");
		System.out.println("******************************");
	}

	private static void validaPerformanceArrayList() {
		System.out.println("******************************");
		System.out.println("Entrou no metodo validaPerformanceArrayList()");
		Collection<Integer> numeros = new ArrayList<Integer>();
				
		long inicio = System.currentTimeMillis();

		for (int i = 0; i <= qtde; i++) {
			numeros.add(i);
		}

		for (Integer numero : numeros) {
			numeros.contains(numero);
		}

		long fim = System.currentTimeMillis();

		long tempoExecucao = fim - inicio;

		System.out.println("Tempo gasto: " + tempoExecucao);
		System.out.println("Saindo no metodo validaPerformanceHasSet()");
		System.out.println("******************************");
	}

}
