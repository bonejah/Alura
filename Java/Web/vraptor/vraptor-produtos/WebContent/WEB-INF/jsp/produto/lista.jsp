<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<c:url value="/js/jquery-1.6.1.min.js" />"></script>
<script type="text/javascript">
	function remove(id) {
		$.get('remove?produto.id=' + id, function() {
		    $('#produto-' + id).hide();
			alert('Produto removido com sucesso');
		});
	}
</script>
<title>Lista de produtos</title>
</head>
<body>
	<h1>Seja bem-vindo a lista de produtos</h1>
	${mensagem}
	<table>
		<c:forEach var="produto" items="${produtoList}">
			<tr id="produto-${produto.id}">
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>${produto.preco}</td>
				<td><a href="javascript:void(0);"
					onclick="remove(${produto.id})">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>