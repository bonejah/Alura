package br.com.alura.cap5.visitor;

public class Programa {
	
	// http://pt.wikipedia.org/wiki/Linguagem_de_dom%C3%ADnio_espec%C3%ADfico
	public static void main(String[] args) {
		Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
		Expressao direita = new Soma(new Numero(2), new Numero(10));
		Expressao conta = new Soma(esquerda, direita);
		
		int resultado = conta.avalia();
		System.out.println(resultado);
	}
}
