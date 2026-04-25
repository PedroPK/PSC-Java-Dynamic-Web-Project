package br.edu.unibratec.psc.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SegundaServlet
 */
//@WebServlet("/SegundaServlet")
public class SegundaServlet extends HttpServlet {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -5400753391764676328L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SegundaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
