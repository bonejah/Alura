package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {
	
	public static void main(String[] args) throws IOException {
		// Padrão Decorator
		// BufferedReader> InputStreamReader > FileInputStream > lorem.txt
		
		// Somente lê bytes 
		FileInputStream fis = new FileInputStream("lorem.txt");
		// InputStream fis = new FileInputStream("lorem.txt");
		
		// Transformando bytes em caracteres
		InputStreamReader isr = new InputStreamReader(fis);
		//Reader isr = new InputStreamReader(fis);
		
		// Permite ler linha a linha
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while(linha != null) {
			System.out.println(linha);
			linha = br.readLine();	
		}	
		
		br.close();
	}
}
