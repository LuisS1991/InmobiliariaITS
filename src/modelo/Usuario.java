package modelo;

import enumeracion.Rol;

public class Usuario {

	private String nombreUsuario;
	private String pass;
	private int rol;

	// usos genericos
	public Usuario() {

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

	public String ToStringRol(int i) {
		String nombre = "";
		
		if( Rol.CEO.getPuesto() == i ) {
			nombre = Rol.CEO.name();
		}
		else if(Rol.GERENTE.getPuesto() == i ) {
			nombre = Rol.GERENTE.name();
		}
		else {
			nombre = Rol.ADMINISTRATIVO.name();
		}
		return nombre;
	}

}
