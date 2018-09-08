package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import br.com.casadocodigo.loja.daos.CompraDao;
import br.com.casadocodigo.loja.service.PagamentoGateway;

@SessionScoped
@Named
public class CarrinhoCompras implements Serializable {

	private static final long serialVersionUID = 5910864974644971774L;

	private Set<ItemVendido> itens = new HashSet<>();

	@Inject
	private CompraDao compraDao;
	
	@Inject
	private PagamentoGateway pagamentoGateway;

	public void add(ItemVendido item) {
		itens.add(item);
	}

	public List<ItemVendido> getItens() {
		return new ArrayList<ItemVendido>(itens);
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (ItemVendido carrinhoItem : itens) {
			total = total
					.add(carrinhoItem.getLivro().getPreco().multiply(new BigDecimal(carrinhoItem.getQuantidade())));
		}

		return total;
	}

	public BigDecimal getTotal(ItemVendido item) {
		return item.getLivro().getPreco().multiply(new BigDecimal(item.getQuantidade()));
	}

	public void remover(ItemVendido item) {
		this.itens.remove(item);
	}

	public Integer getQuantidadeTotal() {
		return itens.stream().mapToInt(item -> item.getQuantidade()).sum();
	}

	public void finalizar(Compra compra) {
		compra.setItens(this.toJson());
		compra.setTotal(getTotal());
		compraDao.salvar(compra);
		
//		Forma sincrona de pagamento chamando o serviço
//		String resultado = pagamentoGateway.pagar(getTotal());
//		System.out.println(resultado);
	}

	private String pagar() {
		
		return null;
	}

	private String toJson() {
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (ItemVendido item : itens) {
	        builder.add(Json.createObjectBuilder()
	                .add("titulo", item.getLivro().getTitulo())
	                .add("preco", item.getLivro().getPreco())
	                .add("quantidade", item.getQuantidade())
	                .add("total", getTotal(item)));
	    }
		return builder.build().toString();
	}

}
