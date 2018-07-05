<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de produtos</title>
</head>
<body>
	<h1>Seja bem-vindo a lista de produtos</h1>
	<table>
		<c:forEach var="produto" items="${produtoList}">
			<tr>
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>${produto.preco}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>