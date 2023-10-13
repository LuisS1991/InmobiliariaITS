package vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


public class Clientes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JTextField txtBuscarCI;
	private JTable table;
	private JDateChooser dataFechaNac;
	private JPanel panelClintes;
	private JPanel panelNuevoCliente;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	public Clientes() {
		setToolTipText("clientes");
		setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 684, 630);
		add(layeredPane);
		
		panelNuevoCliente = new JPanel();
		panelNuevoCliente.setLayout(null);
		panelNuevoCliente.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Ingrear Nuevo Cliente", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelNuevoCliente.setBounds(12, 12, 660, 307);
		layeredPane.add(panelNuevoCliente);
		
		JLabel lblNewLabel = new JLabel("Cedula Identidad:");
		lblNewLabel.setBounds(23, 67, 104, 22);
		panelNuevoCliente.add(lblNewLabel);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setBounds(332, 67, 104, 22);
		panelNuevoCliente.add(lblNombreCompleto);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(23, 108, 104, 33);
		panelNuevoCliente.add(lblFechaNacimiento);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(333, 119, 92, 22);
		panelNuevoCliente.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(23, 172, 104, 22);
		panelNuevoCliente.add(lblTelefono);
		
		JTextField txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(145, 62, 170, 33);
		panelNuevoCliente.add(txtCedula);
		
		JTextField txtNombreCompleto = new JTextField();
		txtNombreCompleto.setColumns(10);
		txtNombreCompleto.setBounds(454, 62, 170, 33);
		panelNuevoCliente.add(txtNombreCompleto);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(454, 108, 170, 33);
		panelNuevoCliente.add(txtEmail);
		
		JTextField txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(145, 167, 170, 33);
		panelNuevoCliente.add(txtTelefono);
		
		dataFechaNac = new JDateChooser();
		dataFechaNac.setDateFormatString("dd-MM-yyyy");
		dataFechaNac.setDate(Date.from(Instant.now()));
		dataFechaNac.setBounds(145, 108, 170, 33);
		
		panelNuevoCliente.add(dataFechaNac);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
			}
		});
		btnNewButton.setBounds(188, 255, 112, 40);
		panelNuevoCliente.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(350, 255, 112, 40);
		panelNuevoCliente.add(btnCancelar);
		
		JComboBox cbTipoCliente = new JComboBox();
		cbTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"Dueño", "Comprador", "Alquiler"}));
		cbTipoCliente.setBounds(454, 167, 170, 33);
		panelNuevoCliente.add(cbTipoCliente);
		
		JLabel lblTipoCliente = new JLabel("Tipo Cliente:");
		lblTipoCliente.setBounds(332, 172, 92, 22);
		panelNuevoCliente.add(lblTipoCliente);
		
		panelClintes = new JPanel();
		panelClintes.setBounds(12, 245, 660, 373);
		//layeredPane.add(panelClintes);
		panelClintes.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 660, 46);
		panelClintes.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por Cedula:");
		lblNewLabel_1.setBounds(12, 0, 120, 46);
		panel_1.add(lblNewLabel_1);
		
		txtBuscarCI = new JTextField();
		txtBuscarCI.setBounds(131, 11, 170, 25);
		panel_1.add(txtBuscarCI);
		txtBuscarCI.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 46, 660, 327);
		panelClintes.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "name_24009803221465");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula", "Nombre Completo", "Fecha Nacimiento", "Email", "Telefono"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}
}

/*PARA TOMAR LA FECHA DEL CALENDAR Y DARLE FORATO
 * 	String formato = dataFechaNac.getDateFormatString();
				Date fecha = dataFechaNac.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				String fnacim = String.valueOf(sdf.format(fecha));
*/
