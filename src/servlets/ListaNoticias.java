package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

@WebServlet("/ListaNoticias")
public class ListaNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaNoticias() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticiaService noticiaService = new NoticiaService();
		ArrayList<Noticia> listaNoticias = noticiaService.listarNoticias();
		
		for(Noticia noticia : listaNoticias) {
			
			response.getWriter().println("<h1>" + noticia.getTitulo() + "</h1>" 
										+"<h3>" + noticia.getDescricao() + "</h3>" 
										+"<p>" + noticia.getTexto() + "</p>"
										+"<br/>"
										+"<br/>"
										+"<p>Comentários</p>");
			
			ComentarioService comentarioService = new ComentarioService();
			ArrayList<Comentario> comentariosNoticia = comentarioService.listarComentario(noticia.getId());
			for(Comentario comentario : comentariosNoticia) {
				
			response.getWriter().println("<hr/>"
										+"<span>" + comentario.getNome() + "</span>"
										+"<p>" + comentario.getTexto() + "</p>"
										+"<hr/>");
			}
			
			response.getWriter().println("<span>Faça o seu comentário abaixo</span>");
			
			response.getWriter().println("<form method=\"post\" action=\"CadastrarComentario\">"
										+"<br/>"
										+"<br/>"
										+"Nome:<input type=\"text\" value=\"\" name=\"nome\" />"
									    +"<br/>"
									    +"<br/>"
										+"<input type=\"text\" value=\"\" name=\"texto\" />"
										+"<input type=\"hidden\" name=\"id_noticia\" value=\""+ noticia.getId() +"\"/>"
									    +"<input type=\"submit\" value=\"Comentar\" />"
										+"</form>");
		}
	}

}
