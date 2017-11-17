package br.ucsal.geu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.geu.dao.BlocoDAO;
import br.ucsal.geu.dao.EspacoDAO;
import br.ucsal.geu.dao.TipoDAO;
import br.ucsal.geu.model.Bloco;
import br.ucsal.geu.model.Espaco;
import br.ucsal.geu.model.Tipo;

@WebServlet("/espacos")
public class EspacoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String q = request.getParameter("q");
		if (q != null && q.equals("new")) {
			BlocoDAO daoBloco = new BlocoDAO();
			TipoDAO daoTipo = new TipoDAO();
			request.setAttribute("listaBloco", daoBloco.listar());
			request.setAttribute("listaTipo", daoTipo.listar());
			request.getRequestDispatcher("espacoform.jsp").forward(request, response);
		} else {
			EspacoDAO dao = new EspacoDAO();
			request.setAttribute("lista", dao.listar());
			request.getRequestDispatcher("espacolist.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String identificacao = request.getParameter("identificacao");
		String andar = request.getParameter("andar");
		int blocoID = Integer.parseInt(request.getParameter("bloco"));
		int tipoID = Integer.parseInt(request.getParameter("tipo"));

		Espaco espaco = new Espaco();
		espaco.setIdentificacao(identificacao);
		espaco.setAndar(andar);
		Bloco bloco = new Bloco();
		bloco.setId(blocoID);
		Tipo tipo = new Tipo();
		tipo.setIdTipo(tipoID);
		espaco.setBloco(bloco);
		espaco.setTipo(tipo);
		EspacoDAO dao = new EspacoDAO();
		dao.inserir(espaco);
		request.setAttribute("lista", dao.listar());
		request.getRequestDispatcher("espacolist.jsp").forward(request, response);

	}

}
