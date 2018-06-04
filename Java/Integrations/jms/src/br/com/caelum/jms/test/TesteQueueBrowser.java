package br.com.caelum.jms.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class TesteQueueBrowser {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("financeiro");
		QueueBrowser queueBrowser = session.createBrowser((Queue) fila);
		
		while (queueBrowser.getEnumeration().hasMoreElements()) {
			TextMessage nextElement = (TextMessage) queueBrowser.getEnumeration().nextElement();
			System.out.println(nextElement.getText());
		}
	}

}
