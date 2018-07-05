<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="adiciona" method="post">
            Nome: <input type="text" name="produto.nome" /> <br />
            Descrição: <input type="text" name="produto.descricao" /><br />
            Preço: <input type="text" name="produto.preco" /><br />
            <input type="submit" value="Salvar produto" />
        </form>
</body>
</html>