package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public static void GuardarUsuarios(String nombreUsuario,String pass,String repitePass,int rol) {
		boolean resultado = repoUsuarios.AgregarUsuario(new Usuario(nombreUsuario,pass,rol));
		if(resultado==true) {
				JOptionPane.showInternalMessageDialog(null,"Usuario Guardado Correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
		}else{
				JOptionPane.showInternalMessageDialog(null,"Error al gurdar los datos","Alerta",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static ArrayList<Usuario> ListarUsuarios() {
		repoUsuarios = new RepositorioUsuarios();
		return repoUsuarios.ListarUsuarios();
	}
	
	public static boolean InicioSesion() {
		return true;
	}

}
