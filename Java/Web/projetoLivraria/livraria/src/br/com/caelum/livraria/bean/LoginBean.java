package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.tx.Log;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	
	@Inject
	UsuarioDao dao;
	
	@Inject
	FacesContext context;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	@Log
	public String efetuaLogin(){
		System.out.println("Fazendo login do usuario: " + this.usuario.getEmail());
		boolean existe = dao.existe(this.usuario);
		
		if(existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usu�rio n�o encontrado"));
		return "login?faces-redirect=true";
	}
	
	@Log
	public String deslogar (){
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
