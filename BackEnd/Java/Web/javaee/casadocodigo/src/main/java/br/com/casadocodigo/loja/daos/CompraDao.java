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
	
}
