package br.com.bytebank.banco.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {
	
	public static void main(String[] args) {
		// Generics
		//List<Conta> lista = new Vector<Conta>(); // thread safe
		List<Conta> lista = new ArrayList<Conta>(); // nao thread safe
		
		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);
		
		System.out.println("Tamanho: " + lista.size());
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}
	}

}
