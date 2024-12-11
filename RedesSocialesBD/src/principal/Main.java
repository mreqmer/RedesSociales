package principal;

import java.sql.Connection;
import java.util.Scanner;
import base.datos.Conexion;
import base.datos.CreacionInicialDatos;


public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opc = -1;
		int subOpc = 0;
		Connection conn = Conexion.conecta();

//		Ejecutar solo para crear e inserar datos iniciales en las tablas si no está ya en la base de datos
//
//		CreacionInicialDatos.creaTablaUsuarios(conn);
//		CreacionInicialDatos.creaTablaPosts(conn);
//		CreacionInicialDatos.creaTablaLikes(conn);		
//		CreacionInicialDatos.insertaInicialTablaUsuarios(conn);
//		CreacionInicialDatos.insertaInicialTablaPosts(conn);
//		CreacionInicialDatos.insertaInicialTablaLikes(conn);
		muestraMenu();
		opc = sc.nextInt();
		sc.nextLine();

		switch (opc) {
		case 1 -> {

		}
		case 2 -> {
			System.out.println("¿En que tabla quiere insertar?");
			String tabla;
			tabla = sc.nextLine();

			switch (tabla) {
			case "Usuarios" -> {
				SubmenuUsuarios.insercionUsuarios(conn);
			}
			case "Posts" -> {
				SubmenuPosts.insercionPost(conn);
			}
			case "Likes" -> {
				SubmenuLikes.insercionLikes(conn);
			}
			default -> {
				System.out.println("Tabla no encontrada.");
			}

			}
			
			
		}
		case 3 -> {
			System.out.println("¿Que tabla quiere listar?");
			String tabla;
			tabla = sc.nextLine();

			switch (tabla) {
			case "Usuarios" -> {
				SubmenuUsuarios.listadoUsuarios(conn);
			}
			case "Posts" -> {
				SubmenuPosts.listadoPosts(conn);
			}
			case "Likes" -> {
				SubmenuLikes.listadoLikes(conn);
			}
			default -> {
				System.out.println("Tabla no encontrada.");
			}

			}

		}
		case 4 -> {
			System.out.println("¿En que tabla quieres hacer la modificación?");
			String tabla;
			tabla = sc.nextLine();
			
			switch (tabla) {
			case "Usuarios" -> {
				SubmenuUsuarios.updateUsuario(conn);
			}
			case "Posts" -> {
				
				//Aquí realmente no se debería poder cambiar el creador del post, pero para probar la actualización si se puede cambiar
				SubmenuPosts.updatePost(conn);
				
			}
			case "Likes" -> {
				System.out.println("No se pude modificar un like");
			}
			default -> {
				System.out.println("Tabla no encontrada.");
			}

		}
		}
		case 5 -> {

		}
		case 6 -> {

		}
		}

	}

	private static void seleccionaTabla(Connection conn) {
		String tabla;
		tabla = sc.nextLine();

		switch (tabla) {

		case "Usuarios" -> {
			SubmenuUsuarios.listadoUsuarios(conn);
		}
		case "Posts" -> {
			SubmenuPosts.listadoPosts(conn);
		}
		case "Likes" -> {
			SubmenuLikes.listadoLikes(conn);
		}
		default -> {
			System.out.println("Tabla no encontrada.");
		}

		}
	}

	// Menu
	private static void muestraMenu() {
		System.out.println("\nSelecciona una opción:");
		System.out.println("1. Crear Tablas");
		System.out.println("2. Insertar");
		System.out.println("3. Listar");
		System.out.println("4. Modificar");
		System.out.println("5. Borrar");
		System.out.println("6. Eliminar Tablas");
		System.out.println("0. Salir");
	}

}
