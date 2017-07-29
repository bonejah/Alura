package br.com.caelum.xstream;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class ProdutoTest {

	@Test
	public void deveGerarOXmlComONomePrecoDescricaoAdequados() {
		String xmlEsperado = "<produto codigo=\"1587\">\n" + "  <nome>geladeira</nome>\n"
				+ "  <preco>R$ 1.000,00</preco>\n" + "  <descriçao>geladeira duas portas</descriçao>\n" + "</produto>";

		Produto geladeira = new Produto("geladeira", 1000, "geladeira duas portas", 1587);

		XStream xStream = new XStream();
		xStream.alias("produto", Produto.class);
		xStream.aliasField("descriçao", Produto.class, "descricao");
		xStream.useAttributeFor(Produto.class, "codigo");
		xStream.registerLocalConverter(Produto.class, "preco", new PrecoSimplesConverter());
		String xmlGerado = xStream.toXML(geladeira);
		assertEquals(xmlEsperado, xmlGerado);
	}
}
