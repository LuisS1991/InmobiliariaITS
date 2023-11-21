package controlador;

import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Habitable;
import modelo.Terreno;
import modelo.Inmueble;
import repositorio.RepositorioInmo;
import utiles.ValidarEntradas;
import vistas.Inmuebles;
import vistas.ListarInmo;

public class InmuebleController {

	private static RepositorioInmo repoInmo;

	// VISTAS
	public static void VerNuevoInmuble() {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Inmuebles inmo = new Inmuebles(Aplicacion.getVentana(), true, null);
		inmo.setLocationRelativeTo(null);
		inmo.setVisible(true);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin metodo

	public static JPanel TodosInmo() {
		repoInmo = new RepositorioInmo();
		return new ListarInmo(repoInmo.TodosTerrenos(), repoInmo.TodosHabitables());
	}// fin del metodo

	public static void EditarInmueble(Inmueble inmo) {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		Inmuebles vistaInmo = new Inmuebles(Aplicacion.getVentana(), true, inmo);
		vistaInmo.setLocationRelativeTo(null);
		vistaInmo.setTitle("Editar Inmueble");
		vistaInmo.setVisible(true);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	// MANIPULAR BASE DATOS
	public static void guardarInmo(String nroPadron, String calle, String nroPuerta, String dpto, String valor,
			String tamanio, Cliente Duenio, int canBanios, int cantCuartos, int cantOtosHabi, String comodidades,
			String tipo, String servicios, boolean isTerreno) {
	
		repoInmo = new RepositorioInmo();
		if (ValidarEntradas.ValidarEntreadaNumerica(nroPadron) && ValidarEntradas.ValidarEntreadaNumerica(nroPuerta)
				&& ValidarEntradas.ValidarEntreadaNumerica(valor) && ValidarEntradas.ValidarEntreadaNumerica(tamanio)) {
			if (isTerreno) {
				Terreno terreno = new Terreno(Integer.parseInt(nroPadron), calle, Integer.parseInt(nroPuerta),
						String.valueOf(dpto), Float.parseFloat(valor), Double.parseDouble(tamanio),
						servicios.replaceAll("(\n)", ""), Duenio);

				if (repoInmo.GuardarTerreno(terreno)) {
					JOptionPane.showInternalMessageDialog(null, "terreno guardado con exito");
				} else {
					JOptionPane.showInternalMessageDialog(null, "error al guardar un terreno");
				}
			} else {
				Habitable hab = new Habitable(Integer.parseInt(nroPadron), calle, Integer.parseInt(nroPuerta),
						String.valueOf(dpto), Float.parseFloat(valor), Double.parseDouble(tamanio), Duenio,
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
		MenuPrincipalController.ListarInmo();
	}// fin metodo

	public static void actualizarDatosInmo(String nroPadron, String calle, String nroPuerta, String dpto, String valor,
			String tamanio, Cliente Duenio, int canBanios, int cantCuartos, int cantOtosHabi, String comodidades,
			String tipo, String servicios, boolean isTerreno) {
	
		repoInmo = new RepositorioInmo();
		if (ValidarEntradas.ValidarEntreadaNumerica(nroPadron) && ValidarEntradas.ValidarEntreadaNumerica(nroPuerta)
				&& ValidarEntradas.ValidarEntreadaNumerica(valor) && ValidarEntradas.ValidarEntreadaNumerica(tamanio)) {
			if (isTerreno) {
				Terreno terreno = new Terreno(Integer.parseInt(nroPadron), calle, Integer.parseInt(nroPuerta),
						String.valueOf(dpto), Float.parseFloat(valor), Double.parseDouble(tamanio),
						servicios.replaceAll("(\n)", ""), Duenio);
				if (repoInmo.EditarInmueble(terreno)) {
					JOptionPane.showInternalMessageDialog(null, "terreno guardado con exito");
				} else {
					JOptionPane.showInternalMessageDialog(null, "error al guardar un terreno");
				}
			} else {
				Habitable hab = new Habitable(Integer.parseInt(nroPadron), calle, Integer.parseInt(nroPuerta),
						String.valueOf(dpto),Float.parseFloat(valor), Double.parseDouble(tamanio), Duenio,
						String.valueOf(tipo), cantCuartos, canBanios, cantOtosHabi, comodidades);
				if (repoInmo.EditarInmueble(hab)) {
					JOptionPane.showInternalMessageDialog(null, "inmuble habitable guardado con exito");
				} else {
					JOptionPane.showInternalMessageDialog(null, "error al guardar un inmuble habitable");
				}
			}
		} else {
			JOptionPane.showInternalMessageDialog(null, "no puede ir letras en las entradas numericas");
		}

		MenuPrincipalController.ListarInmo();
	}// fin

	public static void eliminarInmo(int nroPadron) {
		int a = JOptionPane.showConfirmDialog(null, "Estas seguro?");
		if (a == JOptionPane.YES_OPTION) {
			Contrato cont = ContratoController
					.BuscarContratoCliente("SELECT * FROM contrato WHERE nroPadron=" + nroPadron + ";");

			if (cont != null && cont.getNroPadron() == nroPadron) {
				JOptionPane.showInternalMessageDialog(null, "no se puede eliminar un inmueble que esta en un contrato",
						"alerta", 0, null);
			} else {
				repoInmo = new RepositorioInmo();
				if (repoInmo.ElimnarInmo(nroPadron)) {
					JOptionPane.showInternalMessageDialog(null, "Inmueble eliminado correctamente");
				} else {
					JOptionPane.showInternalMessageDialog(null, "error al eliminar un inmuble habitable");
				}
			}
		} else {
			return;
		}
		MenuPrincipalController.ListarInmo();
	}// fn

	public static Inmueble BuscarInmo(String nroPadron) {

		if (nroPadron.isEmpty()) {
			JOptionPane.showInternalMessageDialog(null, "el numero de padron no puede ser vacio");
		} else {
			if (ValidarEntradas.ValidarEntreadaNumerica(nroPadron)) {
				repoInmo = new RepositorioInmo();
				Inmueble inmo = repoInmo.Buscar(nroPadron);
				return inmo;
			} else {
				JOptionPane.showMessageDialog(null, "debe ingresar un nro padron  valido", "alerta", 0, null);
			}
		}
		return null;
	}
}// clase
