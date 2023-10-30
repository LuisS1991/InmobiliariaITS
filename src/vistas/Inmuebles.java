package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import controlador.InmuebleController;
import modelo.Cliente;
import modelo.Inmueble;
import modelo.Habitable;
import modelo.Terreno;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Inmuebles extends JDialog {
	private Inmueble imno = null;
	private ArrayList<Cliente> clientes;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNroPadron;
	private JTextField txtCaller;
	private JTextField txtNroCalle;
	private JTextField txtValor;
	private JTextField txtTamanioInmo;
	private JTextField txtAddServicio;
	private JTextArea taServicios;
	private JPanel panelHabitable;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoInmo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbClientes;
	private JPanel panelTerreno;
	private boolean isTerreno = false;
	@SuppressWarnings("rawtypes")
	private JComboBox cbDepto;
	private JSpinner sCantidadBanios;
	private JSpinner sCantCuartos;
	private JSpinner sOtrasHabit;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoHabitable;
	private JTextArea textAreaComodidades;
	private JButton btnActualizar;
	private JButton btnGuardar;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Inmuebles(VentanaPpl ventana, boolean modal, ArrayList<Cliente> lista, Inmueble imno) {
		super(ventana, modal);
		this.imno = imno;
		this.clientes = lista;

		// CONTROLES INTERFAZ USUARIO
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inmuebles.class.getResource("/imagenes/casaIcon.png")));
		setTitle("Agregar Nuevo Inmueble");
		setBounds(100, 100, 649, 552);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nro Padron:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 30, 74, 33);
			contentPanel.add(lblNewLabel);
		}
		{
			txtNroPadron = new JTextField();
			txtNroPadron.setBounds(83, 30, 170, 33);
			contentPanel.add(txtNroPadron);
			txtNroPadron.setColumns(10);
		}
		{
			JLabel lblDireccin = new JLabel("Calle:");
			lblDireccin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblDireccin.setBounds(10, 85, 74, 33);
			contentPanel.add(lblDireccin);
		}
		{
			txtCaller = new JTextField();
			txtCaller.setColumns(10);
			txtCaller.setBounds(83, 85, 170, 33);
			contentPanel.add(txtCaller);
		}
		{
			txtNroCalle = new JTextField();
			txtNroCalle.setColumns(10);
			txtNroCalle.setBounds(83, 147, 170, 33);
			contentPanel.add(txtNroCalle);
		}
		{
			JLabel lblNro = new JLabel("Nro:");
			lblNro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNro.setBounds(10, 146, 41, 33);
			contentPanel.add(lblNro);
		}
		{
			JLabel lblDepartamento = new JLabel("Departamento:");
			lblDepartamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblDepartamento.setBounds(287, 85, 85, 33);
			contentPanel.add(lblDepartamento);
		}
		{
			cbDepto = new JComboBox();
			cbDepto.setModel(new DefaultComboBoxModel(new String[] { "Artigas", "Canelones", "Cerro Largo", "Colonia",
					"Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro",
					"Rivera", "Rocha", "Salto", "Soriano", "San José", "Tacuarembó ", "Treinta y Tres" }));
			cbDepto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			cbDepto.setBounds(379, 86, 170, 33);
			contentPanel.add(cbDepto);
		}
		{
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblCliente.setBounds(287, 29, 85, 33);
			contentPanel.add(lblCliente);
		}
		{
			cbClientes = new JComboBox();
			cbClientes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			cbClientes.setBounds(379, 30, 170, 33);
			contentPanel.add(cbClientes);
		}
		{
			txtValor = new JTextField();
			txtValor.setColumns(10);
			txtValor.setBounds(379, 148, 170, 33);
			contentPanel.add(txtValor);
		}
		{
			JLabel lblValor = new JLabel("Valor:");
			lblValor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblValor.setBounds(287, 147, 85, 33);
			contentPanel.add(lblValor);
		}
		{
			JLabel lblTanao = new JLabel("Tamaño:");
			lblTanao.setToolTipText("");
			lblTanao.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblTanao.setBounds(10, 209, 74, 33);
			contentPanel.add(lblTanao);
		}
		{
			txtTamanioInmo = new JTextField();
			txtTamanioInmo.setToolTipText("Tamaño del Inmuble en m2");
			txtTamanioInmo.setColumns(10);
			txtTamanioInmo.setBounds(83, 210, 170, 33);
			contentPanel.add(txtTamanioInmo);
		}
		{
			JLabel lblTipoInmuble = new JLabel("Tipo Inmuble:");
			lblTipoInmuble.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblTipoInmuble.setBounds(287, 209, 85, 33);
			contentPanel.add(lblTipoInmuble);
		}
		{
			cbTipoInmo = new JComboBox();
			cbTipoInmo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (cbTipoInmo.getSelectedItem().equals("Habitable")) {
						panelHabitable.setVisible(true);
						panelTerreno.setVisible(false);
						isTerreno = false;
					} else {
						panelHabitable.setVisible(false);
						panelTerreno.setVisible(true);
						isTerreno = true;
					}
				}
			});
			cbTipoInmo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			cbTipoInmo.setModel(new DefaultComboBoxModel(new String[] { "Habitable", "Terreno" }));
			cbTipoInmo.setBounds(379, 210, 170, 33);
			contentPanel.add(cbTipoInmo);
		}
		{
			panelTerreno = new JPanel();
			panelTerreno.setLayout(null);
			panelTerreno.setBackground(new Color(240, 240, 240));
			panelTerreno.setVisible(false);
			{
				panelHabitable = new JPanel();
				panelHabitable.setBackground(new Color(240, 240, 240));
				panelHabitable.setBounds(10, 301, 602, 173);
				contentPanel.add(panelHabitable);
				panelHabitable.setLayout(null);

				JPanel panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "Mejoras", TitledBorder.CENTER, TitledBorder.TOP, null, null));
				panel.setBounds(10, 10, 222, 153);
				panelHabitable.add(panel);
				panel.setLayout(null);
				{
					JLabel lblCantidadBaos = new JLabel("Cantidad Baños:");
					lblCantidadBaos.setBounds(10, 23, 102, 33);
					panel.add(lblCantidadBaos);
					lblCantidadBaos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				}

				JLabel lblCantidadCuartos = new JLabel("Cantidad Cuartos:");
				lblCantidadCuartos.setBounds(10, 66, 103, 33);
				panel.add(lblCantidadCuartos);
				lblCantidadCuartos.setFont(new Font("Times New Roman", Font.PLAIN, 14));

				sCantidadBanios = new JSpinner();
				sCantidadBanios.setBounds(131, 24, 35, 33);
				panel.add(sCantidadBanios);

				sCantCuartos = new JSpinner();
				sCantCuartos.setBounds(131, 67, 35, 33);
				panel.add(sCantCuartos);

				JLabel lblOtrasHabitaciones = new JLabel("Otras habitaciones:");
				lblOtrasHabitaciones.setBounds(10, 109, 115, 33);
				panel.add(lblOtrasHabitaciones);
				lblOtrasHabitaciones.setFont(new Font("Times New Roman", Font.PLAIN, 14));

				sOtrasHabit = new JSpinner();
				sOtrasHabit.setBounds(131, 110, 35, 33);
				panel.add(sOtrasHabit);
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(new TitledBorder(null, "Otras Caracteristicas", TitledBorder.CENTER,
							TitledBorder.TOP, null, null));
					panel_1.setBounds(242, 10, 350, 153);
					panelHabitable.add(panel_1);
					panel_1.setLayout(null);

					cbTipoHabitable = new JComboBox();
					cbTipoHabitable.setModel(new DefaultComboBoxModel(new String[] { "Casa", "Apartamento" }));
					cbTipoHabitable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
					cbTipoHabitable.setBounds(122, 20, 170, 33);
					panel_1.add(cbTipoHabitable);
					{
						JLabel lblTipo = new JLabel("Tipo:");
						lblTipo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
						lblTipo.setBounds(10, 19, 102, 33);
						panel_1.add(lblTipo);
					}
					{
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(111, 77, 181, 64);
						panel_1.add(scrollPane);

						textAreaComodidades = new JTextArea();
						scrollPane.setViewportView(textAreaComodidades);
					}

					JLabel lblComodidades = new JLabel("Comodidades");
					lblComodidades.setFont(new Font("Times New Roman", Font.PLAIN, 14));
					lblComodidades.setBounds(10, 94, 102, 33);
					panel_1.add(lblComodidades);
				}
			}
			panelTerreno.setBounds(10, 338, 602, 136);
			contentPanel.add(panelTerreno);
			{
				JLabel lblNewLabel_1_1 = new JLabel("Agregar  servicio:");
				lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblNewLabel_1_1.setBounds(10, 32, 133, 30);
				panelTerreno.add(lblNewLabel_1_1);
			}
			{
				txtAddServicio = new JTextField();
				txtAddServicio.setColumns(10);
				txtAddServicio.setBounds(10, 62, 170, 33);
				panelTerreno.add(txtAddServicio);
			}
			{
				JButton btnAddServicio = new JButton("ADD");
				btnAddServicio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cargarServicioLista();
					}
				});
				btnAddServicio.setActionCommand("OK");
				btnAddServicio.setBounds(10, 105, 63, 21);
				panelTerreno.add(btnAddServicio);
			}
			{
				JLabel lblNewLabel_1_1 = new JLabel("Servicios Cargados:");
				lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblNewLabel_1_1.setBounds(364, 48, 122, 30);
				panelTerreno.add(lblNewLabel_1_1);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Agregar Servicios al terreno");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				lblNewLabel_1.setBounds(184, 10, 223, 13);
				panelTerreno.add(lblNewLabel_1);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(492, 12, 100, 114);
				panelTerreno.add(scrollPane);
				{
					taServicios = new JTextArea();
					scrollPane.setViewportView(taServicios);
					taServicios.setEditable(false);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 472, 615, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guardarInmo();
					}
				});
				btnGuardar.setBounds(346, 5, 120, 21);
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cerrar();
					}
				});
				cancelButton.setBounds(480, 5, 120, 20);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarInmo();
				}
			});
			btnActualizar.setActionCommand("OK");
			btnActualizar.setBounds(202, 5, 120, 21);
			btnActualizar.setVisible(false);
			buttonPane.add(btnActualizar);
		}
		cargarClientes();
		if (this.imno != null) {
			cargarImno();
		}
	}// ctor
	
	private void guardarInmo() {
		
		InmuebleController.guardarInmo(txtNroPadron.getText(), txtCaller.getText(), txtNroCalle.getText(),
				(String) cbDepto.getSelectedItem(), txtValor.getText(), txtTamanioInmo.getText(),
				obtenerCliente(cbClientes.getSelectedIndex()), (int) sCantidadBanios.getValue(),
				(int) sCantCuartos.getValue(), (int) sOtrasHabit.getValue(), textAreaComodidades.getText(),
				(String) cbTipoHabitable.getSelectedItem(), taServicios.getText(), isTerreno);
		limpiar();
		this.dispose();

	}// fin metodo
	
	private void actualizarInmo() {

		// String nroPadron,String calle,String nroPuerta,String dpto,String
		// valor,String tamanio,String ciCliente,String cantBanio,String
		// cantCuartos,String cantOtosHabi,String tipo,String servicios,boolean
		// isTerreno

		InmuebleController.actualizarDatosInmo(txtNroPadron.getText(), txtCaller.getText(), txtNroCalle.getText(),
				(String) cbDepto.getSelectedItem(), txtValor.getText(), txtTamanioInmo.getText(),
				obtenerCliente(cbClientes.getSelectedIndex()), (int) sCantidadBanios.getValue(),
				(int) sCantCuartos.getValue(), (int) sOtrasHabit.getValue(), textAreaComodidades.getText(),
				(String) cbTipoHabitable.getSelectedItem(), taServicios.getText(), isTerreno);
		limpiar();
		this.dispose();
	}// fin metodo
	
	private void limpiar() {
		txtNroPadron.setText("");
		txtCaller.setText("");
		txtNroCalle.setText("");
		txtValor.setText("");
		txtTamanioInmo.setText("");
		txtAddServicio.setText("");
		taServicios.setText("");
		cbClientes.setSelectedIndex(0);
		textAreaComodidades.setText("");
		cbTipoHabitable.setSelectedIndex(0);
		cbClientes.setSelectedIndex(0);
		sCantidadBanios.setValue(0);
		sOtrasHabit.setValue(0);
		sCantCuartos.setValue(0);
		textAreaComodidades.append("");
	}

	private Cliente obtenerCliente(int index) {
		return this.clientes.get(index);
	}// fin emtodo

	private void cerrar() {
		this.dispose();
	}

	private void cargarServicioLista() {
		if (txtAddServicio.getText().matches("^[a-zA-Z].*")) {
			taServicios.append(txtAddServicio.getText() + "," + "\n");
			txtAddServicio.setText("");
		} else {
			JOptionPane.showInternalMessageDialog(null, "error no puede ingresar numeros");
		}
	}// fin metodo

	@SuppressWarnings("unchecked")
	private void cargarClientes() {
		for (Cliente cliente : clientes) {
			cbClientes.addItem(cliente.getNombreCompleto());
		}
	}// fin metodo

	private void cargarImno() {
		txtNroPadron.setText(String.valueOf(this.imno.getNroPadron()));
		txtNroPadron.setEnabled(isTerreno);
		txtCaller.setText(this.imno.getCalle());
		txtNroCalle.setText(String.valueOf(this.imno.getNroPuerta()));
		txtValor.setText(String.valueOf(this.imno.getValor()));
		txtTamanioInmo.setText(String.valueOf(this.imno.getTamanio()));
		for (Cliente cliente : clientes) {
			if (cliente.getCI() == this.imno.getCliente().getCI()) {
				cbClientes.setSelectedIndex(this.clientes.indexOf(cliente));
			}
		} // fin
		for (int i = 0; i < cbDepto.getModel().getSize(); i++) {
			if (cbDepto.getModel().getElementAt(i).equals(this.imno.getDepartamento())) {
				cbDepto.setSelectedIndex(i);
			}
		} // fin

		if (this.imno.getClass().toString().equals("class modelo.Terreno")) {
			cbTipoInmo.setSelectedIndex(1);
			panelTerreno.setVisible(true);
			panelHabitable.setVisible(false);
			isTerreno = true;
			Terreno terr = (Terreno) this.imno;
			taServicios.append(terr.getServicios());

		} else {
			Habitable hab = (Habitable)this.imno;
			panelTerreno.setVisible(false);
			panelHabitable.setVisible(true);
			isTerreno = false;
			cbTipoInmo.setSelectedIndex(0);
			sCantidadBanios.setValue(hab.getCantidad_Banos());
			sOtrasHabit.setValue(hab.getOtrasHabitaciones());
			sCantCuartos.setValue(hab.getCantidad_Cuartos());
			textAreaComodidades.append(hab.getComodidades());
			if(hab.getTipo().equals("casa")) {
				cbTipoHabitable.setSelectedIndex(0);
			}else {
				cbTipoHabitable.setSelectedIndex(1);
			}
		}
		btnGuardar.setVisible(false);
		btnActualizar.setVisible(true);
		this.repaint();
	}// fin metodo
}// fin clase
