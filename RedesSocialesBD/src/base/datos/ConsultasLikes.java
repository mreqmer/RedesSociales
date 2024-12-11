package base.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.ClsLike;
import entidades.ClsPost;

public class ConsultasLikes {
	
	//EMPIEZAN LOS SELECT
	
	
	
	/**
	 * Lista todos los likes
	 * @param conn
	 * @throws SQLException
	 */
	public static void selectLikes(Connection conn) throws SQLException{

		PreparedStatement buscaLikes = conn.prepareStatement("SELECT * FROM Likes");

		ResultSet resultado = buscaLikes.executeQuery();
		
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idLikes") + " ");
			System.out.println("idUsuario: " + resultado.getInt("idUsuarios") + " ");
			System.out.println("idPost: " + resultado.getInt("idPost") + " ");
			System.out.println();
		}
		
		resultado.close();
		buscaLikes.close();
			
	}
	
	/**
	 * Busca por un idLike concreto
	 * @param conn
	 * @param idLikes
	 * @throws SQLException
	 */
	public static void selectLikesIdLikes(Connection conn, int idLikes) throws SQLException {
		
		PreparedStatement buscaLikes = conn.prepareStatement("SELECT * FROM Likes WHERE idLikes = ?");
		buscaLikes.setInt(1, idLikes); 
		ResultSet resultado = buscaLikes.executeQuery();
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idLikes") + " ");
			System.out.println("idUsuario: " + resultado.getInt("idUsuarios") + " ");
			System.out.println("idPost: " + resultado.getInt("idPost") + " ");
			System.out.println();
		}
		resultado.close();
		buscaLikes.close();	
	}
	
	/**
	 * Busca por un id de usuario
	 * @param conn
	 * @param idUsuario
	 * @throws SQLException
	 */
	public static void selectLikesIdUsuario(Connection conn, int idUsuario) throws SQLException {
			
			PreparedStatement buscaLikes = conn.prepareStatement("SELECT * FROM Likes WHERE idUsuario = ?");
			buscaLikes.setInt(1, idUsuario); 
			ResultSet resultado = buscaLikes.executeQuery();
			while (resultado.next()) {
				System.out.println("id: " + resultado.getInt("idLikes") + " ");
				System.out.println("idUsuario: " + resultado.getInt("idUsuarios") + " ");
				System.out.println("idPost: " + resultado.getInt("idPost") + " ");
				System.out.println();
			}
			resultado.close();
			buscaLikes.close();	
		}
	
	/**
	 * Busca por un id de Post
	 * @param conn
	 * @param idPosts
	 * @throws SQLException
	 */
	public static void selectLikesIdPosts(Connection conn, int idPosts) throws SQLException {
		
		PreparedStatement buscaLikes = conn.prepareStatement("SELECT * FROM Likes WHERE idPosts = ?");
		buscaLikes.setInt(1, idPosts); 
		ResultSet resultado = buscaLikes.executeQuery();
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idLikes") + " ");
			System.out.println("idUsuario: " + resultado.getInt("idUsuarios") + " ");
			System.out.println("idPost: " + resultado.getInt("idPost") + " ");
			System.out.println();
		}
		resultado.close();
		buscaLikes.close();	
	}
	
	//EMPIEXAN LOS INSERTS
	
	public static void insertaLike(Connection conn, ClsLike l) throws SQLException {

		String insercion = "INSERT INTO Likes (idUsuarios, idPost) VALUES (?, ?)";

		PreparedStatement insercionLike = conn.prepareStatement(insercion);

		insercionLike.setInt(1, l.getIdUsuarios());
		insercionLike.setInt(2, l.getIdPost());

		insercionLike.executeUpdate();

		insercionLike.close();

	}

	
	

}
