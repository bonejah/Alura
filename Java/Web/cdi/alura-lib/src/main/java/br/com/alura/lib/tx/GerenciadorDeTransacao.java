package br.com.alura.lib.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.alura.lib.tx.annotation.Transacional;

@Interceptor
@Transacional
public class GerenciadorDeTransacao implements Serializable {

	private static final long serialVersionUID = -3153443842236350470L;
	private EntityManager em;

	@Inject
	public GerenciadorDeTransacao(EntityManager em) {
		this.em = em;
	}

	@AroundInvoke
	public Object executaComTransacao(InvocationContext context) {
		em.getTransaction().begin();

		try {
			Object result = context.proceed();
			em.getTransaction().commit();
			return result;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
}
