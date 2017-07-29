package br.com.caelum.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TesteFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Bruno Lima", 34);
		Funcionario f2 = new Funcionario("Leticia Lima", 32);
		Funcionario f3 = new Funcionario("Bianca Lima", 4);
		Funcionario f4 = new Funcionario("Matheus Lima", 1);
		
		Set<Funcionario> funcionarios = new TreeSet<>(new OrdenaPorIdade());
		funcionarios.add(f1);
		funcionarios.add(f2);
		funcionarios.add(f3);
		funcionarios.add(f4);
		
		Iterator<Funcionario> iterator = funcionarios.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
