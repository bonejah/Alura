package br.com.caelum.jms.log;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;


public class TesteProducerQueue {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("LOG");

		MessageProducer producer = session.createProducer(fila);
		

		//for (int i = 0; i < 100; i++) {
			Message message = session.createTextMessage("LOG " + 1 + "ª mensagem");
			producer.send(message, DeliveryMode.NON_PERSISTENT, 3, 5000); 
			
			/*O modo padrão do ActiveMQ é PERSISTENT . Este modo guardar a mensagem em um banco de dados. 
			Caso o ActiveMQ tenha sido reiniciado, não haverá problema, pois ele recuperará a mensagem que foi salva. 
			O modo NON_PERSISTENT apagará todas as mensagem que não foram consumidas assim que o ActiveMQ reiniciar.
			
			O arquivo activemq.xml precisa ser alterado para configurar o suporte à fila. 
			Precisamos adicionar a configuração: <policyEntry queue=">" priorize="true"/>*/
			
		//}

		new Scanner(System.in).nextLine();

		session.close();
		connection.close();
		context.close();
	}
}
