package br.com.caelum.jms.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteProducerTopic {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination topico = (Destination) context.lookup("loja");
		
		MessageProducer producer = session.createProducer(topico);
		Message message = session.createTextMessage("Enviando a 1� mensagem");
		message.setBooleanProperty("ebook",false);
		
		producer.send(message);
	
		//new Scanner(System.in).nextLine();
		
		session.close();
		connection.close();
		context.close();
	}	
}
