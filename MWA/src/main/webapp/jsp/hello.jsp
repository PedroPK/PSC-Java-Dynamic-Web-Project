<%@page import="java.util.Enumeration"%>
<%@page import="br.edu.unibratec.psc.web.PrimeiraServlet"%>
<%@page import="br.edu.unibratec.psc.web.UtilServlet"%>

<%@page	language="java"		contentType="text/html; charset=UTF-8"		pageEncoding="UTF-8"%>

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
			
			String nome = "Johnny";
			
			String dataHora = 	request.getAttribute(UtilServlet.NM_ATRIBUTO_DATA_HORA).toString();
		%>
		
		<%= "Meu nome não é " + nome %> <!--  Imprime o valor da Expressão na Página -->
		<br>
		Meu nome não é ${nome}
		<br>
		<%= dataHora%>
		<br>
		A Data e Hora de agora são ${dataHora}
		<br><br>
		<%
			Enumeration<String> parametros = request.getAttributeNames();
			while ( parametros.hasMoreElements() ) {
				String parametro = parametros.nextElement();
				
				String valor = request.getAttribute(parametro).toString();
				
				System.out.println("<br>Parâmetro: " + parametro + " = " + "Valor: " + valor + "<br>");
		%>
		<%="<br>Parâmetro: " + parametro + " = " + "Valor: " + valor + "<br>"%>
		<%
			}
		%>
	</body>
</html>