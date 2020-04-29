package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import service.ComentarioService;

@WebServlet("/CadastrarComentario")
public class CadastrarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarComentario() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Comentario c =  new Comentario();
		c.setNome(request.getParameter("nome"));
		c.setTexto(request.getParameter("texto"));	
		c.setFkNoticiaId(Integer.parseInt(request.getParameter("id_noticia")));
		
		ComentarioService service = new ComentarioService();
		service.cadastrar(c);
	}
}
