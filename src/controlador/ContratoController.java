package controlador;

import java.awt.Cursor;

import conexion.ManipularBd;
import repositorio.RepositorioContrato;
import vistas.FormContrato;



public class ContratoController {
	private static RepositorioContrato c;
   
	
	
	public static void FormAltaContrato() {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		FormContrato form = new FormContrato(Aplicacion.getVentana(),true);
		form.setLocationRelativeTo(null);
		form.setVisible(true);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	public static void ListarContratos() {
		 System.out.println("listar");
	}

	public static void AltaContratos() {
		System.out.println("alta");
	}

	
	public static void EliminarContrato() {
		System.out.println("eliminar");
	}
	
	public static void ActualizarContrato() {
		System.out.println("actualizar");
	}
}//fin 
