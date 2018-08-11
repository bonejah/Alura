package br.com.alura.algoritmosI;

public class BuscaMaiorMenorSalario {
	public static void main(String[] args) {
		Pessoa arrayPessoa[] = { new Pessoa("Fernando", 3200), 
				new Pessoa("Alfredo", 6000), new Pessoa("Flavio", 5000),
				new Pessoa("Marcela", 2200) };
		
		int menorSalario = buscaMenorSalario(arrayPessoa);
		System.out.println("O menor sal�rio �: " + arrayPessoa[menorSalario]);
		
		int maiorSalario = buscaMaiorSalario(arrayPessoa);
		System.out.println("O maior sal�rio �: " + arrayPessoa[maiorSalario]);
	}

	private static int buscaMaiorSalario(Pessoa[] arrayPessoa) {
		int maiorSalario = 0;
		int tamanhoArray = arrayPessoa.length - 1;
		
		for (int salarioAtual = 0; salarioAtual <= tamanhoArray; salarioAtual++) {
			if(arrayPessoa[salarioAtual].getSalario() > arrayPessoa[maiorSalario].getSalario()) {
				maiorSalario = salarioAtual;
			}
		}
		
		return maiorSalario;
	}

	private static int buscaMenorSalario(Pessoa[] arrayPessoa) {
		int menorSalario = 0;
		int tamanhoArray = arrayPessoa.length - 1;
		
		for (int salarioAtual = 0; salarioAtual <= tamanhoArray; salarioAtual++) {
			if(arrayPessoa[salarioAtual].getSalario() < arrayPessoa[menorSalario].getSalario()) {
				menorSalario = salarioAtual;
			}
		}
		
		return menorSalario;
	}
}
