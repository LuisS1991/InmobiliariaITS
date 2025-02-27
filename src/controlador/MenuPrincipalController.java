package controlador;

import java.awt.Cursor;

import vistas.MenuPrincipal;

public class MenuPrincipalController {

	private static MenuPrincipal menuPrincipal;

	// VENTANA MENU PRINCIPAL
	public static MenuPrincipal ShowMenuPrinciapl() {
		menuPrincipal = new MenuPrincipal();
		return menuPrincipal;
	}

	// USUARIO
	public static void VerUsuarios() {
		menuPrincipal.CambiarVista(UsuariosController.ShowUsuarios());
	}

	// CLIENTES
	public static void VerListadoClientes() {
		menuPrincipal.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		menuPrincipal.CambiarVista(ClienteController.VerClientes());
		menuPrincipal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public static void VerAddClienteNuevo() {
		ClienteController.VerAddClienteNuevo();
	}

	// INMUBLES
	public static void VerNuevoInmuble() {
		InmuebleController.VerNuevoInmuble();
	}

	public static void ListarInmo() {
		menuPrincipal.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		menuPrincipal.CambiarVista(InmuebleController.TodosInmo());
		menuPrincipal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	// CONTRATO
	public static void ListarContrato() {
		menuPrincipal.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		menuPrincipal.CambiarVista(ContratoController.VerContratos());
		menuPrincipal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin
}
