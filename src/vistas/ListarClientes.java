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

@SuppressWarnings("serial")
public class ListarClientes extends JPanel {
	private JTable tableUsuarios;
	private ArrayList<Cliente> clientes;
	private DefaultTableModel modeloTabla;
	private Object[][] dataTabla = null;
	private JButton btnEliminar;
	
	public ListarClientes(ArrayList<Cliente> listado) {
		clientes = listado;
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 655, 473);
		add(scrollPane);
		
		tableUsuarios = new JTable();
		scrollPane.setViewportView(tableUsuarios);
		
		JLabel lblNewLabel = new JLabel("Listado de Clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setBounds(27, 10, 626, 48);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 548, 655, 37);
		add(panel);
		panel.setLayout(null);
			
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
			}
		});
		btnEliminar.setBounds(460, 7, 155, 25);
		if(Aplicacion.getUsuarioActual().getRol() == 0 || Aplicacion.getUsuarioActual().getRol() == 1) {
			panel.add(btnEliminar);
		}
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		btnEditar.setBounds(44, 9, 155, 25);
		panel.add(btnEditar);
		CargarTable();
	}
		
	private void CargarTable(){
		String[] columnas = {"Indice", "Cedula", "Nombre Completo", "Fecha Nacimiento", "Telefono", "E-mail", "Tipo"};
		dataTabla = new Object[clientes.size()][columnas.length];
		
		int i =0;
		for (Cliente cli : clientes) {
			String[] arrData = { String.valueOf(i + 1),String.valueOf(cli.getCI()),cli.getNombreCompleto(),
					String.valueOf(cli.getFechaNac()),String.valueOf(cli.getTelefono()),cli.getEmail(),
					String.valueOf(cli.toStringTipoCliente(cli.getTipoCliente()))};
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
		
	}

	private void editarCliente() {
		int ci = Integer.parseInt((String) tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(), 1));
		for (Cliente cliente : clientes) {
			 if(ci == cliente.getCI()){
				 ClienteController.EditarClienteNuevo(cliente);
			 }
		}
	}//fin metodo

	private void eliminarCliente() {
		int ci = Integer.parseInt((String) tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(), 1));
		ClienteController.EliminarCliente(ci);
	}

}
