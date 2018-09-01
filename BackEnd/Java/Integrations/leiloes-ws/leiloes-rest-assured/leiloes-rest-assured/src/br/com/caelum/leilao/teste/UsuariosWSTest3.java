package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;

import br.com.caelum.leilao.modelo.Leilao;
import br.com.caelum.leilao.modelo.Usuario;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UsuariosWSTest3 {
	@Test
	public void setUp() {
		Usuario mauricio = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		Usuario guilherme = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
	}

	@Test
	public void deveAdicionarUmUsuario() {
		Usuario joao = new Usuario("Joao da Silva", "joao@dasilva.com");
		XmlPath retorno = given().header("Accept", "application/xml").contentType("application/xml").body(joao).expect()
				.statusCode(200).when().post("/usuarios").andReturn().xmlPath();

		Usuario resposta = retorno.getObject("usuario", Usuario.class);
		assertEquals("Joao da Silva", resposta.getNome());
		assertEquals("joao@dasilva.com", resposta.getEmail());
		// deletando aqui
		given().contentType("application/xml").body(resposta).expect().statusCode(200).when().delete("/usuarios/deleta")
				.andReturn().asString();
	}

	@Test
	public void deveInserirLeiloes() {
		Usuario mauricio = new Usuario(1l, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		Leilao leiloes = new Leilao(1l, "Geladeira", 800.0, mauricio, false);

		XmlPath retorno = given().header("Accept", "application/xml").contentType("application/xml").body(leiloes)
				.expect().statusCode(200).when().post("/leiloes").andReturn().xmlPath();

		Leilao resposta = retorno.getObject("leilao", Leilao.class);

		assertEquals("Geladeira", resposta.getNome());

		// deletando aqui
		given().contentType("application/xml").body(resposta).expect().statusCode(200).when().delete("/leiloes/deleta")
				.andReturn().asString();
	}

}
