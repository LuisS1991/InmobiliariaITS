package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.Cliente;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Inmuebles extends JDialog {
	private ArrayList<Cliente> clientes;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNroPadron;
	private JTextField txtCaller;
	private JTextField txtNroCalle;
	private JTextField txtValor;
	private JTextField txtTamanioInmo;
	private JPanel panelHabitable;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoInmo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbClientes;
	private JPanel panelTerreno;
	private JTextField txtAddServicio;
	private JTextArea taServicios;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Inmuebles(VentanaPpl ventana, boolean modal, ArrayList<Cliente> lista) {
		super(ventana, modal);
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
			lblNewLabel.setBounds(10, 78, 74, 33);
			contentPanel.add(lblNewLabel);
		}
		{
			txtNroPadron = new JTextField();
			txtNroPadron.setBounds(83, 78, 170, 33);
			contentPanel.add(txtNroPadron);
			txtNroPadron.setColumns(10);
		}
		{
			JLabel lblDireccin = new JLabel("Calle:");
			lblDireccin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblDireccin.setBounds(10, 133, 74, 33);
			contentPanel.add(lblDireccin);
		}
		{
			txtCaller = new JTextField();
			txtCaller.setColumns(10);
			txtCaller.setBounds(83, 133, 170, 33);
			contentPanel.add(txtCaller);
		}
		{
			txtNroCalle = new JTextField();
			txtNroCalle.setColumns(10);
			txtNroCalle.setBounds(83, 195, 170, 33);
			contentPanel.add(txtNroCalle);
		}
		{
			JLabel lblNro = new JLabel("Nro:");
			lblNro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNro.setBounds(10, 194, 41, 33);
			contentPanel.add(lblNro);
		}
		{
			JLabel lblDepartamento = new JLabel("Departamento:");
			lblDepartamento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblDepartamento.setBounds(287, 133, 85, 33);
			contentPanel.add(lblDepartamento);
		}
		{
			JComboBox cbDepto = new JComboBox();
			cbDepto.setModel(new DefaultComboBoxModel(new String[] { "Artigas", "Canelones", "Cerro Largo", "Colonia",
					"Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro",
					"Rivera", "Rocha", "Salto", "Soriano", "San José", "Tacuarembó ", "Treinta y Tres" }));
			cbDepto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			cbDepto.setBounds(379, 134, 170, 33);
			contentPanel.add(cbDepto);
		}
		{
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblCliente.setBounds(287, 77, 85, 33);
			contentPanel.add(lblCliente);
		}
		{
			cbClientes = new JComboBox();
			cbClientes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			cbClientes.setBounds(379, 78, 170, 33);
			contentPanel.add(cbClientes);
		}
		{
			txtValor = new JTextField();
			txtValor.setColumns(10);
			txtValor.setBounds(379, 196, 170, 33);
			contentPanel.add(txtValor);
		}
		{
			JLabel lblValor = new JLabel("Valor:");
			lblValor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblValor.setBounds(287, 195, 85, 33);
			contentPanel.add(lblValor);
		}
		{
			JLabel lblTanao = new JLabel("Tamaño:");
			lblTanao.setToolTipText("");
			lblTanao.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblTanao.setBounds(10, 257, 74, 33);
			contentPanel.add(lblTanao);
		}
		{
			txtTamanioInmo = new JTextField();
			txtTamanioInmo.setToolTipText("Tamaño del Inmuble en m2");
			txtTamanioInmo.setColumns(10);
			txtTamanioInmo.setBounds(83, 258, 170, 33);
			contentPanel.add(txtTamanioInmo);
		}
		{
			JLabel lblTipoInmuble = new JLabel("Tipo Inmuble:");
			lblTipoInmuble.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblTipoInmuble.setBounds(287, 257, 85, 33);
			contentPanel.add(lblTipoInmuble);
		}
		{
			cbTipoInmo = new JComboBox();
			cbTipoInmo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (cbTipoInmo.getSelectedItem().equals("Habitable")) {
						panelHabitable.setVisible(true);
						panelTerreno.setVisible(false);
					} else {
						panelHabitable.setVisible(false);
						panelTerreno.setVisible(true);
					}
				}
			});
			cbTipoInmo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			cbTipoInmo.setModel(new DefaultComboBoxModel(new String[] { "Habitable", "Terreno" }));
			cbTipoInmo.setBounds(379, 258, 170, 33);
			contentPanel.add(cbTipoInmo);
		}
		{
			panelTerreno = new JPanel();
			panelTerreno.setLayout(null);
			panelTerreno.setBackground(new Color(240, 240, 240));
			panelTerreno.setVisible(false);
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
				taServicios = new JTextArea();
				taServicios.setBounds(492, 12, 100, 114);
				panelTerreno.add(taServicios);
			}
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
				
				JSpinner spinner = new JSpinner();
				spinner.setBounds(131, 24, 35, 33);
				panel.add(spinner);
				
				JSpinner spinner_2 = new JSpinner();
				spinner_2.setBounds(131, 67, 35, 33);
				panel.add(spinner_2);
				
				JLabel lblOtrasHabitaciones = new JLabel("Otras habitaciones:");
				lblOtrasHabitaciones.setBounds(10, 109, 115, 33);
				panel.add(lblOtrasHabitaciones);
				lblOtrasHabitaciones.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				
				JSpinner spinner_1 = new JSpinner();
				spinner_1.setBounds(131, 110, 35, 33);
				panel.add(spinner_1);
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(new TitledBorder(null, "Otras Caracteristicas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
					panel_1.setBounds(242, 10, 350, 153);
					panelHabitable.add(panel_1);
					panel_1.setLayout(null);
					
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Casa", "Apartamento"}));
					comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
					comboBox.setBounds(122, 20, 170, 33);
					panel_1.add(comboBox);
					{
						JLabel lblTipo = new JLabel("Tipo:");
						lblTipo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
						lblTipo.setBounds(10, 19, 102, 33);
						panel_1.add(lblTipo);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 472, 615, 33);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Guardar");
				okButton.setBounds(346, 5, 120, 21);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
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
		}
		cargarClientes();
	}// ctor
	
	private void cerrar() {
		this.dispose();
	}
	
	private void cargarServicioLista() {
		if(txtAddServicio.getText().matches("^[a-zA-Z].*")){
			taServicios.append(txtAddServicio.getText()+"\n");
			txtAddServicio.setText("");
		}else {
			JOptionPane.showInternalMessageDialog(null,"error no puede ingresar numeros");
		}
	}//fin metodo



	@SuppressWarnings("unchecked")
	private void cargarClientes() {
		for (Cliente cliente : clientes) {
			cbClientes.addItem(cliente.getNombreCompleto());
		}
	}// fin metodo
}// fin clase
