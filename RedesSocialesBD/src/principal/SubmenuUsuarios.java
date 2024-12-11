package principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import base.datos.ConsultasUsuario;
import entidades.ClsUsuario;

public class SubmenuUsuarios {

	static Scanner sc = new Scanner(System.in);

	// opcion del menu listado
	public static void listadoUsuarios(Connection conn) {

		int subOpc = 0;
		int id = 0;
		String username = "";

		System.out.println("¿Que quiere buscar?");
		System.out.println("1. Todos");
		System.out.println("2. Buscar por id");
		System.out.println("3. Buscar por username");
		subOpc = sc.nextInt();

		switch (subOpc) {

		case 1 -> {
			try {
				ConsultasUsuario.selectUsuario(conn);
			} catch (SQLException e) {
				System.out.println("No se encontraron usuarios");
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
	 * Insercion de usuario con comprobaciones
	 * @param conn
	 */
	public static void insercionUsuarios(Connection conn) {
		
		String nombre;
		String apellidos;
		String username;
		String password;
		String email;
		
		
		System.out.println("Nombre: ");
        nombre = sc.nextLine();
        
        System.out.println("Apellidos: ");
        apellidos = sc.nextLine();
        
        System.out.println("Nombre de usuario (Username): ");
        username = sc.nextLine();
        
        System.out.println("Contraseña: ");
        password = sc.nextLine();
        
        System.out.println("Email: ");
        email = sc.nextLine();
        
        //Los campos no pueden estar vacios
        try {
        	ClsUsuario p = new ClsUsuario(nombre, apellidos, username, password, email);	
        	ConsultasUsuario.insertUsuario(conn, p);
			System.out.println("Usuario insertado correctamente.");
        }catch(IllegalArgumentException e) {
        	System.out.println( e );
        } catch (SQLException e) {

        	System.out.println("No se pudieron insertar los datos.");
		}
		
	}
	
	/**
	 * Submenu del main para el update de un usuario si existe
	 * @param conn
	 */
	public static void updateUsuario(Connection conn) {
		
		int idUsuario;
		String nombre;
		String apellidos;
		String username;
		String password;
		String email;
		
		
		
		try {
			System.out.println("¿Que usuario desea modificar?");
			idUsuario = sc.nextInt();
			sc.nextLine();
			if(ConsultasUsuario.existeUsuarioId(conn, idUsuario)) {
				
				System.out.println("Nombre: ");
		        nombre = sc.nextLine();
		        
		        System.out.println("Apellidos: ");
		        apellidos = sc.nextLine();
		        
		        System.out.println("Nombre de usuario (Username): ");
		        username = sc.nextLine();
		        
		        System.out.println("Contraseña: ");
		        password = sc.nextLine();
		        
		        System.out.println("Email: ");
		        email = sc.nextLine();	
		        
		        ClsUsuario u = new ClsUsuario(idUsuario, nombre, apellidos, username, password, email);
		        ConsultasUsuario.updateUsuario(conn, u);
		        System.out.println("Usuario updateado correctamente.");
				
			}else {
				System.out.println("EL usuario no existe.");
			}
		} catch (SQLException e) {
			System.out.println("Error.");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
