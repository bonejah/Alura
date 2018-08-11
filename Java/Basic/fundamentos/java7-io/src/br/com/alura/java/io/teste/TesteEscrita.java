package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {
	
	public static void main(String[] args) throws IOException {
		// Padrão Decorator
		// BufferedWriter> OutputStreamWriter > FileOutputStream > lorem2.txt
		
		// Somente lê bytes 
		OutputStream fos = new FileOutputStream("lorem2.txt");
		
		// Transformando bytes em caracteres
		Writer osr = new OutputStreamWriter(fos);
		
		// Permite ler linha a linha
		BufferedWriter bw = new BufferedWriter(osr);
		
		bw.write("Testanto, alô....");
		bw.newLine();
		bw.newLine();
		bw.write("Testanto de novo, alô....");
		bw.close();
	}
}
