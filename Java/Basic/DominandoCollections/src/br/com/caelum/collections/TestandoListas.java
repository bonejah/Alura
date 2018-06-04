package br.com.caelum.collections;
import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
	public static void main(String[] args) {
		String aula1 = "Modelando a classe Aula";
		String aula2 = "Conhecendo mais de listas";
		String aula3 = "Trabalhando com Cursor e Sets";
		
		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);		
		System.out.println(aulas);
		System.out.println("====================");
		
		aulas.remove(0);
		System.out.println(aulas);
		System.out.println("====================");
		
		for(String aula: aulas) {
			System.out.println("Aula: " + aula);
		}
		System.out.println("====================");
		
		String primeiraAula = aulas.get(0);
		System.out.println("Primeira aula:" + primeiraAula);
		System.out.println("====================");
		
		aulas.forEach(aula -> {
			System.out.println("Percorrendo:");
			System.out.println("Aula " + aula);
		});
		System.out.println("====================");
		
		Collections.sort(aulas);
		System.out.println(aulas);
		System.out.println("====================");
		
		
		
	}
}
