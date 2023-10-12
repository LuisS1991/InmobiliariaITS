package controlador;

import java.util.ArrayList;

import conexion.Conexion;
import modelo.Usuario;
import repositorio.RepositorioUsuarios;
import vistas.Usuarios;

public class UsuariosController {

	@SuppressWarnings("unused")
	private static Conexion conexion;
	private static RepositorioUsuarios repoUsuarios;
	private static Usuarios usuarios;	
	
	public static Usuarios ShowUsuarios() {		
		usuarios = new Usuarios(ListarUsuarios());
		return usuarios;
	}
	
	public static void GuardarUsuarios() {
		
	}
	
	public static ArrayList<Usuario> ListarUsuarios() {
		repoUsuarios = new RepositorioUsuarios();
		repoUsuarios.testConexionDB();
		return repoUsuarios.ListarUsuarios();
	}
	
	public static boolean InicioSesion() {
		return true;
	}

}
