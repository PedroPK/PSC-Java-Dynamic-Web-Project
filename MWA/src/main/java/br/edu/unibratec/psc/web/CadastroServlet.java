package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unibratec.psc.model.entity.Pessoa;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/Cadastro")
public class CadastroServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String JSP_CADASTRO = "/jsp/cadastro.jsp";
	
	public static final String NM_PARAMETRO_NOME				= "nome";
	public static final String NM_PARAMETRO_CPF					= "cpf";
	public static final String NM_PARAMETRO_DATA_NASCIMENTO		= "dtNascimento";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		UtilServlet.redirecionar(pRequest, pResponse, JSP_CADASTRO);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
		String nome				= pRequest.getParameter(NM_PARAMETRO_NOME);
		String cpf				= pRequest.getParameter(NM_PARAMETRO_CPF);
		String dtNascimento		= pRequest.getParameter(NM_PARAMETRO_DATA_NASCIMENTO);
		
		Date dataNascimento = null;
		try {
			dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dtNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setCpf(cpf);
		pessoa.setDataNascimento(dataNascimento);
		
		System.out.println( pessoa.toString() );
	}
	
	private void imprimirParametros(HttpServletRequest pRequest, HttpServletResponse pResponse)
	throws ServletException, IOException {
		Map<String, String[]> parametros = pRequest.getParameterMap();
		
		Set<String> chaves = parametros.keySet();
		Iterator<String> iteratorChaves = chaves.iterator();
		
		if ( !iteratorChaves.hasNext() ) {
			doGet(pRequest, pResponse);
		} else {
			while ( iteratorChaves.hasNext() ) {
				String chave = iteratorChaves.next();
				
				String parametro = pRequest.getParameter(chave);
				
				System.out.println(chave + ": " + parametro);
			}
		}
	}
	
}