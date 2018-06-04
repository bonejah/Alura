package loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.Servidor;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import junit.framework.Assert;

public class ClienteTest {

	private HttpServer server;
	private WebTarget target;
	private Client client;

	@Before
	public void before() {
		server = Servidor.inicializaServidor();
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		this.client = ClientBuilder.newClient(config);
		this.target = client.target("http://localhost:8080");
	}
	
	@After
	public void after() {
		server.stop();
	}
	
	/*@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String resposta = target.path("/carrinhos/2").request().get(String.class);
		System.out.println(resposta);
		Carrinho carrinho = (Carrinho) new XStream().fromXML(resposta);
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
		
		//WebTarget target = client.target("http://www.mocky.io");
		//Assert.assertTrue(resposta.contains("<rua>Rua Vergueiro 3185"));				
		//Response response = target.path("/v2/5185415ba171ea3a00704eed").request().get();		
		//System.out.println(response.getStatus());
	}*/
	
	@Test
    public void testaQueSuportaNovosCarrinhos(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        Carrinho carrinho = new Carrinho();
        carrinho.adiciona(new Produto(314L, "Tablet", 999, 1));
        carrinho.setRua("Rua Vergueiro");
        carrinho.setCidade("Sao Paulo");
        String xml = carrinho.toXML();

        Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/carrinhos").request().post(entity);
        Assert.assertEquals(201, response.getStatus());
        String location = response.getHeaderString("Location");
        String conteudo = (String) client.target(location).request().get(String.class);
        
        Assert.assertTrue(conteudo.contains("Tablet"));
    }
	
	@Test
    public void testaQueBuscarUmCarrinhoTrasUmCarrinho() {
        WebTarget target = client.target("http://localhost:8080");
        Carrinho carrinho = target.path("/carrinhos/1").request().get(Carrinho.class);
        Assert.assertEquals("Rua Vergueiro 3185, 8 andar",carrinho.getRua());
    }

  
    
}

