package controlador;


import javax.swing.JOptionPane;

import vistas.Login;
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
	
		if(UsuariosController.InicioSesion())
			ventana.CambiarVistaPanel(MenuPrincipalController.ShowMenuPrinciapl());
		else 
			JOptionPane.showMessageDialog(null, "Credenciales Invalidas", null,0);
	}


	public static void CerrarSesion(){
		System.out.println("Cerrar Session");
		ventana.CambiarVistaPanel(new Login());
	}

	

}
