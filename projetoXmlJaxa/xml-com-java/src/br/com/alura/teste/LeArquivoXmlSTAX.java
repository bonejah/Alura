package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Produto;

public class LeArquivoXmlSTAX {
	private static Produto produto;
	private static List<Produto> produtos = new ArrayList<Produto>();

	public static void main(String[] args) throws Exception {
		InputStream ips = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(ips);

		while (eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();

			if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {
				produto = criaUmProduto(eventos);
				produtos.add(produto);
			}
		}

		System.out.println(produtos.toString());
	}

	private static Produto criaUmProduto(XMLEventReader eventos) throws Exception {
		Produto produto = new Produto();

		while (eventos.hasNext()) {
			XMLEvent evento = eventos.nextEvent();

			if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")) {
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setNome(nome);
			} else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")) {
				evento = eventos.nextEvent();
				double preco = Double.parseDouble(evento.asCharacters().getData());
				produto.setPreco(preco);
			} else if (evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
		}

		return produto;
	}
}
