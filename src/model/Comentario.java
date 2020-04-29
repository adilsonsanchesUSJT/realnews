package model;

public class Comentario {
	private int id;
	private String nome;
	private String texto;
	private int fk_noticia_id;
	
	public Comentario(int id, String nome, String texto, int fk_noticia_id) {
		super();
		this.id = id;
		this.nome = nome;
		this.texto = texto;
		this.fk_noticia_id = fk_noticia_id;
	}
	
	public Comentario() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getFkNoticiaId() {
		return fk_noticia_id;
	}
	public void setFkNoticiaId(int fk_noticia_id) {
		this.fk_noticia_id = fk_noticia_id;
	}	
}
