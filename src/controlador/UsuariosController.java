package controlador;

import java.awt.Cursor;

import javax.swing.JOptionPane;
import modelo.Usuario;
import repositorio.RepositorioUsuarios;
import utiles.ValidarEntradas;
import vistas.Usuarios;

public class UsuariosController {

	private static RepositorioUsuarios repoUsuarios;
	private static Usuarios usuarios;

	public static Usuarios ShowUsuarios() {
		usuarios = new Usuarios();
		return usuarios;
	}

	public static void GuardarUsuarios(String nombreUsuario, String pass, String repitePass, int rol) {
		usuarios.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Usuario u = new Usuario(nombreUsuario, pass, rol);
		repoUsuarios = new RepositorioUsuarios();
		if (pass.equals(repitePass)) {
			boolean resultado = repoUsuarios.AgregarUsuario(u);
			if (resultado == true) {
				JOptionPane.showMessageDialog(null, "Usuario Guardado Correctamente", "Mensaje",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error al gurdar los datos", "Alerta", JOptionPane.WARNING_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "las contrasenas son diferentes", "Alerta",
					JOptionPane.WARNING_MESSAGE);
		}
		usuarios.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin

	public static Usuario InicioSesion(String cedula, String pass) {
		if (cedula.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nro de Cedula No ser vacio", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else {
			if (ValidarEntradas.ValidarEntreadaNumerica(cedula)) {
				repoUsuarios = new RepositorioUsuarios();
				return repoUsuarios.AutenticarUsuario(cedula, pass);
			} else {
				JOptionPane.showMessageDialog(null, "Nro de Cedula No valido", "Alerta", JOptionPane.WARNING_MESSAGE);
			}
		}
		return null;
	
	}// fin

}
