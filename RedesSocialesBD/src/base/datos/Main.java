package base.datos;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.Date;


public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opc = -1;
		int subOpc = 0;
		String tabla = "";
		
		Connection conn = Conexion.conecta();
		
//		Ejecutar solo para crear e inserar datos iniciales en las tablas si no está ya en la base de datos
		
//		CreacionInicialDatos.creaTablaUsuarios(conn);
//		CreacionInicialDatos.creaTablaPosts(conn);
//		CreacionInicialDatos.creaTablaLikes(conn);
//		
//		CreacionInicialDatos.insertaInicialTablaUsuarios(conn);
//		CreacionInicialDatos.insertaInicialTablaPosts(conn);
//		CreacionInicialDatos.insertaInicialTablaLikes(conn);
		muestraMenu();
		opc = sc.nextInt();
		sc.nextLine();
		
		switch(opc) {
			case 1 ->{
				

			}case 2 ->{
				
			}case 3 ->{
				System.out.println("¿Que tabla quiere listar?");
				tabla = sc.nextLine();
				
				switch (tabla) {
				
				case "Usuarios" ->{
					listadoUsuarios(conn);
				}case "Posts" ->{
					listadoPosts(conn);
				}case "Likes" ->{
					listadoLikes(conn);
				}default ->{
					System.out.println("Tabla no encontrada.");
				}
				
				}
				
				
			}case 4->{
				
			}case 5 ->{
				
			}case 6->{
				
			}
		}
		
		
		
		
		
	}
	//Menu 
	public static void muestraMenu() {	
		 System.out.println("\nSelecciona una opción:");
         System.out.println("1. Crear Tablas");
         System.out.println("2. Insertar");
         System.out.println("3. Listar");
         System.out.println("4. Modificar");
         System.out.println("5. Borrar");
         System.out.println("6. Eliminar Tablas");
         System.out.println("0. Salir");
	}
	
	//opcion del menu listado
	public static void listadoUsuarios(Connection conn) {
		
		int subOpc = 0;
		int id = 0;
		String username = "";
		
		System.out.println("¿Que quiere buscar?");
		System.out.println("1. Todos");
		System.out.println("2. Buscar por id");
		System.out.println("3. Buscar por username");
		subOpc = sc.nextInt();
		
		switch(subOpc) {
		
		case 1 ->{
			try {
				ConsultasUsuario.selectUsuario(conn);
			} catch (SQLException e) {
				System.out.println("No se encontraron usuarios");
			}
		}case 2 -> {
			try {
				System.out.println("Introduce el id: ");
				id = sc.nextInt();
				
				ConsultasUsuario.selectUsuario(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}case 3 ->{
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
		
		switch(subOpc) {
		
		case 1 ->{
			try {
				ConsultasPosts.selectPost(conn);
			} catch (SQLException e) {
				System.out.println("No se encontraron Posts");
			}
		}case 2 -> {
			try {
				System.out.println("Introduce el id: ");
				id = sc.nextInt();
				ConsultasPosts.selectPostId(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}case 3 ->{
			try {
				System.out.println("Introduce el id: ");
				id = sc.nextInt();
				ConsultasPosts.selectPostIdUsuario(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}case 4 ->{
			try {
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
		
	}
	
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
		
		switch(subOpc) {
		
		case 1 ->{
			try {
				ConsultasLikes.selectLikes(conn);
			} catch (SQLException e) {
				System.out.println("No se encontraron Likes");
			}
		}case 2 -> {
			try {
				System.out.println("Introduce el id: ");
				id = sc.nextInt();
				
				ConsultasUsuario.selectUsuario(conn, id);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		}case 3 ->{
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
		
	
	
	
	
}
