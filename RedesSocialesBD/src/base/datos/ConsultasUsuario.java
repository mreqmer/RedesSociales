package base.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasUsuario {

	/**
	 * Muestra a todos los usuarios de la base de datos
	 * @param conn
	 * @throws SQLException
	 */
	public static void selectUsuario(Connection conn) throws SQLException{

		PreparedStatement buscaUsuario = conn.prepareStatement("SELECT * FROM Usuarios;");
		ResultSet resultado = buscaUsuario.executeQuery();
		
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idUsuario") + " ");
			System.out.println("Nombre: " + resultado.getString("nombre") + " ");
			System.out.println("Apellidos: " + resultado.getString("apellidos") + " ");
			System.out.println("Username: " + resultado.getString("Username") + " ");
			System.out.println("email: " + resultado.getString("email") + " ");
		}
		
		resultado.close();
		buscaUsuario.close();
			
	}
	
	/**
	 * Muestra al usuario con el id especificado
	 * @param conn
	 * @param idUsuario
	 * @throws SQLException
	 */
	public static void selectUsuario(Connection conn, int idUsuario) throws SQLException{

		PreparedStatement buscaUsuario = conn.prepareStatement("SELECT * FROM Usuarios WHERE idUsuario = ?");
		buscaUsuario.setInt(1, idUsuario); 
		ResultSet resultado = buscaUsuario.executeQuery();
		
		while(resultado.next()){
			
			System.out.println("id: " + resultado.getInt("idUsuario") + " ");
			System.out.println("Nombre: " + resultado.getString("nombre") + " ");
			System.out.println("Apellidos: " + resultado.getString("apellidos") + " ");
			System.out.println("Username: " + resultado.getString("Username") + " ");
			System.out.println("email: " + resultado.getString("email") + " ");
		}
		
		resultado.close();
		buscaUsuario.close();
			
			
	}
	
	/**
	 * Muestra al usuario con el username especificado
	 * @param conn
	 * @param username
	 * @throws SQLException
	 */
	public static void selectUsuario(Connection conn, String username) throws SQLException{

		PreparedStatement buscaUsuario = conn.prepareStatement("SELECT * FROM Usuarios WHERE username = ?");
		buscaUsuario.setString(1, username); 
		ResultSet resultado = buscaUsuario.executeQuery();
		
		while(resultado.next()){
			System.out.println("idUsuario: " + resultado.getInt("idUsuario") + " ");
			System.out.println("Nombre: " + resultado.getString("nombre") + " ");
			System.out.println("Apellidos: " + resultado.getString("apellidos") + " ");
			System.out.println("Username: " + resultado.getString("Username") + " ");
			System.out.println("email: " + resultado.getString("email") + " ");
		}
		resultado.close();
		buscaUsuario.close();
			
			
	}
	
	
}
