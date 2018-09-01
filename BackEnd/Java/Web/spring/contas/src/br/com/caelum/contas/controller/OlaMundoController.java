package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/olamundospring")
	public String execute() {
		System.out.println("Executando a lógica do Spring MVC");
		return "ok";
	}

}
