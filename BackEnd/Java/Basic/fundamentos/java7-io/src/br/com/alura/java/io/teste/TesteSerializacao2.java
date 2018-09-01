package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Cliente cliente = new Cliente();
		cliente.setNome("Bruno");
		cliente.setProfissao("Dev");
		cliente.setRg(1234);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
		oos.writeObject(cliente);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
        Cliente clientBin = (Cliente) ois.readObject();
        ois.close();
        System.out.println(clientBin);
		
		
		
	}
}
