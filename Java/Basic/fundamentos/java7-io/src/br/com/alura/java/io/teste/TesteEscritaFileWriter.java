package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteEscritaFileWriter {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem4.txt"));
		bw.write("Testanto, alô....");
		bw.write(System.lineSeparator());
		bw.newLine();
		bw.write(System.lineSeparator());
		bw.write("Testanto de novo, alô....");
		bw.close();
	}
}
