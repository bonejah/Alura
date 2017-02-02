package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Contato contato = new Contato();
		long id=  Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEmail("email");
		
		// converte a data String para Calendar
		String dataEmTexto = request.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		
		System.out.println("Alterando contato..." + contato.getNome());
		
		
	}

}
