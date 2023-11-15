package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Cliente;
import repositorio.RepositorioCliente;
import utiles.ValidarEntradas;
import vistas.Clientes;
import vistas.ListarClientes;

public class ClienteController {

	private static RepositorioCliente repoCliente;
	private static Clientes VistaCliente;

	// MANIPULAR BD
	public static void GuardarCliente(String cedula, String nombreCompleto, String email, String telefono,
			String fechaNac, int tipoCliente) {
		repoCliente = new RepositorioCliente();

		if (ValidarEntradas.ValidarEntreadaNumerica(cedula) && cedula.length() == 8
				&& ValidarEntradas.ValidarEntreadaNumerica(telefono)) {
			if (ValidarEntradas.ValidarEntreadaEmail(email)) {
				Cliente cliente = new Cliente();
				cliente.setCI(Integer.parseInt(cedula));
				cliente.setEmail(email);
				cliente.setNombreCompleto(nombreCompleto);
				cliente.setFechaNac(fechaNac);
				cliente.setTelefono(Integer.parseInt(telefono));
				cliente.setTipoCliente(tipoCliente);
				if (repoCliente.GuardarCliente(cliente)) {
					JOptionPane.showMessageDialog(null, "cliente guardado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "el usuario ya existe");
				}
			} else {
				JOptionPane.showMessageDialog(null, "el email no es correcto");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"el numero de cedula no puede ser mayor de 8 digitos y deben ser numeros");
		}

	}// fin metodo

	public static void ActualizarCliente(String cedula, String nombreCompleto, String email, String telefono,
			String fechaNac, int tipoCliente) {
		repoCliente = new RepositorioCliente();

		if (ValidarEntradas.ValidarEntreadaNumerica(cedula) && ValidarEntradas.ValidarEntreadaNumerica(telefono)) {
			if (ValidarEntradas.ValidarEntreadaEmail(email)) {
				Cliente cliente = new Cliente();
				cliente.setCI(Integer.parseInt(cedula));
				cliente.setEmail(email);
				cliente.setNombreCompleto(nombreCompleto);
				cliente.setFechaNac(fechaNac);
				cliente.setTelefono(Integer.parseInt(telefono));
				cliente.setTipoCliente(tipoCliente);
				if (repoCliente.EditarCliente(cliente)) {
					JOptionPane.showMessageDialog(null, "cliente editado correctamente");
					VistaCliente.dispose();
					MenuPrincipalController.VerListadoClientes();
				} else {
					JOptionPane.showMessageDialog(null, "error al editar el cliente");
				}
			} else {
				JOptionPane.showMessageDialog(null, "el email no es correcto");
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"el numero de cedula no puede ser mayor de 8 digitos y deben ser numeros");
		}

	}// fin metodo

	public static void EliminarCliente(int ci) {
		repoCliente = new RepositorioCliente();
		int a = JOptionPane.showConfirmDialog(null, "Estas seguro?");
		if (a == JOptionPane.YES_OPTION) {
			if (repoCliente.EliminarCliente(ci)) {
				JOptionPane.showMessageDialog(null, "cliente eliminado correctamente");
				MenuPrincipalController.VerListadoClientes();
			} else {
				JOptionPane.showMessageDialog(null, "error al eliminar el cliente");
			}
		}
	}// fin metodo

	// VISTAS
	public static void VerAddClienteNuevo() {
		VistaCliente = new Clientes(Aplicacion.getVentana(), true, null);
		VistaCliente.setLocationRelativeTo(null);
		VistaCliente.setVisible(true);
	}

	public static void EditarClienteNuevo(Cliente cli) {
		VistaCliente = new Clientes(Aplicacion.getVentana(), true, cli);
		VistaCliente.setLocationRelativeTo(null);
		VistaCliente.setVisible(true);
	}

	public static JPanel VerClientes() {
		return new ListarClientes(ListarClientes());
	}

	public static ArrayList<Cliente> ListarClientes() {
		repoCliente = new RepositorioCliente();
		return repoCliente.ListarClientes();
	}// fin del metodo

}
