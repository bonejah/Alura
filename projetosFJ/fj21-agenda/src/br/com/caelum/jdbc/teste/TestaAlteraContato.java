package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAlteraContato {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.findContato(3L);
		contato.setNome("Bianca Bernardo da Silva Lima");		
		dao.altera(contato);
	}
}
