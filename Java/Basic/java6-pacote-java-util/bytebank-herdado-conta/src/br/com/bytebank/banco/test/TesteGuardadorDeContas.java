package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class TesteGuardadorDeContas {

	public static void main(String[] args) {
		GuardadorDeContas guardadorDeContas = new GuardadorDeContas();
		
		Conta cc = new ContaCorrente(7, 8);
		guardadorDeContas.adiciona(cc);

		Conta cc2 = new ContaCorrente(7, 7);
		guardadorDeContas.adiciona(cc2);
		
		System.out.println(guardadorDeContas.getQuantidadeDeElementos());
		
		Conta ref = guardadorDeContas.getReferencia(0);
		System.out.println(ref.getNumero());
	}

}
