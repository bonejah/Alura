<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.21.custom.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<title>FJ21-Agenda - Adiciona Contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />	
	<form action="adicionaContato" method="post">
		Nome:<input type="text" name="nome"/><br />	
		E-mail:<input type="text" name="email"/><br />
		Endereço:<input type="text" name="endereco"/><br />
		Data Nascimento<caelum:campoData id="dataNascimento"/><br />
		<input type="submit" value="Gravar"/>
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>