package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaExcluiContato {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.findContato(3L);
		dao.remove(contato);
	}
}
