package br.com.caelum.jms.test;

import java.io.Serializable;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.caelum.modelo.Pedido;

public class TesteConsumerComercialTopic {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.setClientID("comercial");
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topico = (Topic) context.lookup("loja");

		// MessageConsumer consumer = session.createConsumer(topico);
		MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura");
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				try {
					Pedido pedido = (Pedido) objectMessage.getObject();
					System.out.println(pedido.getCodigo());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// System.out.println("Recebendo a message: " + message);

		new Scanner(System.in).nextLine();

		session.close();
		connection.close();
		context.close();
	}
}
