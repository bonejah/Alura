package br.com.caelum.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestaRecibo {
	public static void main(String[] args) {
		Recibo recibo1 = new Recibo("recibo1");
		Recibo recibo2 = new Recibo("recibo2");
		
		Set<Recibo> recibos = new TreeSet<Recibo>();
		recibos.add(recibo1);
		recibos.add(recibo2);
		
		System.out.println(recibos);
		System.out.println("=====================================");
		
		System.out.println("Utilizando Java 8");
		recibos.forEach(recibo -> {
			System.out.println(recibo);
		});
		
		System.out.println("=====================================");
		
		System.out.println("Utilizando Java 5");
		for (Recibo recibo : recibos) {
			System.out.println(recibo);
		}
		
		System.out.println("=====================================");
		
		System.out.println("Utilizando Java 1.2");
		Iterator<Recibo> iterator = recibos.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		System.out.println("=====================================");
	}
}
