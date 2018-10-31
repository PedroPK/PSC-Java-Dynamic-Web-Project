package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/Cadastro")
public class CadastroServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String JSP_CADASTRO = "/jsp/cadastro.jsp";
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilServlet.redirecionar(request, response, JSP_CADASTRO);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parametros = request.getParameterMap();
		
		Set<String> chaves = parametros.keySet();
		Iterator<String> iteratorChaves = chaves.iterator();
		
		if ( !iteratorChaves.hasNext() ) {
			doGet(request, response);
		} else {
			while ( iteratorChaves.hasNext() ) {
				String chave = iteratorChaves.next();
				
				String parametro = request.getParameter(chave);
				
				System.out.println(chave + ": " + parametro);
			}
		}
	}
	
}