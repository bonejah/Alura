package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TesteEscrita3 {
	
	public static void main(String[] args) throws IOException {
//		PrintStream ps = new PrintStream("lorem5.txt");
	    PrintWriter ps = new PrintWriter("lorem6.txt");
		ps.println("Testanto, alô....");
		ps.println();
		ps.println();
		ps.println("Testanto de novo, alô....");
		ps.close();
	}
}
