<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Contatos Elegante</title>
</head>
<body>	
	<c:import url="cabecalho.jsp"/>

	<!-- cria DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.servlet.PesquisaContatoServlet" />

	<table>
		<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endereço</td>
			<td>Data Nascimento</td>
			<td></td>
		</tr>
		<c:forEach var="contato" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count% 2 == 0 ? 'aaaee88' : 'ffffff'} }">
				<td>${contato.nome}</td>
				<c:choose>
					<c:when test="${not empty contato.email}">
						<td>
							<a href="mailto:${contato.email}">${contato.email}</a>
						</td>
					</c:when>
					<c:otherwise>
						<td>
							E-mail não informado!
						</td>
					</c:otherwise>
				</c:choose>
				<td>${contato.endereco}</td>
				<!-- 
				<td>${contato.dataNascimento.time}</td>
				 -->
				 <td>
				 	<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
				 </td>
				 <td>
				 	<a href="removeContato">Remove contato</a>
				 	<input type="hidden" name ="id" value="${contato.id}" />
				 </td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="rodape.jsp"/>
</body>
</html>