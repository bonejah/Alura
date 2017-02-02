package br.com.caelum.tarefas.controller;

import java.text.SimpleDateFormat;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.TarefaDAO;
import br.com.caelum.tarefas.modelo.Tarefa;

@Transactional
@Controller
public class TarefaController{
	
	@Autowired
	private TarefaDAO tarefaDAO;
	
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		if(result.hasFieldErrors("descricao")) 
			return "tarefa/formulario";
		tarefaDAO.adiciona(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model){
		Tarefa dao = tarefaDAO.buscaPorId(id);
		if(dao.getDataFinalizacao() != null)
			model.addAttribute("data", new SimpleDateFormat("dd/MM/yyyy").format(dao.getDataFinalizacao().getTime()));
		model.addAttribute("tarefa", dao);
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(@Valid Tarefa tarefa, BindingResult result){
		if(result.hasFieldErrors("descricao"))
			return "tarefa/mostra";
		tarefaDAO.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		model.addAttribute("tarefas", tarefaDAO.lista());
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa){
		tarefaDAO.remove(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model){
		tarefaDAO.finaliza(id);
		model.addAttribute("tarefa", tarefaDAO.buscaPorId(id));
		return "tarefa/finalizada";
	}
	
}