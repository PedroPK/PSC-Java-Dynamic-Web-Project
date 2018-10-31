package br.edu.unibratec.psc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThymeleafServlet
 */
@WebServlet("/ThymeleafServlet")
public class ThymeleafServlet extends HttpServlet {
	
	private static final String URL_HTML_THYMELEAF_HTML = "/templates/thymeleaf.html";
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThymeleafServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilServlet.setListaNoRequest(request);
		
		//templateEngineSetVariableProcess(request, response);
		
		// http://acodigo.blogspot.com/2017/07/integrar-thymeleaf-un-servlet-java.html
		//servletContexTemplateResolverSetVariableProcess(request, response);
		
		UtilServlet.redirecionar(request, response, URL_HTML_THYMELEAF_HTML);
	}
	
	private void servletContexTemplateResolverSetVariableProcess(
		HttpServletRequest		request,
		HttpServletResponse		response) 
	throws IOException {
		/*ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(getServletContext());
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setPrefix("/WEB_INF/templates/");
		resolver.setSuffix(".html");
		resolver.setCacheTTLMs(3600000L);
		resolver.setCacheable(true);
		
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
		
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		WebContext context = new WebContext(request, response, getServletContext(), request.getLocale());
		context.setVariable(UtilServlet.NM_ATRIBUTO_LISTA_ITENS, UtilServlet.getDataHoraHojeAgora());
		
		engine.process("thymeleaf", context, response.getWriter());*/
	}
	
	private void templateEngineSetVariableProcess(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		/*TemplateEngine engine = (TemplateEngine) request.getServletContext().getAttribute("com.thymeleafexamples.thymeleaf3.TemplateEngineInstance");
		WebContext context = new WebContext(request, response, getServletContext());
		context.setVariable(UtilServlet.NM_ATRIBUTO_LISTA_ITENS, UtilServlet.getDataHoraHojeAgora());
		engine.process(URL_HTML_THYMELEAF_HTML, context, response.getWriter());*/
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}