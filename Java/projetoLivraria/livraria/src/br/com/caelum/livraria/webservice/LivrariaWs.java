package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService
//@Stateless
public class LivrariaWs {

	@Inject
	private LivroDao dao;

	@WebResult(name = "livros")
	public List<Livro> geTLivrosPeloNome(@WebParam(name = "titulo") String nome) {
		System.out.println("LivrariaWS: procurando pelo nome: " + nome);
		return dao.livrosPeloNome(nome);
	}
}
