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

public class UsuariosWSTest2 {
	private Usuario mauricio;
	private Usuario guilherme;

	@Test
	public void setUp() {
		mauricio = new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		guilherme = new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");
	}
	
	
	@Test
	public void deveRetornarListaDeUsuarios() {
		XmlPath path = given().
						header("Accept", "application/xml").
						get("/usuarios").
						andReturn().
						xmlPath();
		
		List<Usuario> usuarios = path.getList("list.usuario", Usuario.class);
		assertEquals(mauricio, usuarios.get(0));
		assertEquals(guilherme, usuarios.get(1));
	}

	@Test
	public void deveRetornarListaDeUsuariosJson() {
		JsonPath path = given().
						header("Accept", "application/json").
						get("/usuarios").
						andReturn().
						jsonPath();

		List<Usuario> usuarios = path.getList("list.usuario", Usuario.class);		
		assertEquals(mauricio, usuarios.get(0));
		assertEquals(guilherme, usuarios.get(1));
	}
	
	@Test
	public void deveRetornarUmLeilaoJson() {
		JsonPath path = given().
				header("Accept", "application/json").
				parameter("leilao.id", 1).
				get("/leiloes/show").
				andReturn().
				jsonPath();
		
		 Leilao leilao = path.getObject("leilao", Leilao.class);
		 Leilao leilaoEsperado = new Leilao(1l, "Geladeira", 800.0, mauricio, false);
		assertEquals(leilaoEsperado, leilao);
	} 
}
