package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SegundaServlet
 */
@WebServlet("/SegundaServlet")
public class CookieServlet extends HttpServlet {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5400753391764676328L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieServlet() {
		super();
		// TODO Auto-generated constructor stub
		Cookie cookie = new Cookie("NomeDoCoockie", "Valor do Coockie");
		
		/*
		 * Tempo em Segundos, entre a criação e a Expiração do Cookie
		 * 
		 * Se for Zero, Deletará o Cookie
		 * Se for Negativo, Deletará quando o Navegador for Fechado
		 */
		cookie.setMaxAge(300);
		
		// Útil caso o usuário peça ao Navegador informações sobre o Cookie
		cookie.setComment("Comentário sobre o Cookie");
		
		/*
		 * Se enviado True, evitará que o Cookie seja exposto a Scripts do lado do Cliente/Navegador
		 * 
		 * Útil para preveninr atáques do tipo XSS (Cross-Site Scripting)
		 */
		cookie.setHttpOnly(true);
		
		/*
		 * Indica que deve ser trafegado apenas via conexões HTTPS/SSL
		 */
		cookie.setSecure(true);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest pRequest, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = pRequest.getCookies();
		
		response.getWriter()
			.append("A PrimeiraServlet foi executada, pelo método doGet(), às ")
			.append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
