package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	public static void main(String[] args) {
		System.out.println("Preparando para gravar Contato!");
		Contato contato  = new Contato();
		contato.setNome("Leticia Lima");
		contato.setEmail("dadivajah@gmail.com");
		contato.setEndereco("Av. Celso Garcia");
		contato.setDataNascimento(Calendar.getInstance());
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		System.out.println("Contato GRAVADO!");
	}
}
