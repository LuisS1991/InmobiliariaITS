package controlador;

import javax.swing.JOptionPane;
import modelo.Usuario;
import repositorio.RepositorioUsuarios;
import vistas.Usuarios;

public class UsuariosController {

	private static RepositorioUsuarios repoUsuarios;
	private static Usuarios usuarios;

	public static Usuarios ShowUsuarios() {
		usuarios = new Usuarios();
		return usuarios;
	}

	public static void GuardarUsuarios(String nombreUsuario, String pass, String repitePass, int rol) {
		boolean resultado = repoUsuarios.AgregarUsuario(new Usuario(nombreUsuario, pass, rol));
		if (resultado == true) {
			JOptionPane.showInternalMessageDialog(null, "Usuario Guardado Correctamente", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showInternalMessageDialog(null, "Error al gurdar los datos", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public static boolean InicioSesion() {
		return true;
	}

}
