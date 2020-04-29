package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

public class NoticiaDAO {

	private Connection conexao;

	public NoticiaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Noticia n) {

		String inserir = "INSERT INTO noticia " + " (descricao, titulo, texto) " + " VALUES (?, ?, ?) ";

		try (PreparedStatement pst = conexao.prepareStatement(inserir)) {

			pst.setString(1, n.getDescricao());
			pst.setString(2, n.getTitulo());
			pst.setString(3, n.getTexto());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Noticia.");
			ex.printStackTrace();

		}
	}

	public void alterar(Noticia n) {

		String alterar = "UPDATE noticia " + "SET descricao = ?, texto = ?, titulo = ? " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(alterar)) {

			pst.setString(1, n.getDescricao());
			pst.setString(2, n.getTexto());
			pst.setString(3, n.getTitulo());
			pst.setInt(4, n.getId());

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Noticia.");
			ex.printStackTrace();

		}
	}

	public void excluir(int id) {

		String excluir = "DELETE FROM noticia " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(excluir)) {

			pst.setInt(1, id);

			pst.execute();

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Noticia.");
			ex.printStackTrace();
		}
	}

	public Noticia consultar(int id) {

		String consultar = "SELECT * FROM noticia " + " WHERE id = ? ";

		try (PreparedStatement pst = conexao.prepareStatement(consultar)) {

			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();

			Noticia n = new Noticia();
			if (resultado.next()) {
				n.setTitulo(resultado.getString("titulo"));
				n.setTexto(resultado.getString("texto"));
				n.setId(id);
				n.setDescricao(resultado.getString("descricao"));
			}
			return n;

		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Noticia.");
			ex.printStackTrace();

			return null;
		}
	}
	

	public ArrayList<Noticia> listarNoticias() {
		ArrayList<Noticia> lista = new ArrayList<>();
		String listar = "SELECT * FROM noticia";

		try (PreparedStatement pst = conexao.prepareStatement(listar)) {

			ResultSet resultado = pst.executeQuery();

			
			while (resultado.next()) {
				Noticia n = new Noticia();
				n.setTitulo(resultado.getString("titulo"));
				n.setTexto(resultado.getString("texto"));
				n.setId(resultado.getInt("id"));
				n.setDescricao(resultado.getString("descricao"));
				lista.add(n);
			}
		} catch (SQLException ex) {

			System.err.println("Não foi possível manipular " + "a tabela Noticia.");
			ex.printStackTrace();

		}
		return lista;
	}
}
