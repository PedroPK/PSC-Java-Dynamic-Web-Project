package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/primeira")
public class PrimeiraServlet extends HttpServlet {
	
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
		
		printHTML(pResponse, "doGet()");
	}
	
	@Override
	protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		System.out.println("doPost() executado.");
	}
	
	@Override
	protected void service(HttpServletRequest pRequest, HttpServletResponse pResponse) throws IOException, ServletException {
		System.out.println("Service() executado.");
		
		printHTML(pResponse, "service()");
		
	}
	
	private void printHTML(HttpServletResponse pResponse, String pHttpMethodExecuted) throws IOException {
		PrintWriter writer = pResponse.getWriter();
		
		writer.println("<html>");
			writer.println("<head>");
				writer.println("<title>");
					writer.println("Minha primeira Servlet");
				writer.println("</title>");
			writer.println("</head>");
			writer.println("<body>");
				writer.println("Hi, Folks! " + pHttpMethodExecuted + " method was executed!" );
			writer.println("</body>");
		writer.println("</html>");
	}
	
}