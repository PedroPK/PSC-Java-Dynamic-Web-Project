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
		<c:if test="${deveImprimirLista}">
			<ul>
				<%List<String> lista = (List<String>) request.getAttribute(UtilServlet.NM_ATRIBUTO_LISTA_ITENS);%>
				<c:forEach items="${lista}" var="item">
					<li>${item}</li>
				</c:forEach>
			</ul>
		</c:if>
		<br>
		<c:choose>
			<c:when test="${deveImprimirLista}">
				A lista foi impressa acima.
			</c:when>
			<c:otherwise>
				A lista não deveria ser impressa acima.
			</c:otherwise>
		</c:choose>
	</body>
</html>