package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public class EstoqueWS {

	private ItemDao dao = new ItemDao();
	
	@WebMethod(operationName="cadastrarItem")
	@WebResult(name="item")
	public Item cadastrarItem(@WebParam(name="token", header=true)TokenUsuario token, @WebParam(name="item")Item item) throws AutorizacaoException {
		System.out.println("Cadastrando Item: " + item + ", token: " + token);
		
		if (! new TokenDao().ehValido(token)) {
			throw new AutorizacaoException("Autorizacao falhou");
		}
		
		new ItemValidador(item).validate();
		dao.cadastrar(item);
		return item;
	}
	
	@WebMethod(operationName="todosOsItensSemFiltro")
	@ResponseWrapper(localName="itens")
	@WebResult(name="item")
	public List<Item> getItensSemFiltro() {
		System.out.println("Chamando todosItens()");
		return dao.todosItens();
	}
	
	@WebMethod(operationName="todosOsItensComFiltro")
	@WebResult(name="itens")
	public ListaItens getItensComFiltro(@WebParam(name="filtros") Filtros filtros) {
		System.out.println("Chamando todosItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		return new ListaItens(itensResultado);
	}
		
	@WebMethod(exclude=true)
	public String metodoQueNaoSeraExpostoNoWSDL(){
		return "";
	}
}