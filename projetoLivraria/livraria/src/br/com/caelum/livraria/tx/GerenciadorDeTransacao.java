package br.com.caelum.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	EntityManager manager;
	
	@AroundInvoke
	public Object executaTx(InvocationContext context) throws Exception{
		manager.getTransaction().begin();
		
		// chama o m�todo do DAO que precisa de TX
		Object resultado = context.proceed();
		
		manager.getTransaction().commit();
		
		return resultado;
	}

}
