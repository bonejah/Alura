package br.com.caelum.xstream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.TreeMarshaller.CircularReferenceException;

public class CategoriaTest {

	@Test(expected = CircularReferenceException.class)
	public void deveSerializarumCiclo() {
		String xmlEsperado = "";

		Categoria esporte = new Categoria(null, "esporte");
		Categoria futebol = new Categoria(esporte, "futebol");
		Categoria geral = new Categoria(futebol, "geral");
		esporte.setPai(geral);

		XStream stream = new XStream();
		stream.setMode(XStream.NO_REFERENCES);
		stream.alias("categoria", Categoria.class);
		stream.toXML(esporte);
	}

	@Test(expected = CircularReferenceException.class)
	public void naoDeveSerializarUmCicloSemReferencias() {
		String xmlEsperado = "";

		Categoria esporte = new Categoria(null, "esporte");
		Categoria futebol = new Categoria(esporte, "futebol");
		Categoria geral = new Categoria(futebol, "geral");
		esporte.setPai(geral);

		XStream stream = new XStream();
		stream.setMode(XStream.NO_REFERENCES);
		stream.alias("categoria", Categoria.class);
		stream.toXML(esporte);
	}

	@Test
	public void deveSerializarDuasGeladeirasIguais() {
		String xmlEsperado = "<compra>\n" + "  <id>15</id>\n" + "  <produtos>\n" + "    <produto codigo=\"1587\">\n"
				+ "      <nome>geladeira</nome>\n" + "      <preco>1000.0</preco>\n"
				+ "      <descrição>geladeira duas portas</descrição>\n" + "    </produto>\n"
				+ "    <produto codigo=\"1587\">\n" + "      <nome>geladeira</nome>\n" + "      <preco>1000.0</preco>\n"
				+ "      <descrição>geladeira duas portas</descrição>\n" + "    </produto>\n" + "  </produtos>\n"
				+ "</compra>";

		Compra compra = compraComDuasGeladeirasIguais();

		XStream xStream = xstreamParaCompraEProduto();
		xStream.setMode(XStream.NO_REFERENCES);
		String xmlGerado = xStream.toXML(compra);
		assertEquals(xmlEsperado, xmlGerado);

	}

	private XStream xstreamParaCompraEProduto() {
		XStream xstream = new XStream();
		xstream.alias("compra", Compra.class);
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		return xstream;
	}

	private Compra compraComDuasGeladeirasIguais() {
		Produto geladeira = geladeira();
		List<Produto> produtos = new ArrayList<>();
		produtos.add(geladeira);
		produtos.add(geladeira);
		Compra compraEsperada = new Compra(15, produtos);
		return compraEsperada;
	}

	private Compra compraDuasGeladeirasIguais() {
		Produto geladeira = geladeira();

		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(geladeira);
		produtos.add(geladeira);

		return new Compra(15, produtos);
	}

	private Produto geladeira() {
		Produto geladeira = new Produto("geladeira", 1000, "geladeira duas portas", 1587);
		return geladeira;
	}

}
