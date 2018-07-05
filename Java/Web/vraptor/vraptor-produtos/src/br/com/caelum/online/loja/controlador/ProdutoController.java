package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProdutoController {

	private final RepositorioDeProdutos produtos;
	private final Result result;
	private Validator validator;

	public ProdutoController(Result result, RepositorioDeProdutos produtos, Validator validator) {
		this.produtos = produtos;
		this.result = result;
		this.validator = validator;
	}

	@Path("/lista")
	public List<Produto> lista() {
		return produtos.pegaTodos();
	}

	@Path("/produto/{id}")
	public Produto exibe(long id) {
		return produtos.pegaPorId(id);
	}

	@Path("/formulario")
	public void formulario() {
	}

	@Post
	public void adiciona(final Produto produto) {
		// if(produto.getPreco() < 0) {
		// validator.add(new ValidationMessage("o preço deve ser maior que R$0.1",
		// "preco"));
		// validator.onErrorUsePageOf(ProdutoController.class).formulario();
		// }

		validator.checking(new Validations(){{
	        that(produto.getPreco() > 0.1,"erro", "produto.preco.invalido");
	    }});
		
		validator.onErrorUsePageOf(ProdutoController.class).formulario();

		produtos.salva(produto);
		result.include("mensagem", "Novo produto adicionado com sucesso!");
		// result.forwardTo(ProdutoController.class).lista(); // não usar fowardTo
		// PERIGO submeter novamente o form
		result.redirectTo(ProdutoController.class).lista();
	}

	@Path("/produto/{id}/xml")
	public void exibeComoXML(long id) {
		Produto produto = produtos.pegaPorId(id);
		result.use(Results.xml()).from(produto).serialize();
	}

	@Path("/produto/{id}/json")
	public void exibeComoJSON(long id) {
		Produto produto = produtos.pegaPorId(id);
		result.use(Results.json()).from(produto).serialize();
	}
	
	public void remove(Produto produto) {
		produtos.remove(produto);
		result.nothing();
	}
}
