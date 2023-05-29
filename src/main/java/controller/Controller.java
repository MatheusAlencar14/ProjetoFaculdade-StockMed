package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans material = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		//System.out.println(action);
		if (action.equals("/main")) {
			materiais(request, response);
		} else if (action.equals("/insert")) {
			novoMaterial(request, response);
		} else if (action.equals("/select")) {
			listarMaterial(request, response);
		} else if (action.equals("/update")) {
			editarMaterial(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar Materiais
	protected void materiais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um objeto que receberá os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarMateriais();
		/**
		 * teste de recebimento da lista for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdmaterial());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getCodMaterial());
		 * System.out.println(lista.get(i).getQuantidade()); }
		 **/
		// encaminhar a lista ao documento agenda.jsp
		request.setAttribute("materiais", lista);
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
	}

	// Novo Material
	protected void novoMaterial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variáveis JavaBeans
		material.setNome(request.getParameter("nome"));
		material.setCodMaterial(request.getParameter("codMaterial"));
		material.setQuantidade(request.getParameter("quantidade"));
		// invocar método inserirMaterial passando o objeto material
		dao.inserirMaterial(material);
		// recirecionar para o documento lista.jsp
		response.sendRedirect("main");
	}
	
	//Editar contato
	protected void listarMaterial(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//recebimento do id do contato será editado
		String idmaterial = request.getParameter("idmaterial");
		System.out.println(idmaterial);
		//setar a variavel JavaBeans
		material.setIdmaterial(idmaterial);
		//executar metodo de seleção (dao)
		dao.selecionarMaterial(material);
		//setar os atributos
		request.setAttribute("idmaterial", material.getIdmaterial());
		request.setAttribute("nome", material.getNome());
		request.setAttribute("codMaterial", material.getCodMaterial());
		request.setAttribute("quantidade", material.getQuantidade());
		//encaminhar
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	protected void editarMaterial(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//setar variáveis
		material.setIdmaterial(request.getParameter("idmaterial"));
		material.setNome(request.getParameter("nome"));
		material.setCodMaterial(request.getParameter("codMaterial"));
		material.setQuantidade(request.getParameter("quantidade"));
		//executar metodo
		dao.alterarMaterial(material);
		//redirecionar para a lista.jsp
		response.sendRedirect("main");
	}
}
