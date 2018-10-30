<%@page import="br.edu.unibratec.psc.web.PrimeiraServlet"%>
<%@ page	language="java"		contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Olá, Pessoas</title>
	</head>
	<body>
		Hi, Folks!
		
		<br>
		<%
			// Permite um Bloco de Código Java dentro da JSP
			
			String nome = "John";
			String sobreNome = "Doe";
			
			String dataHora = 	request.getAttribute(PrimeiraServlet.NM_ATRIBUTO_DATA_HORA).toString();
		%>
		
		<%= "Meu nome é " + nome + " " + sobreNome %> <!--  Imprime o valor da Expressão na Página -->
		<br>
		<%= dataHora %>
	</body>
</html>