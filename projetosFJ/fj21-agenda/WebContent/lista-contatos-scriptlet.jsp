<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, br.com.caelum.jdbc.dao.*, br.com.caelum.jdbc.modelo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listando contatos</title>
</head>
<body>
	<table align="left" cellpadding="0" cellspacing="1">
		<tr>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereco</td>
			<td>Data Nascimento</td>
		</tr> 	
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for(Contato contato: contatos){
				contato.setDataFormatada(new SimpleDateFormat("dd/MM/YYYY").format(contato.getDataNascimento().getTime()));
		%>
		<tr>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=contato.getDataFormatada() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>