package br.com.alura.algoritmosI;

public class BuscaMaiorMenorSalario {
	public static void main(String[] args) {
		Pessoa pessoa[] = { new Pessoa("Fernando", 3200), 
				new Pessoa("Alfredo", 6000), new Pessoa("Flavio", 5000),
				new Pessoa("Marcela", 2200) };
		
		int menorSalario = buscaMenorSalario(pessoa);
		System.out.println("O menor salário é: " + pessoa[menorSalario]);
		
		int maiorSalario = buscaMaiorSalario(pessoa);
		System.out.println("O maior salário é: " + pessoa[maiorSalario]);
		
	}

	private static int buscaMaiorSalario(Pessoa[] pessoa) {
		int maiorSalario = 0;
		int termino = pessoa.length - 1;
		
		for (int salarioAtual = 0; salarioAtual <= termino; salarioAtual++) {
			if(pessoa[salarioAtual].getSalario() > pessoa[maiorSalario].getSalario()) {
				maiorSalario = salarioAtual;
			}
		}
		
		return maiorSalario;
	}

	private static int buscaMenorSalario(Pessoa[] pessoa) {
		int menorSalario = 0;
		int termino = pessoa.length - 1;
		
		for (int salarioAtual = 0; salarioAtual <= termino; salarioAtual++) {
			if(pessoa[salarioAtual].getSalario() < pessoa[menorSalario].getSalario()) {
				menorSalario = salarioAtual;
			}
		}
		
		return menorSalario;
	}
}
