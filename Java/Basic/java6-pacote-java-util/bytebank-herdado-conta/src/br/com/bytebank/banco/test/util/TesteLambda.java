package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteLambda {

	public static void main(String[] args) {
		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Nico");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Guilherme");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Ana");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		System.out.println("Antes da ordena��o");
		for (Conta conta : lista) {
			System.out.println(conta);
		}

//		NumeroDaContaComparator comparator = new NumeroDaContaComparator();
//		TitularDaContaComparator tComparator = new TitularDaContaComparator();
//		lista.sort(comparator);
//		lista.sort(tComparator);

		lista.sort(new NumeroDaContaComparator());
	
		System.out.println("-------------------");

		System.out.println("Depois da ordena��o");
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		
		Collections.sort(lista, new TitularDaContaComparator());
		
		System.out.println("-------------------");
		System.out.println("Ordernando pelo nome utilizando Collections");
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		
		Collections.reverse(lista);		
		System.out.println("-------------------");
		System.out.println("Invertendo pelo nome utilizando Collections");
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		
		
		Collections.sort(lista);		
		System.out.println("-------------------");
		System.out.println("Ordenando pelo nome utilizando Collections");
		for (Conta conta : lista) {
			System.out.println(conta);
		}
	}

}

class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		String nomeC1 = c1.getTitular().getNome();
		String nomeC2 = c2.getTitular().getNome();
		return nomeC1.compareTo(nomeC2);
	}

}

class NumeroDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
//		if (c1.getNumero() < c2.getNumero()) {
//			return -1; // pode ser qualquer n� negativo ex: -35
//		}
//
//		if (c1.getNumero() > c2.getNumero()) {
//			return 1; // pode ser qualquer n� positivo ex: 100
//		}
//
//		return 0;
//		return c1.getNumero() - c2.getNumero();
		return Integer.compare(c1.getNumero(), c2.getNumero());
	}

}
