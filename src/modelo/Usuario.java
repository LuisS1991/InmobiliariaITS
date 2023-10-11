package modelo;

public class Usuario {

	private String nombreUsuario;
	private String pass;
	private String rol;
	

	//usos genericos 
	public Usuario() {
		
	}
	
	//creamos un nuevo usuario
	public Usuario(String nombreUsuario, String pass, String rol) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.rol = rol;
	}
	

	//logeamos un usuario
	public Usuario(String nombreUsuario, String pass) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
	}
	
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}
