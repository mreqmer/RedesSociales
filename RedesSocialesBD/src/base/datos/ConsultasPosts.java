package base.datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasPosts {

	/**
	 * Lista todos los posts de la base de datos
	 * @param conn
	 * @throws SQLException
	 */
	public static void selectPost(Connection conn) throws SQLException{

		PreparedStatement buscaPost = conn.prepareStatement("SELECT * FROM Posts;");
		ResultSet resultado = buscaPost.executeQuery();
		
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idPost") + " ");
			System.out.println("idUsuario: " + resultado.getString("idUsuario") + " ");
			System.out.println("created_at: " + resultado.getDate("created_at").toString() + " ");
			System.out.println("updated_at: " + resultado.getDate("updated_at").toString() + " ");
			System.out.println();
		}
		
		resultado.close();
		buscaPost.close();
			
	}
	
	/**
	 * Busca un post por su id
	 * @param conn
	 * @param idPost
	 * @throws SQLException
	 */
	public static void selectPostId(Connection conn, int idPost) throws SQLException{

		PreparedStatement buscaPost = conn.prepareStatement("SELECT * FROM Posts WHERE idPost = ?;");
		buscaPost.setInt(1, idPost); 
		ResultSet resultado = buscaPost.executeQuery();
		
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idPost") + " ");
			System.out.println("idUsuario: " + resultado.getString("idUsuario") + " ");
			System.out.println("created_at: " + resultado.getDate("created_at").toString() + " ");
			System.out.println("updated_at: " + resultado.getDate("updated_at").toString() + " ");
			System.out.println();
		}
		
		resultado.close();
		buscaPost.close();
			
	}
	
	/**
	 * Lista los posts de un usuario
	 * @param conn
	 * @param idUsuario
	 * @throws SQLException
	 */
	public static void selectPostIdUsuario(Connection conn, int idUsuario) throws SQLException{

		PreparedStatement buscaPost = conn.prepareStatement("SELECT * FROM Posts WHERE idUsuario = ?;");
		buscaPost.setInt(1, idUsuario); 
		ResultSet resultado = buscaPost.executeQuery();
		
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idPost") + " ");
			System.out.println("idUsuario: " + resultado.getString("idUsuario") + " ");
			System.out.println("created_at: " + resultado.getDate("created_at").toString() + " ");
			System.out.println("updated_at: " + resultado.getDate("updated_at").toString() + " ");
			System.out.println();
		}
		
		resultado.close();
		buscaPost.close();
			
	}
	
	/**
	 * Busca posts por fecha de creacion
	 * @param conn
	 * @param fechaCreacion
	 * @throws SQLException
	 */
	public static void selectPostsCreatedDate(Connection conn, Date fechaCreacion) throws SQLException {
		PreparedStatement buscaPost = conn.prepareStatement("SELECT * FROM Posts WHERE created_at = ?;");
		buscaPost.setDate(1, fechaCreacion); 
		ResultSet resultado = buscaPost.executeQuery();
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idPost") + " ");
			System.out.println("idUsuario: " + resultado.getString("idUsuario") + " ");
			System.out.println("created_at: " + resultado.getDate("created_at").toString() + " ");
			System.out.println("updated_at: " + resultado.getDate("updated_at").toString() + " ");
			System.out.println();
		}
		resultado.close();
		buscaPost.close();
			
	}
	
	/**
	 * Busca posts por fecha de update
	 * @param conn
	 * @param fechaUpdate
	 * @throws SQLException
	 */
	public static void selectPostsUpdateDate(Connection conn, Date fechaUpdate) throws SQLException {
		PreparedStatement buscaPost = conn.prepareStatement("SELECT * FROM Posts WHERE updated_at = ?;");
		buscaPost.setDate(1, fechaUpdate); 
		ResultSet resultado = buscaPost.executeQuery();
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idPost") + " ");
			System.out.println("idUsuario: " + resultado.getString("idUsuario") + " ");
			System.out.println("created_at: " + resultado.getDate("created_at").toString() + " ");
			System.out.println("updated_at: " + resultado.getDate("updated_at").toString() + " ");
			System.out.println();
		}
		resultado.close();
		buscaPost.close();
			
	}
	
}
