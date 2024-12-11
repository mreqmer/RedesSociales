package principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import base.datos.ConsultasLikes;
import base.datos.ConsultasPosts;
import base.datos.ConsultasUsuario;
import entidades.ClsLike;
import entidades.ClsPost;

public class SubmenuLikes {

	static Scanner sc = new Scanner(System.in);

	// logica del menu likes
	public static void listadoLikes(Connection conn) {

		int subOpc = 0;
		int id = 0;
		String username = "";

		System.out.println("¿Que quiere buscar?");
		System.out.println("1. Todos");
		System.out.println("2. Buscar por id");
		System.out.println("3. Buscar por id de usuario");
		System.out.println("4. Buscar por id de Post");
		subOpc = sc.nextInt();

		switch (subOpc) {

		case 1 -> {
			try {
				base.datos.ConsultasLikes.selectLikes(conn);
			} catch (SQLException e) {
				System.out.println("No se encontraron Likes");
			}
		}
		case 2 -> {
			try {
				System.out.println("Introduce el id: ");
				id = sc.nextInt();

				ConsultasUsuario.selectUsuario(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
		case 3 -> {
			try {
				System.out.println("Introduce el username: ");
				sc.nextLine();
				username = sc.nextLine();
				ConsultasUsuario.selectUsuario(conn, username);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}

		}

	}
	
	/**
	 * Submenu para el main para insertar un nuevo like
	 * @param conn
	 */
	public static void insercionLikes(Connection conn) {
		
		int idPost;
		int idUsuario;
		
		System.out.println("Usuario que creó el post: ");
		idUsuario = sc.nextInt();
		
		try {
			if(ConsultasUsuario.existeUsuarioId(conn, idUsuario)) {
				
				System.out.println("Post del like: ");
				idPost = sc.nextInt();
				
				if(ConsultasPosts.existePostId(conn, idPost)) {
					
					ClsLike l = new ClsLike(idUsuario, idPost);
					ConsultasLikes.insertaLike(conn, l);
					System.out.println("Like creado correctamente");
				}else {
					System.out.println("No existe el post.");
				}
			}else {
				System.out.println("No existe el usuario.");
			}
		} catch (SQLException e) {
			System.out.println("Error.");
		}
	
		
		
		
		
		
		
		
	}
	
//	String nombre;
//	String apellidos;
//	String username;
//	String password;
//	String email;
//	
//	
//	System.out.println("Nombre: ");
//    nombre = sc.nextLine();
//    
//    System.out.println("Apellidos: ");
//    apellidos = sc.nextLine();
//    
//    System.out.println("Nombre de usuario (Username): ");
//    username = sc.nextLine();
//    
//    System.out.println("Contraseña: ");
//    password = sc.nextLine();
//    
//    System.out.println("Email: ");
//    email = sc.nextLine();
//    
//    //Los campos no pueden estar vacios
//    try {
//    	ClsUsuario p = new ClsUsuario(nombre, apellidos, username, password, email);	
//    	ConsultasUsuario.insertUsuario(conn, p);
//		
//    }catch(IllegalArgumentException e) {
//    	System.out.println( e );
//    } catch (SQLException e) {
//
//    	System.out.println("No se pudieron insertar los datos.");
//	}
}