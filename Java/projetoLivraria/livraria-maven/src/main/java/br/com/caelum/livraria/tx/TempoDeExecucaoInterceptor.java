package br.com.caelum.livraria.tx;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@SuppressWarnings("serial")
@Interceptor
@Log
public class TempoDeExecucaoInterceptor implements Serializable {

	@AroundInvoke
	public Object log(InvocationContext context) throws Exception {
		long inicio = System.currentTimeMillis();

		String metodo = context.getMethod().getName();

		Object proceder = context.proceed();

		long fim = System.currentTimeMillis();

		long resultado = fim - inicio;

		System.out.println("Método executado: " + metodo + " Tempo execução: "
				+ resultado);

		return proceder;
	}
}
