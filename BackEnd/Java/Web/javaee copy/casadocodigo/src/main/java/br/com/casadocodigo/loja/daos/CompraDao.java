package br.com.casadocodigo.loja.daos;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Compra;

@Stateful
public class CompraDao {

	@PersistenceContext
    private EntityManager manager;

    public void salvar(Compra compra) {
        manager.persist(compra);
    }

	public Compra buscarPorUuid(String uuid) {
		return manager.createQuery("select c from Compra c where c.uuid = :uuid", Compra.class)
				.setParameter("uuid", uuid).getSingleResult();
	}
	
}
