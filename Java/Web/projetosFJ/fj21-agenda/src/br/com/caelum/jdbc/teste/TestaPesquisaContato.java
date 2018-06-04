package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisaContato {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.findContato(4L);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (contato != null) {
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			String dataString = sdf.format(contato.getDataNascimento().getTime());
			System.out.println("Data de Nascimento: " + dataString + "\n");
		} else {
			System.out.println("Contato não existe cadastrado na base de dados!!!");
		}
	}
}
