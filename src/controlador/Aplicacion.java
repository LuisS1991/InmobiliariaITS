package controlador;


import vistas.Login;
import vistas.MenuPrincipal;
import vistas.VentanaPpl;

public class Aplicacion {

	
	private static VentanaPpl ventana = null; 

	public Aplicacion() {	
		ventana = new VentanaPpl();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.CambiarVistaPanel(new Login());
		
	}
	
	public static void InicioSesion() {
		System.out.println("Iniciando Sesion");
		ventana.CambiarVistaPanel(new MenuPrincipal());
	}


	public static void CerrarSesion(){
		System.out.println("Cerrar Session");
		ventana.CambiarVistaPanel(new Login());
	}

	

}
