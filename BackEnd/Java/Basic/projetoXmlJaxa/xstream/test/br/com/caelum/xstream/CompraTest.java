package br.com.caelum.xstream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class CompraTest {

	@Test
	public void deveSerializarColecoesImplicitas() {
		String resultadoEsperado = "<compra>\n" + "  <id>15</id>\n" + "  <produto codigo=\"1587\">\n"
				+ "    <nome>geladeira</nome>\n" + "    <preco>1000.0</preco>\n"
				+ "    <descrição>geladeira duas portas</descrição>\n" + "  </produto>\n"
				+ "  <produto codigo=\"1588\">\n" + "    <nome>ferro de passar</nome>\n" + "    <preco>100.0</preco>\n"
				+ "    <descrição>ferro com vaporizador</descrição>\n" + "  </produto>\n" + "</compra>";

		Produto geladeira = geladeira();
		Produto ferro = ferro();
		List<Produto> produtos = new ArrayList<>();
		produtos.add(geladeira);
		produtos.add(ferro);
		Compra compra = compraComGeladeiraEFerro(produtos);

		XStream stream = xstreamParaCompraEProduto();
		stream.addImplicitCollection(Compra.class, "produtos");
		String xmlGerado = stream.toXML(compra);

		assertEquals(resultadoEsperado, xmlGerado);
	}

	@Test
	public void deveSerializarCadaUmDosProdutosDeUmaCompra() {
		String resultadoEsperado = "<compra>\n" + "  <id>15</id>\n" + "  <produtos>\n"
				+ "    <produto codigo=\"1587\">\n" + "      <nome>geladeira</nome>\n" + "      <preco>1000.0</preco>\n"
				+ "      <descrição>geladeira duas portas</descrição>\n" + "    </produto>\n"
				+ "    <produto codigo=\"1588\">\n" + "      <nome>ferro de passar</nome>\n"
				+ "      <preco>100.0</preco>\n" + "      <descrição>ferro com vaporizador</descrição>\n"
				+ "    </produto>\n" + "  </produtos>\n" + "</compra>";

		Produto geladeira = geladeira();
		Produto ferro = ferro();
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(geladeira);
		produtos.add(ferro);

		Compra compra = new Compra(15, produtos);

		XStream xstream = xstreamParaCompraEProduto();

		String xmlGerado = xstream.toXML(compra);

		assertEquals(resultadoEsperado, xmlGerado);
	}

	@Test
	public void deveGerarUmaCompraComOsProdutosAdequados() {
		String xmlDeOrigem = "<compra>\n" + " <id>15</id>\n" + " <produtos>\n" + " <produto codigo=\"1587\">\n"
				+ " <nome>geladeira</nome>\n" + " <preco>1000.0</preco>\n"
				+ " <descrição>geladeira duas portas</descrição>\n" + " </produto>\n" + " <produto codigo=\"1588\">\n"
				+ " <nome>ferro de passar</nome>\n" + " <preco>100.0</preco>\n"
				+ " <descrição>ferro com vaporizador</descrição>\n" + " </produto>\n" + " </produtos>\n" + "</compra>";

		XStream xstream = xstreamParaCompraEProduto();

		Compra compraResultado = (Compra) xstream.fromXML(xmlDeOrigem);

		Produto geladeira = geladeira();
		Produto ferro = ferro();
		List produtos = new ArrayList();
		produtos.add(geladeira);
		produtos.add(ferro);

		Compra compraEsperada = compraComGeladeiraEFerro(produtos);
		assertEquals(compraEsperada, compraResultado);
	}

	private XStream xstreamParaCompraEProduto() {
		XStream xstream = new XStream();
		xstream.alias("compra", Compra.class);
		xstream.alias("produto", Produto.class);
		xstream.alias("livro", Livro.class);
		xstream.alias("musica", Musica.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		return xstream;
	}

	private Compra compraComGeladeiraEFerro(List produtos) {
		Compra compraEsperada = new Compra(15, produtos);
		return compraEsperada;
	}

	private Compra compraComDuasGeladeirasIguais() {
		Produto geladeira = geladeira();
		List<Produto> produtos = new ArrayList<>();
		produtos.add(geladeira);
		produtos.add(geladeira);
		Compra compraEsperada = new Compra(15, produtos);
		return compraEsperada;
	}

	private Produto ferro() {
		Produto ferro = new Produto("ferro de passar", 100, "ferro com vaporizador", 1588);
		return ferro;
	}

	private Produto geladeira() {
		Produto geladeira = new Produto("geladeira", 1000, "geladeira duas portas", 1587);
		return geladeira;
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

	private Compra compraComLivroEMusica() {
		Produto livro = new Livro("O Passaro Raro", 100, "dez historias", 1000);
		Produto musica = new Musica("RadioHead", 100, "Big bang", 1000);
		List<Produto> produtos = new LinkedList<Produto>();
		produtos.add(livro);
		produtos.add(musica);

		Compra compra = new Compra(7, produtos);
		return compra;
	}

	public void deveSerializarMusicaELivro() {
		String xmlDeOrigem = "<compra>\n" + " <id>15</id>\n" + " <produtos class=\"linked-list\">\n"
				+ " <produto codigo=\"1000\">\n" + " <nome>O Passaro Raro</nome>\n" + " <preco>100</preco>\n"
				+ " <descrição>dez historias</descrição>\n" + " </produto>\n" + " <produto codigo=\"1000\">\n"
				+ " <nome>RadioHead</nome>\n" + " <preco>100</preco>\n" + " <descrição>Big bang</descrição>\n"
				+ " </produto>\n" + " </produtos>\n" + "</compra>";

		Compra compra = compraComLivroEMusica();
		XStream xStream = xstreamParaCompraEProduto();
		String xmlEsperado = xStream.toXML(compra);
		assertEquals(xmlDeOrigem, xmlEsperado);
	}

	@Test
	public void deveUtilizarConversorTotalmenteCustomizado() {
		String xmlEsperado = "<compra estilo=\"novo\">\n" + "  <id>15</id>\n"
				+ "  <fornecedor>bruno lima</fornecedor>\n" + "  <produtos>\n" + "    <produto codigo=\"1587\">\n"
				+ "      <nome>geladeira</nome>\n" + "      <preco>1000.0</preco>\n"
				+ "      <descrição>geladeira duas portas</descrição>\n" + "    </produto>\n"
				+ "    <produto codigo=\"1587\">\n" + "      <nome>geladeira</nome>\n" + "      <preco>1000.0</preco>\n"
				+ "      <descrição>geladeira duas portas</descrição>\n" + "    </produto>\n" + "  </produtos>\n"
				+ "</compra>";

		Compra compra = compraComDuasGeladeirasIguais();

		XStream xStream = xstreamParaCompraEProduto();
		xStream.registerConverter(new CompraDiferenteConverter());
		xStream.setMode(XStream.NO_REFERENCES);
		String xmlGerado = xStream.toXML(compra);
		assertEquals(xmlEsperado, xmlGerado);

		Compra deserializada = (Compra) xStream.fromXML(xmlGerado);
		assertEquals(compra, deserializada);

	}
}
