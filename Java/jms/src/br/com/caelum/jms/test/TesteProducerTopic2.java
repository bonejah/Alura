package br.com.caelum.jms.test;

import java.io.StringWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.xml.bind.JAXB;

import br.com.caelum.modelo.Pedido;
import br.com.caelum.modelo.PedidoFactory;

public class TesteProducerTopic2 {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination topico = (Destination) context.lookup("loja");
		
		Pedido pedido = new PedidoFactory().geraPedidoComValores();
		//StringWriter writer = new StringWriter();
		//JAXB.marshal(pedido, writer);
		//String xml = writer.toString();
		
		MessageProducer producer = session.createProducer(topico);
		
		//Message message = session.createTextMessage(xml);
		Message message = session.createObjectMessage(pedido);
		producer.send(message);
		
		session.close();
		connection.close();
		context.close();
	}	
}
