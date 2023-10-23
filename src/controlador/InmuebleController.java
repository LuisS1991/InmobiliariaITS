package controlador;

import java.awt.Cursor;

import vistas.Inmuebles;
public class InmuebleController {

	//VISTAS
	public static void VerNuevoInmuble() {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Inmuebles inmo = new Inmuebles(Aplicacion.getVentana(),true,ClienteController.ListarClientes());
		inmo.setLocationRelativeTo(null);
		inmo.setVisible(true);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}//fin metodo
	
	
}
