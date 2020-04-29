package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

public class ComentarioDAO {
	
	private Connection conexao;

	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario c) {

		String inserir = "INSERT INTO comentario " + " (nome, texto, fk_noticia_id) " + " VALUES (?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, c.getNome());
			pst.setString(2, c.getTexto());
			pst.setInt(3, c.getFkNoticiaId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela comentario.");
			ex.printStackTrace();

		}
	}

	public void alterar(Comentario c) {

		String alterar = "UPDATE comentario " + "SET nome = ?, texto = ? " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(alterar)) {

			pst.setString(1, c.getNome());
			pst.setString(2, c.getTexto());
			pst.setInt(3, c.getId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela comentario.");
			ex.printStackTrace();

		}
	}

	public void excluir(Comentario c) {

		String excluir = "DELETE FROM comentario " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(excluir)) {

			pst.setInt(1, c.getId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela comentario.");
			ex.printStackTrace();
		}
	}

	public Comentario consultar(int id) {

		String consultar = "SELECT * FROM comentario " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(consultar)) {

			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();

			Comentario c = new Comentario();
			if (resultado.next()) {
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setId(id);
				c.setFkNoticiaId(resultado.getInt("fk_noticia_id"));
			}
			return c;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela comentario.");
			ex.printStackTrace();

			return null;
		}
	}

	public ArrayList<Comentario> listarComentario(int idNoticia) {
		ArrayList<Comentario> lista = new ArrayList<>();
		String listar = "SELECT * FROM comentario" + "WHERE fk_noticia_id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(listar)) {
			
			pst.setInt(1, idNoticia);

			ResultSet resultado = pst.executeQuery();
			
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setNome(resultado.getString("nome"));
				c.setTexto(resultado.getString("texto"));
				c.setId(resultado.getInt("id"));
				c.setFkNoticiaId(resultado.getInt("fk_noticia_id"));
				lista.add(c);
			}
		} catch (SQLException ex) {
			System.err.println("Não foi possível manipular " + "a tabela cometario.");
			ex.printStackTrace();
		}
		return lista;
	}
	
}
