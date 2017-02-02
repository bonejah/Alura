<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busca Empresas</title>
</head>
<body>
Resultado da busca:
<c:forEach var="empresa" items="${empresas}">
	<li>${empresa.id}: ${empresa.nome}</li>
</c:forEach>

</body>
</html>