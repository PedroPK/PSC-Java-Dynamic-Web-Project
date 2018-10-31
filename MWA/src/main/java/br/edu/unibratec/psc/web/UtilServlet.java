package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuperServlet
 */
public class UtilServlet {
	
	public static final String NM_ATRIBUTO_DATA_HORA = "dataHora";
	public static final String NM_ATRIBUTO_LISTA_ITENS = "lista";
	
	public static void redirecionar(HttpServletRequest pRequest, HttpServletResponse pResponse, String pJsp)
	throws ServletException, IOException {
		pRequest.getRequestDispatcher(pJsp).forward(pRequest, pResponse);
	}
	
	public static String getDataHoraHojeAgora() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}
	
	public static void setListaNoRequest(HttpServletRequest pRequest) {
		List<String> lista = getLista();
		pRequest.setAttribute(NM_ATRIBUTO_LISTA_ITENS, lista);
	}
	
	private static List<String> getLista() {
		List<String> lista = new ArrayList<String>();
		lista.add("Item 01");
		lista.add("Item 02");
		lista.add("Item 03");
		lista.add("Item 04");
		return lista;
	}
}
