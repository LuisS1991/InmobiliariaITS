package controlador;

import java.awt.Cursor;
import java.util.HashMap;

import javax.swing.JOptionPane;

import modelo.Usuario;
import utiles.CargarConfiguracion;
import vistas.Login;
import vistas.VentanaPpl;

public class Aplicacion {

	private static VentanaPpl ventana = null;
	private static Usuario usuarioActual = null;
	public static HashMap<String, String> configApp;

	public Aplicacion() {
		configApp = CargarConfiguracion.LoadConfigApp();
		ventana = new VentanaPpl();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.CambiarVistaPanel(new Login());
	}

	public static void InicioSesion(String cedula, String pass) {
		ventana.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		usuarioActual = UsuariosController.InicioSesion(cedula, pass);
		if(usuarioActual !=null) {
			ventana.CambiarVistaPanel(MenuPrincipalController.ShowMenuPrinciapl());	
		}
		else {
			JOptionPane.showMessageDialog(null, "usuario no encontrado", "Alerta", JOptionPane.WARNING_MESSAGE);
		}
		ventana.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin

	public static void CerrarSesion() {
		System.out.println("Cerrar Session");
		ventana.CambiarVistaPanel(new Login());
	}

	public static VentanaPpl getVentana() {
		return ventana;
	}

	public static Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public static HashMap<String, String> getConfigApp() {
		return configApp;
	}

}
