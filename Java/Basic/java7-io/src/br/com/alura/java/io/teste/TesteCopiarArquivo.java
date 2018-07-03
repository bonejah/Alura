package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TesteCopiarArquivo {
	
	public static void main(String[] args) throws IOException {
		// Dados para leitura
		FileInputStream fis = new FileInputStream("lorem.txt");
//		InputStream fis = System.in;
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		// Dados para escrita
		//FileOutputStream fos = new FileOutputStream("lorem3.txt");
		OutputStream fos = System.out;
		OutputStreamWriter osr = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osr);
		
		String linha = br.readLine();
		
		while(linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			bw.flush();
			linha = br.readLine();	
		}	
		
		br.close();
		bw.close();
	}
}
