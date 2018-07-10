package br.com.alura.hora.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.hora.model.Usuario;

@RequestScoped
public class UsuarioDAO {
	
	private EntityManager manager;
	
	public UsuarioDAO() {}
	
	@Inject
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
	}
	
	public List<Usuario> lista() {
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

}
