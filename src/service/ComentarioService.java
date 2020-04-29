package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {
	private ComentarioDAO comentarioDAO;

	public ComentarioService() {
		super();
		this.comentarioDAO = new ComentarioDAO();
	}
	
	public void cadastrar(Comentario c){
		this.comentarioDAO.cadastrar(c);
	}
	
	public void alterar(Comentario c){
		this.comentarioDAO.alterar(c);
	}
	
	public void excluir(Comentario c){
		this.comentarioDAO.excluir(c);
	}
	
	public Comentario consultar(int id){
		return this.comentarioDAO.consultar(id);
	}
	
	public ArrayList<Comentario> listarComentario(int idNoticia){
		return this.comentarioDAO.listarComentario(idNoticia);
	}
}
