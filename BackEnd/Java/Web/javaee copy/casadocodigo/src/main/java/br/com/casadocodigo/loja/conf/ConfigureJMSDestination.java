package br.com.casadocodigo.loja.conf;

import javax.ejb.Singleton;
import javax.jms.JMSDestinationDefinition;

@JMSDestinationDefinition(
	    name="java:/jms/topics/CarrinhoComprasTopico",
	    interfaceName="javax.jms.Topic",
	    destinationName = "java:/jms/topics/CarrinhoComprasTopico"
	)

@Singleton
public class ConfigureJMSDestination {

}
