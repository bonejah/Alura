package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.LivroDataModel;
import br.com.caelum.livraria.tx.Log;
import br.com.caelum.livraria.tx.Transacional;

@Named
@ViewScoped
public class LivroBean implements Serializable {
	private static final long serialVersionUID = -8029728962033003378L;
	private Livro livro = new Livro();
	private Integer livroId;
	private Integer autorId;
	private List<Livro> livros;
	private LivroDataModel livroDataModel = new LivroDataModel();
	private List<String> generos = Arrays.asList("Romance", "Drama", "Ação");
	
	@Inject
	private AutorDao autorDao;
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private FacesContext context;
	
	public List<String> getGeneros() {
		return generos;
	}
	
	public LivroDataModel getLivroDataModel() {
		return livroDataModel;
	}
	
	public void setLivroDataModel(LivroDataModel livroDataModel) {
		this.livroDataModel = livroDataModel;
	}
	
	public Integer getLivroId() {
		return livroId;
	}
	
	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	@Log
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	
	@Log
	public List<Autor> getAutores(){
		return autorDao.listaTodos();
	}
	
	@Transacional
	@Log
	public void gravarAutor() {
		Autor autor = autorDao.buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
		System.out.println("Autor gravado: " + autor.getNome());
	}

	@Transacional
	@Log
	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			context.addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
			return;
		}
	
		if(this.livro.getId() == null) {
			livroDao.adiciona(this.livro);
			
			// Novo livro adicionado, listamos todos os livros novamente
			this.livros = livroDao.listaTodos();
		} else {
			livroDao.atualiza(this.livro);
		} 
		
		this.livro = new Livro();
	}
	
	@Transacional
	@Log
	public void removeLivro(Livro livro) {
		System.out.println("Removendo livro: " + livro.getTitulo());
		livroDao.remove(livro);
	}
	
	@Transacional
	@Log
	public void removeAutorDoLivro(Autor autor) {
		this.livro.removeAutor(autor);
	}
	
	public void carregaLivro(Livro livro) {
		this.livro = livroDao.buscaPorId(livro.getId());
	}
	
	@Log
	public List<Livro> getLivros(){				
		if(this.livros == null) {
			this.livros = livroDao.listaTodos();
		}
		
		return livros;
	}
	
	@Log
	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value)  throws ValidatorException {
		String valor = value.toString();
		if(!valor.startsWith("1")){
			throw new ValidatorException(new FacesMessage("ISBN Deveria começar com 1"));
		}
	}
	
	@Log
	public String formAutor() {
		System.out.println("Chamada do formulario do Autor");
		return "autor?faces-redirect=true";
	}
	
	@Log
	public void carregarLivroPelaId(){
		this.livro = livroDao.buscaPorId(livroId);
		
		if(this.livro == null) {
			this.livro = new Livro();
		}
	}
	
	@Log
	public boolean precoEhMenor(Object valorColuna, Object filtroDigitado, Locale locale) { // java.util.Locale
        //tirando espaços do filtro
        String textoDigitado = (filtroDigitado == null) ? null : filtroDigitado.toString().trim();

        System.out.println("Filtrando pelo " + textoDigitado + ", Valor do elemento: " + valorColuna);

        // o filtro é nulo ou vazio?
        if (textoDigitado == null || textoDigitado.equals("")) {
            return true;
        }

        // elemento da tabela é nulo?
        if (valorColuna == null) {
            return false;
        }

        try {
            // fazendo o parsing do filtro para converter para Double
            Double precoDigitado = Double.valueOf(textoDigitado);
            Double precoColuna = (Double) valorColuna;

            // comparando os valores, compareTo devolve um valor negativo se o value é menor do que o filtro
            return precoColuna.compareTo(precoDigitado) < 0;

        } catch (NumberFormatException e) {

            // usuario nao digitou um numero
            return false;
        }
	}
	
}
