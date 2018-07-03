package br.com.alura.java.io.teste;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteEscritaPrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("contas.csv"));

		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();

			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter(",");

			String valor1 = linhaScanner.next();
			int valor2 = linhaScanner.nextInt();
			int valor3 = linhaScanner.nextInt();
			String valor4 = linhaScanner.next();
			double valor5 = linhaScanner.nextDouble();

//			System.out.println(valor1 + " - " + valor2 + " - " + valor3 + " - " + valor4 + " - " + valor5);
			String valorFormatado = String.format(new Locale("pt", "BR") ,"%s - %04d-%08d, %10s: %.2f", valor1, valor2, valor3, valor4, valor5);
			System.out.println(valorFormatado);

			String valorFormatado2 = String.format("%s - %04d-%08d, %10s: %.2f", valor1, valor2, valor3, valor4, valor5);
			System.out.println(valorFormatado2);
			linhaScanner.close();

		}

		scanner.close();
	}
}
