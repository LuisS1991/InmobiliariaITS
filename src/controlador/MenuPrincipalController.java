package controlador;

import vistas.Clientes;
import vistas.Inmuebles;
import vistas.Contratos;
import vistas.Configuraciones;
import vistas.MenuPrincipal;

public class MenuPrincipalController {
	//instancias de vistas
	private static MenuPrincipal menuPrincipal;
	//se debe instanciar mediante su controlador correspondiente asi realizan sus acciones correspondientes
	private static Clientes clientes;	
	private static Inmuebles inmuebles;
	private static Contratos contratos;	
	private static Configuraciones config;
	
	public static MenuPrincipal ShowMenuPrinciapl() {
		menuPrincipal = new MenuPrincipal();
		return menuPrincipal;
	}
	
	public static void ShowUsuarios() {
		menuPrincipal.CambiarVista(UsuariosController.ShowUsuarios());
	}
	
	
	public static void ShowCliente() {
		clientes = new Clientes();
		menuPrincipal.CambiarVista(clientes);
	}
	
	public static void ShowInmuebles() {
		inmuebles = new Inmuebles();
		menuPrincipal.CambiarVista(inmuebles);
	}
	
	
	public static void ShowContratos() {
		contratos = new Contratos();
		menuPrincipal.CambiarVista(contratos);
	}
	
	public static void ShowConfiguraciones() {
		config = new Configuraciones();
		menuPrincipal.CambiarVista(config);
	}
	
	
	
	
	
	
	
	
	
}
