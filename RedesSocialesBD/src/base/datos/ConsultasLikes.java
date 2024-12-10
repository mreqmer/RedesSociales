package base.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasLikes {
	
	public static void selectLikes(Connection conn) throws SQLException{

		PreparedStatement buscaPost = conn.prepareStatement("SELECT * FROM Likes");

		ResultSet resultado = buscaPost.executeQuery();
		
		while (resultado.next()) {
			System.out.println("id: " + resultado.getInt("idLikes") + " ");
			System.out.println("idUsuario: " + resultado.getInt("idUsuarios") + " ");
			System.out.println("idPost: " + resultado.getInt("idPost") + " ");
			System.out.println();
		}
		
		resultado.close();
		buscaPost.close();
			
	}

}
