package br.com.alura.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.model.Produto;
import br.com.alura.model.Venda;

public class LerArquivoXMLJAXB {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		xmlParaObjeto(jaxbContext);
		objetoParaXml(jaxbContext);
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda.toString());
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crediario");
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Use a cabeca Java", 100.00));
		produtos.add(new Produto("Use a cabeca C", 100.00));
		venda.setProdutos(produtos);
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		System.out.println(writer.toString());
	}

}
