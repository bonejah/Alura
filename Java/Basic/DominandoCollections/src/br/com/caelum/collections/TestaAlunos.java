package br.com.caelum.collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {
	public static void main(String[] args) {
		//Set<String> alunos = new HashSet<>();
		Collection<String> alunos = new HashSet<>();
		alunos.add("Bruno Lima");
		alunos.add("Leticia Lima");
		alunos.add("Matheus Lima");
		alunos.add("Bianca Lima");
		alunos.add("Nelia");
		alunos.add("Bianca Lima");
		
		for (String aluno : alunos) {
			System.out.println(aluno);
		}		
		
		System.out.println(alunos);
		
		boolean achouBruno = alunos.contains("Bruno Lima");
		System.out.println(achouBruno);
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
		System.out.println(alunosEmLista.get(4));
		
	}
}
