package entidades;

public class ClsUsuario {
	//idUsuario, Nombre, Apellidos, Username, Password, email
	//Atributos
	private int idUsuario;
	private String nombre;
	private String apellidos;
	private String username;
	private String email;
	
	//Propiedades
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	
	//constructores
	public ClsUsuario() {
		
	}
	
	public ClsUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	public ClsUsuario(int idUsuario, String nombre, String apellidos, String username, String email) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.username = username;
		this.email = email;
	}
	
	
	
	
	
}
