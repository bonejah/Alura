<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.21.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
<title>Altera Contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	Formulário para alteração de contatos:<br />
	
	<form action="mvc" method="post">
		Id: <input type="text" name="id"/><br />
		Nome: <input type="text" name="nome"/><br />
		E-mail: <input type="text" name="email"/><br />
		Endereço: <input type="text" name="endereco"/><br />
		Data de Nascimento: <caelum:campoData id="dataNascimento" />
		<input type="hidden" name="logica" value="AlteraContatoLogic"/>
		<input type="submit" value="Enviar"/>
	</form>
	
	<c:import url="rodape.jsp" />
</body>
</html>