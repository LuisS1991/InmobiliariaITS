package vistas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import controlador.Aplicacion;
import controlador.ClienteController;
import modelo.Cliente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ListarClientes extends JPanel {
	private JTable tableUsuarios;
	private ArrayList<Cliente> clientes;
	private DefaultTableModel modeloTabla;
	private Object[][] dataTabla = null;
	private JButton btnEliminar;
	private JButton btnEditar;
	
	public ListarClientes(ArrayList<Cliente> listado) {
		clientes = listado;
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		JPanel panelSinDatos = new JPanel();
		panelSinDatos.setBounds(0, 53, 817, 492);
		add(panelSinDatos);
		panelSinDatos.setLayout(null);
		panelSinDatos.setVisible(false);
		if(this.clientes.size() <=0) {
			panelSinDatos.setVisible(true);
		}
		JLabel lblNewLabel_1 = new JLabel("No hay Datos Cargados al Momento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 21, 797, 44);
		panelSinDatos.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 801, 415);
		add(scrollPane);

		tableUsuarios = new JTable();
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEliminar.setEnabled(true);
				btnEditar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tableUsuarios);

		JLabel lblNewLabel = new JLabel("Listado de Clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setBounds(10, 10, 801, 48);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 500, 655, 37);
		add(panel);
		panel.setLayout(null);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
			}
		});
		btnEliminar.setBounds(460, 7, 155, 25);
		if (Aplicacion.getUsuarioActual().getRol() == 0 || Aplicacion.getUsuarioActual().getRol() == 1) {
			panel.add(btnEliminar);
		}

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		btnEditar.setBounds(44, 9, 155, 25);
		btnEditar.setEnabled(false);
		panel.add(btnEditar);
		CargarTable();
	}

	private void CargarTable() {
		String[] columnas = { "Indice", "Cedula", "Nombre Completo", "Fecha Nacimiento", "Telefono", "E-mail", "Tipo" };
		dataTabla = new Object[clientes.size()][columnas.length];

		int i = 0;
		for (Cliente cli : clientes) {
			String[] arrData = { String.valueOf(i + 1), String.valueOf(cli.getCI()), cli.getNombreCompleto(),
					String.valueOf(cli.getFechaNac()), String.valueOf(cli.getTelefono()), cli.getEmail(),
					String.valueOf(cli.toStringTipoCliente(cli.getTipoCliente())) };
			dataTabla[i] = arrData;
			i++;
		}
		modeloTabla = new DefaultTableModel(dataTabla, columnas) {
			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}

		};
		tableUsuarios.setModel(modeloTabla);

	}// fin metodo

	private void editarCliente() {
		int ci = Integer.parseInt((String) tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(), 1));
		for (Cliente cliente : clientes) {
			if (ci == cliente.getCI()) {
				ClienteController.EditarClienteNuevo(cliente);
				return;
			}
		}
	}// fin metodo

	private void eliminarCliente() {
		int ci = Integer.parseInt((String) tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(), 1));
		ClienteController.EliminarCliente(ci);
	}

}
