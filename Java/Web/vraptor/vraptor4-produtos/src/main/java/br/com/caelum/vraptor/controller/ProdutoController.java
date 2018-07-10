package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class ProdutoController {

	
//	@Path("/produto/")
	@Get("/")
	public void inicio() {
		System.out.println("chegou aqui");
		
	}
}
