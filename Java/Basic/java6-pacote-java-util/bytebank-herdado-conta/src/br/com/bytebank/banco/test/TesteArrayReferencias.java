package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {

	public static void main(String[] args) {
		Conta [] contas = new Conta[5];
		
		ContaCorrente cc1 = new ContaCorrente(22, 111);
		ContaPoupanca cp1 = new ContaPoupanca(22, 113);
		
		contas[0] = cc1;
		contas[1] = cp1;
		
		System.out.println(contas[0].getNumero());
		System.out.println(contas[1].getNumero());
		
		Conta ref = contas[1];
		System.out.println(ref.getNumero());
		
		ContaPoupanca cpRef = (ContaPoupanca)contas[1];
		System.out.println(cpRef.getNumero());
		
	}

}
