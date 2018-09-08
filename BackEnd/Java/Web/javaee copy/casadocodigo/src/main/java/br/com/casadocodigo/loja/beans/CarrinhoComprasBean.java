package br.com.casadocodigo.loja.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.ItemVendido;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class CarrinhoComprasBean implements Serializable {
	
	private static final long serialVersionUID = 8233440565382840399L;

	@Inject
	private CarrinhoCompras carrinho;
	
	@Inject
	private LivroDao livroDao;

	public String add(Integer id) {
		System.out.println("Valor id: " + id);
		Livro livro = livroDao.buscarPorId(id);
		ItemVendido item = new ItemVendido(livro);
		carrinho.add(item);
		return "carrinho?faces-redirect=true";
	}
	
	public List<ItemVendido> getItens() {
	    return carrinho.getItens();
	}
	
	public void remover(ItemVendido item) {
		carrinho.remover(item);
	}
}
