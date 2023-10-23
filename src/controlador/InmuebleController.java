package controlador;

import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Cliente;
import modelo.Habitable;
import modelo.Terreno;
import repositorio.RepositorioInmo;
import utiles.ValidarEntradas;
import vistas.Inmuebles;
import vistas.ListarInmo;

public class InmuebleController {

	private static RepositorioInmo repoInmo;

	// VISTAS
	public static void VerNuevoInmuble() {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Inmuebles inmo = new Inmuebles(Aplicacion.getVentana(), true, ClienteController.ListarClientes());
		inmo.setLocationRelativeTo(null);
		inmo.setVisible(true);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin metodo

	public static JPanel TodosInmo() {
		repoInmo = new RepositorioInmo();
		return new ListarInmo(repoInmo.TodosTerrenos(),repoInmo.TodosHabitables());
	}//fin del metodo
	
	// MANIPULAR BASE DATOS
	public static void guardarInmo(String nroPadron, String calle, String nroPuerta, String dpto, String valor,
			String tamanio, Cliente cli, int canBanios, int cantCuartos, int cantOtosHabi, String comodidades,
			String tipo, String servicios, boolean isTerreno) {
		
		repoInmo = new RepositorioInmo();
		if (ValidarEntradas.ValidarEntreadaNumerica(nroPadron) && ValidarEntradas.ValidarEntreadaNumerica(nroPuerta)
				&& ValidarEntradas.ValidarEntreadaNumerica(valor) && ValidarEntradas.ValidarEntreadaNumerica(tamanio)) {
			if (isTerreno) {
				Terreno terreno = new Terreno(Integer.parseInt(nroPadron), calle, Integer.parseInt(nroPuerta),
						String.valueOf(dpto), Integer.parseInt(valor), Integer.parseInt(tamanio),servicios.replaceAll("(\n)", ""), cli);
				if (repoInmo.GuardarTerreno(terreno)) {
					JOptionPane.showInternalMessageDialog(null, "terreno guardado con exito");
				} else {
					JOptionPane.showInternalMessageDialog(null, "error al guardar un terreno");
				}
			} else {
				Habitable hab = new Habitable(Integer.parseInt(nroPadron), calle, Integer.parseInt(nroPuerta),
						String.valueOf(dpto), Integer.parseInt(valor), Integer.parseInt(tamanio), cli,
						String.valueOf(tipo), cantCuartos, canBanios, cantOtosHabi, comodidades);
				if (repoInmo.GuardarHabitable(hab)) {
					JOptionPane.showInternalMessageDialog(null, "inmuble habitable guardado con exito");
				} else {
					JOptionPane.showInternalMessageDialog(null, "error al guardar un inmuble habitable");
				}
			}
		} else {
			JOptionPane.showInternalMessageDialog(null, "no puede ir letras en las entradas numericas");
		}

	}// fin metodo
	
	
/*
 * 	repoInmo = new RepositorioInmo();
		ArrayList<Terreno> listTerrenos = repoInmo.TodosTerrenos();
		ArrayList<Habitable> listHab = repoInmo.TodosHabitables();
		ArrayList<Inmueble> todos = new ArrayList<Inmueble>(listTerrenos);
		todos.addAll(listHab);
		System.out.println(todos.get(0).getDepartamento());
	
 * */
}
