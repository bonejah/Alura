<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--  comentário me JSP aqui: nossa primeira página JSP -->
	<%
		String mensagem = "Bem-vindo ao sistem agenda FJ-21!";
	%>
	
	<%
		out.println(mensagem);
	%>
	
	<%
		String desenvolvido = "Desenvolvido por Bruno Lima!";
	%>
	
	<%=desenvolvido%>
	
	<%
		System.out.println("Tudo foi executado");
	%>
</body>
</html>