package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeiraServlet")
public class PrimeiraServlet extends HttpServlet {
	
	private static final String JSP_HELLO = "/jsp/hello.jsp";
	
	/**
	 * - Serial Version UID
	 */
	private static final long serialVersionUID = 9057538226269352601L;
	
	@Override
	public void init() {
		System.out.println("Init() executado");
	}
	
	@Override
	protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		System.out.println("doGet() executado.");
		
		//Enumeration<String> parametros = pRequest.getParameterNames();
		
		//printHTML(pRequest, pResponse, "service()", parametros);
		
		String dataHora = UtilServlet.getDataHoraHojeAgora();
		
		//pResponse.sendRedirect(JSP_HELLO);
		
		Enumeration<String> parametros = pRequest.getParameterNames();
		while ( parametros.hasMoreElements() ) {
			String parametro = parametros.nextElement();
			String valor = pRequest.getParameter(parametro);
			
			pRequest.setAttribute(parametro, valor);
		}
		String valorDoParametro = pRequest.getParameter("NOME_DO_PARAMETRO");
		
		pRequest.setAttribute(UtilServlet.NM_ATRIBUTO_DATA_HORA, dataHora);
		
		UtilServlet.redirecionar(pRequest, pResponse, JSP_HELLO);
	}
	
	@Override
	protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		System.out.println("doPost() executado.");
	}
	
	/*@Override
	protected void service(HttpServletRequest pRequest, HttpServletResponse pResponse) throws IOException, ServletException {
		System.out.println("Service() executado.");
		
		Enumeration<String> parametros = pRequest.getParameterNames();
		
		printHTML(pRequest, pResponse, "service()", parametros);
	}*/
	
	private void printHTML(
		HttpServletRequest		pRequest, 
		HttpServletResponse		pResponse, 
		String					pHttpMethodExecuted, 
		Enumeration<String>		pNomesParametros)
	throws IOException {
		PrintWriter writer = pResponse.getWriter();
		
		writer.println("<html>");
			writer.println("<head>");
				writer.println("<title>");
					writer.println("Minha primeira Servlet");
				writer.println("</title>");
			writer.println("</head>");
			writer.println("<body>");
				writer.println("Hi, Folks! " + pHttpMethodExecuted + " method was executed!" );
				if ( pNomesParametros != null) {
					while ( pNomesParametros.hasMoreElements() ) {
						String nomeParametro = pNomesParametros.nextElement();
						writer.println("<br><br>" );
						writer.println("Nome dos Parâmetro: "	+ nomeParametro );
						writer.println("<br>" );
						writer.println("Valor dos Parâmetro: "	+ pRequest.getParameter(nomeParametro) );
					}
				}
			writer.println("</body>");
		writer.println("</html>");
	}
	
}