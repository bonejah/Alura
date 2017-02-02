<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/css/jquery-ui.css" rel="stylesheet">
		<link href="resources/css/tarefas.css" rel="stylesheet" /> 
		<script src="resources/js/jquery.js"></script>
		<script src="resources/js/jquery-ui.js"></script>
		<title>Tarefas</title>
	</head>
	<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form:errors path="tarefa.descricao"/>
	<form action="alteraTarefa" method="post">
		<input type="hidden" name="id" value="${tarefa.id}" />
		Descrição:<br />
		<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
		<br />
		Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : '' }/> 
		<br />
		Data de finalização: <br />
		<caelum:campoData id="dataFinalizacao" value="${data}" />
		<br />
		<input type="submit" value="Alterar"/>
		</form>
	</body>
</html>