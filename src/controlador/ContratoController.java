package controlador;

import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import repositorio.RepositorioContrato;
import vistas.FormContrato;
import vistas.ListarContratos;
import utiles.ValidarEntradas;
import modelo.Cliente;
import modelo.Contrato;

public class ContratoController {

	private static RepositorioContrato repoContrato;

	// VISTAS
	public static void FormAltaContrato() {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		FormContrato form = new FormContrato(Aplicacion.getVentana(), true, null);
		form.setLocationRelativeTo(null);
		form.setVisible(true);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin

	public static JPanel VerContratos() {
		return new ListarContratos(ListarContratos());
	}

	public static void FormActualizarContrato(Contrato c) {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		FormContrato form = new FormContrato(Aplicacion.getVentana(), true, c);
		form.setLocationRelativeTo(null);
		form.setVisible(true);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	// ACCIONES
	public static ArrayList<Contrato> ListarContratos() {
		repoContrato = new RepositorioContrato();
		return repoContrato.Listar();
	}// fin

	public static void AutorizarContrato(int nroContrato) {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		repoContrato = new RepositorioContrato();
		repoContrato.AutorizarContrato(nroContrato);
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	public static void EliminarContrato(int nroContato) {
		int a = JOptionPane.showConfirmDialog(null, "Estas seguro?");
		if (a == JOptionPane.YES_OPTION) {
			if (nroContato != 0) {
				repoContrato = new RepositorioContrato();
				if (repoContrato.Eliminar(nroContato) > 0) {
					JOptionPane.showMessageDialog(null, "contrato eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "El contrato no puede estar autorizado para su eliminacion");
				}

			} else {
				JOptionPane.showMessageDialog(null, "el numero de contrato no puede vacio", "Error", 0, null);
			}
		} else {
			return;
		}

		MenuPrincipalController.ListarContrato();
	}// fin

	public static void ActualizarContrato(Date fechaInicio, Date fechaFin, String NroContrato, Cliente cliente,
			int tipoContrato, String precio, String garantia, String desc,String nroPadron) {
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.WAIT_CURSOR));
		repoContrato = new RepositorioContrato();

		if (ValidarEntradas.ValidarEntreadaNumerica(NroContrato) && !ValidarEntradas.ValidarEsVacio(NroContrato)) {
			if (ValidarEntradas.ValidarEntreadaNumerica(precio) && !ValidarEntradas.ValidarEsVacio(precio)) {
				String formato = "yyyy-MM-dd";
				Date fecha = fechaFin;
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				Contrato contrato = new Contrato();
				contrato.setNroContrato(Integer.parseInt(NroContrato));
				contrato.setTipo(tipoContrato);
				contrato.setFechaFin(String.valueOf(sdf.format(fecha)));
				fecha = fechaInicio;
				contrato.setFechaInicio(String.valueOf(sdf.format(fecha)));
				contrato.setPrecio(Double.parseDouble(precio));
				contrato.setDescripcion(desc);
				contrato.setGarantia(garantia);
				contrato.setClienteComplementario(cliente);
				contrato.setNroPadron(Integer.parseInt(nroPadron));
				repoContrato.Editar(contrato);
				JOptionPane.showMessageDialog(null, "contrato actualizado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "el precio debe ser numerico y no estar vacio", "Error", 0, null);
			}
		} else {
			JOptionPane.showMessageDialog(null, "el numero de contrato debe ser numerico y no estar vacio", "Error", 0,
					null);
		}
		Aplicacion.getVentana().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		MenuPrincipalController.ListarContrato();
	}// fin

	public static void AltaContratos(Date fechaInicio, Date fechaFin, String NroContrato, Cliente cliente,
			int tipoContrato, String precio, String garantia, String desc,String nroPadron) {
		repoContrato = new RepositorioContrato();
		if (ValidarEntradas.ValidarEntreadaNumerica(NroContrato) && !ValidarEntradas.ValidarEsVacio(NroContrato)) {
			if (ValidarEntradas.ValidarEntreadaNumerica(precio) && !ValidarEntradas.ValidarEsVacio(precio) ) {
				String formato = "yyyy-MM-dd";
				Date fecha = fechaFin;
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				Contrato contrato = new Contrato();
				contrato.setNroContrato(Integer.parseInt(NroContrato));
				contrato.setTipo(tipoContrato);
				contrato.setFechaFin(String.valueOf(sdf.format(fecha)));
				fecha = fechaInicio;
				contrato.setFechaInicio(String.valueOf(sdf.format(fecha)));
				contrato.setPrecio(Double.parseDouble(precio));
				contrato.setDescripcion(desc);
				contrato.setGarantia(garantia);
				contrato.setClienteComplementario(cliente);
				contrato.setNroPadron(Integer.parseInt(nroPadron));
				repoContrato.Guardar(contrato);
				JOptionPane.showMessageDialog(null, "cliente guardado correctamente");
			} else {
				JOptionPane.showMessageDialog(null, "el precio debe ser numerico y no estar vacio", "Error", 0, null);
			}
		} else {
			JOptionPane.showMessageDialog(null, "el numero de contrato debe ser numerico y no estar vacio", "Error", 0,
					null);
		}
		MenuPrincipalController.ListarContrato();
	}//fin

	public static Contrato BuscarContratoCliente(String query) {
		repoContrato = new RepositorioContrato();
		return repoContrato.BuscarContratoClienteInmo(query);
	}// fin

}// fin
