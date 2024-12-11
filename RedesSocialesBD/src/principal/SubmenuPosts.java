package principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import base.datos.ConsultasPosts;
import base.datos.ConsultasUsuario;
import entidades.ClsPost;
import entidades.ClsUsuario;

public class SubmenuPosts {

	static Scanner sc = new Scanner(System.in);

	// opcion del menu posts
	public static void listadoPosts(Connection conn) {

		int subOpc = 0;
		int id = 0;
		long dia;
		long mes;
		long ano;
		String fecha = "";
		String username = "";

		System.out.println("¿Que quiere buscar?");
		System.out.println("1. Todos");
		System.out.println("2. Buscar por id de Post");
		System.out.println("3. Buscar id de usuario");
		System.out.println("4. Buscar fecha de creacion");
		System.out.println("5. Buscar fecha de actualizacion");
		subOpc = sc.nextInt();

		switch (subOpc) {

		case 1 -> {
			try {
				ConsultasPosts.selectPost(conn);
			} catch (SQLException e) {
				System.out.println("No se encontraron Posts");
			}
		}
		case 2 -> {
			try {
				System.out.println("Introduce el id: ");
				id = sc.nextInt();
				ConsultasPosts.selectPostId(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
		case 3 -> {
			try {
				System.out.println("Introduce el id: ");
				id = sc.nextInt();
				ConsultasPosts.selectPostIdUsuario(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}
		case 4 -> {
			try {
				// TODO
				System.out.println("Introduce la fecha de creacion: ");
				System.out.println("Dia: ");
				fecha = sc.nextLine();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date fechaUtil = sdf.parse(fecha);
					Date fechaSql = new Date(fechaUtil.getTime());
				} catch (Exception e) {

					System.out.println("Fecha invalida");
				}

				ConsultasPosts.selectPostIdUsuario(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}

		}

		sc.close();
		
	}

	//opcion del menu para insertar un post
	public static void insercionPost(Connection conn) {

		int idUsuario;

		System.out.println("Ingrese el ID del usuario que lo creo:");
		idUsuario = sc.nextInt();
		sc.nextLine();

		try {
			if(ConsultasUsuario.existeUsuarioId(conn, idUsuario)) {
				
				
				try {
		            ClsPost post = new ClsPost(idUsuario);
		            ConsultasPosts.insertaPost(conn, post);
		            System.out.println("Post insertado correctamente.");
		        } catch (Exception e) {
		            System.out.println("Error al crear el post: " );
		        }
				
			}else {
				System.out.println("Ese usuario no existe.");
			}
		} catch (SQLException e) {
			System.out.println("Error con el id");
		} finally {
            sc.close();
        }
		
    }
	
	public static void updatePost(Connection conn) {
		
		int idPost;
		int idUsuario;
		
		System.out.println("Ingrese el Id del post a modificar");
		idPost = sc.nextInt();
		sc.nextLine();
		
		try {
			
			if(ConsultasPosts.existePostId(conn, idPost)) {
				ClsPost p = ConsultasPosts.selectPostIdObjeto(conn, idPost);
				System.out.println("Nuevo creador del post: ");
				idUsuario = sc.nextInt();
				sc.nextLine();
				
				if(ConsultasUsuario.existeUsuarioId(conn, idUsuario)) {
					
					p.setIdUsuario(idUsuario);
					
					ConsultasPosts.updatePost(conn, p);
					
				}else {
					System.out.println("Ese usuario no existe");
				}
				
				
			}else {
				System.out.println("Ese post no existe.");
			}
		} catch (SQLException e) {
			System.out.println("Error.");
		}
		
		
	}
}
