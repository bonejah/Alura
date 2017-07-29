package br.com.caelum.collections;
import java.util.List;

public class TestaCursos {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando Colecoes", "Paulo Silveira");
		
		List<Aula> aulas = javaColecoes.getAulas();
		System.out.println(aulas);
		
		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.getAulas().add(new Aula("Criando uma Aula", 20));
		javaColecoes.getAulas().add(new Aula("Modelando com colecoes", 24));
		System.out.println(aulas);
	}
}
