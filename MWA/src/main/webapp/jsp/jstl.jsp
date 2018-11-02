<%@page import="br.edu.unibratec.psc.web.UtilServlet"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.unibratec.psc.web.ServletJSTL"%>

<%@page	language="java"	contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL Page</title>
	</head>
	<body>
		Hora certa: ${dataHora}
		<c:if test="${deveImprimir}">
			<ul>
				<%List<String> lista = (List<String>) request.getAttribute(UtilServlet.NM_ATRIBUTO_LISTA_ITENS);%>
				<c:forEach items="${lista}" var="item">
					<li>${item}</li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${not deveImprimir}">
			<br>
			Nada deve ser impresso
			<br>
		</c:if>
		<a href="<c:url value="/Cadastro"></c:url>">Link</a>
		<br>
		<c:choose>
			<c:when test="${deveImprimir}">
				A Lista foi impressa acima, e o Texto abaixo:
				<br>
				 - <c:out value="${texto}"></c:out>
			</c:when>
			<c:otherwise>
				A Lista não deveria ser impressa acima, nem nenhum Texto abaixo.
			</c:otherwise>
		</c:choose>
	</body>
</html>