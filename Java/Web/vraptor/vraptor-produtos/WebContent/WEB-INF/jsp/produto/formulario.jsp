<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Novo Produto</title>
</head>
<body>
	<c:forEach var="error" items="${errors}">
	    ${error.category} - ${error.message}<br />
	</c:forEach>
	<form action="<c:url value="/produto/adiciona" />" method="post">
		Nome: <input type="text" name="produto.nome" /><br/ > 
		Descrição: <input type="text" name="produto.descricao" /><br/ >
		Preço: <input type="text" name="produto.preco" /><br/ >
		<input type="submit" value="Salvar produto" />
	</form>
</body>
</html>