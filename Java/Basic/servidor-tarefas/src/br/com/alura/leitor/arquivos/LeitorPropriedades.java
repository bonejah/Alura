package br.com.alura.leitor.arquivos;

import java.io.FileReader;
import java.util.Properties;

public class LeitorPropriedades implements Runnable {
	private Properties properties;
	private String nomeArquivo;

	public LeitorPropriedades(Properties properties, String nomeArquivo) {
		this.properties = properties;
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public void run() {
		try {
			this.properties.load(new FileReader(nomeArquivo));
			System.out.println("Valor do properties: " + this.properties.toString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
