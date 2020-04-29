package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/AlterarNoticias")
public class AlterarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlterarNoticias() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Noticia n = new Noticia();
		n.setDescricao(request.getParameter("descricao"));
		n.setTitulo(request.getParameter("titulo"));
		n.setTexto(request.getParameter("texto"));
		n.setId(id);
		
		NoticiaService service = new NoticiaService();
		service.alterar(n);
		
	}
}
