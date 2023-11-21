package modelo;

public class Usuario {
	private int cedula;
	private String nombreUsuario;
	private String pass;
	private int rol;

	// usos genericos
	public Usuario() {

	}

	
	
	public int getCedula() {
		return cedula;
	}



	public void setCedula(int cedula) {
		this.cedula = cedula;
	}



	public Usuario(String nombreUsuario, String pass, int rol) {
		this.nombreUsuario = nombreUsuario;
		this.pass = pass;
		this.rol = rol;
	}

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

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

}
