package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class TesteVelocity {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ProducerTemplate producer = context.createProducerTemplate();
		producer.sendBody("direct:entrada", "Apache Camel rocks!!!");
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("direct:entrada").
			    setHeader("data", constant("27/02/2017")).
			    to("velocity:template.vm").
			    log("${body}");
			}
		});

		context.start();
		Thread.sleep(2000);
		context.stop();
	}
}
