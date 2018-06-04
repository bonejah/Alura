package br.com.ejb.remoto;

import javax.naming.InitialContext;

public class Cliente {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		Servico servico = (Servico) context.lookup("ejb:Servico/ServicoBean!br.com.ejb.remoto.Servico");
		servico.executa();
	}
}
