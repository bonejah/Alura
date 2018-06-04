package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.LivroDao;

@Named
@ViewScoped
public class LivroDataModel extends LazyDataModel<Livro> implements Serializable {
	private static final long serialVersionUID = -5406372211973770161L;
	
	/*@Inject
	private LivroDao livroDao;

	public LivroDataModel() {
	    super.setRowCount(livroDao.quantidadeDeElementos());
	}
	
	@Override
	public List<Livro> load(int inicio, int quantidade, String campoOrdenacao, 
			SortOrder sentidoOrdenacao, Map<String, Object> filtros) {
				return livroDao.listaTodosPaginada(inicio, quantidade);
	} */
}
