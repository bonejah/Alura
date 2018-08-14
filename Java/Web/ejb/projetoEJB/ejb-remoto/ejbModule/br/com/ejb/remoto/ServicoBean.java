package br.com.ejb.remoto;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Servico.class)
public class ServicoBean implements Servico {
	@Override
	public void executa() {
		System.out.println("Recebendo chamada remota!!");
	}
}
