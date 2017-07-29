package br.com.caelum.camel;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos2 {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));
		
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {				
				//errorHandler(deadLetterChannel("file:erro").
				errorHandler(deadLetterChannel("activemq:queue:pedido.DLQ").
						logExhaustedMessageHistory(true).
						maximumRedeliveries(3).
						redeliveryDelay(2000).
						onRedelivery(new Processor() {							
							@Override
							public void process(Exchange exchange) throws Exception {
								int counter = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_COUNTER);
								int max = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_MAX_COUNTER);
								System.out.println("Redelivery " + counter + "/" + max);
								
								if(counter == max) {
									System.out.println("Finalizou todas as tentativas de reenvio!");
								}
								
							}
						}));
				
				//from("file:pedidos?delay=5s&noop=true").
				from("activemq:queue:pedido").		
					routeId("rota-pedidos").
					to("validator:pedido.xsd").
					multicast().
						to("direct:http").
						to("direct:soap");

				from("direct:soap").
					routeId("rota-soap").
					to("xslt:pedido-para-soap.xslt").
					log("Resultado do template: ${body}").
					setHeader(Exchange.CONTENT_TYPE, constant("text/xml")).
					to("http4://localhost:8080/webservices/financeiro");					
				
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
				to("http4://localhost:8080/webservices/ebook/item");
				
			}
		});
		
		context.start();
		Thread.sleep(2000);
		context.stop();
	}
}
