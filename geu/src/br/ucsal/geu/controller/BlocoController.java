package br.ucsal.geu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.geu.dao.BlocoDAO;
import br.ucsal.geu.model.Bloco;

@WebServlet("/blocos")
public class BlocoController extends HttpServlet
{
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String q = request.getParameter("q");
		if (q != null && q.equals("new"))
		{
			request.getRequestDispatcher("blocoform.jsp").forward(request, response);
		} else
		{
			BlocoDAO dao = new BlocoDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("blocolist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String nome = request.getParameter("nome");
		String letra = request.getParameter("letra");
		String lat = request.getParameter("latitude");
		String longi = request.getParameter("longitude");
		Bloco bloco = new Bloco(nome, letra, lat, longi);
		BlocoDAO dao = new BlocoDAO();
		dao.inserir(bloco);

		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("blocolist.jsp").forward(request, response);

	}
}
