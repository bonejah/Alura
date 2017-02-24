package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos2 {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:pedidos?delay=5s&noop=true").
					routeId("rota-pedidos").
					multicast().
						to("direct:http").
						to("direct:soap");

				from("direct:soap").
					routeId("rota-soap").
					log("Chamando serviço SOAP ${body}").
					to("mock:soap");
				
				from("direct:http").
					routeId("rota-http").
			    	setProperty("pedidoId", xpath("/pedido/id/text()")).
			    	setProperty("clienteId", xpath("/pedido/pagamento/email-titular/text()")).
			    	split().
			        	xpath("/pedido/itens/item").
				    filter().
				        xpath("/item/formato[text()='EBOOK']").
				    setProperty("ebookId", xpath("/item/livro/codigo/text()")).
				    log("${id} \n ${body}").
				    marshal().
				        xmljson().
				    setHeader(Exchange.HTTP_QUERY, 
				            simple("clienteId=${property.clienteId}&pedidoId=${property.pedidoId}&ebookId=${property.ebookId}")).
				to("http4://localhost:8080/ebook/item");
				
			}
		});
		
		context.start();
		Thread.sleep(2000);
		context.stop();
	}
}
