package br.com.caelum.collections;

public class TestaCursoComAluno {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as colecoes em Java", "Bruno Lima");
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com colecoes", 24));
		
		Aluno a1  =new Aluno("Bruno Lima", 777);
		Aluno a2  =new Aluno("Leticia Lima", 555);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		
		System.out.println("Todos os alunos matriculados: ");
		javaColecoes.getAlunos().forEach(aluno -> {
			System.out.println(aluno);
		});
		
		System.out.println("O aluno " + a1.getNome() + " está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		
		Aluno bianca = new  Aluno("Bianca", 1111);
		System.out.println("O aluno " + bianca.getNome() + " está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(bianca));
		
	}

}
