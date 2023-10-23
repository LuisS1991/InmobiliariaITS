package controlador;


import java.util.HashMap;

import javax.swing.JOptionPane;

import modelo.Usuario;
import utiles.CargarConfiguracion;
import vistas.Login;
import vistas.VentanaPpl;

public class Aplicacion {

	
	private static VentanaPpl ventana = null; 
	private static Usuario usuarioActual=null;
	public static HashMap<String, String> configApp;
	
	 
	public Aplicacion() {	
		usuarioActual = new Usuario("Luis Nantes","123",0);
		configApp = CargarConfiguracion.LoadConfigApp();
		ventana = new VentanaPpl();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.CambiarVistaPanel(new Login());		
	}
	
	public static void InicioSesion() {
	
		if(UsuariosController.InicioSesion())
			ventana.CambiarVistaPanel(MenuPrincipalController.ShowMenuPrinciapl());
		else 
			JOptionPane.showMessageDialog(null, "Credenciales Invalidas", null,0);
	}


	public static void CerrarSesion(){
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
