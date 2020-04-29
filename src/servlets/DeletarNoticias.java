package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticiaService;

@WebServlet("/DeletarNoticias")
public class DeletarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletarNoticias() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		NoticiaService service = new NoticiaService();
		service.excluir(id);
	}
}
