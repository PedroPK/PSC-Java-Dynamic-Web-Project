package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuperServlet
 */
public class UtilServlet {
	
	public static final String NM_ATRIBUTO_DATA_HORA = "dataHora";
	
	public static void redirecionar(HttpServletRequest pRequest, HttpServletResponse pResponse, String pJsp)
	throws ServletException, IOException {
		pRequest.getRequestDispatcher(pJsp).forward(pRequest, pResponse);
	}
	
	public static String getDataHoraHojeAgora() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}
	
}
