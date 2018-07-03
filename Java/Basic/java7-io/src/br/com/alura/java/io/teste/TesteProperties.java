package br.com.alura.java.io.teste;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TesteProperties {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("conf.properties"));
		
		String login = properties.getProperty("login");
		String senha = properties.getProperty("senha");
		String endereco = properties.getProperty("endereco");
		
		System.out.println(login + ", " + senha + ", " + endereco);
	}
}
