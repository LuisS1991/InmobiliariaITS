package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Inmueble;
import controlador.Aplicacion;
import controlador.InmuebleController;
import modelo.Habitable;
import modelo.Terreno;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public class ListarInmo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableTerrenos;
	private JTable tableHabitables;
	private JPanel panelHabitables;
	private JPanel panelTerrenos;
	private JPanel panel;
	private ArrayList<Terreno> listadoTerrenos;
	private ArrayList<Habitable> listadoHabitable;
	private DefaultTableModel modeloTabla;
	private Object[][] dataTabla = null;
	private JToggleButton tglbtnNewToggleButton;
	private boolean isTerreno = false;
	private JPanel panelSinDatos;
	private JLabel lblNewLabel_2;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblTitulo;

	public ListarInmo(ArrayList<Terreno> listTerrenos, ArrayList<Habitable> listHabitable) {
		listadoTerrenos = listTerrenos;
		listadoHabitable = listHabitable;
		// GUI
		setLayout(null);

		panelSinDatos = new JPanel();
		panelSinDatos.setBounds(0, 137, 942, 399);
		add(panelSinDatos);
		panelSinDatos.setVisible(false);
		panelSinDatos.setLayout(null);
		if (listadoHabitable.size() <= 0 || listadoHabitable.size() <= 0) {
			panelSinDatos.setVisible(true);
		}
		lblNewLabel_2 = new JLabel("No hay Datos Cargados al Momento");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 26, 901, 80);
		panelSinDatos.add(lblNewLabel_2);
		lblTitulo = new JLabel("Listado Inmuebles");
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(12, 12, 906, 36);
		add(lblTitulo);

		panelTerrenos = new JPanel();
		panelTerrenos.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTerrenos.setLayout(null);
		panelTerrenos.setBounds(0, 150, 920, 320);
		panelTerrenos.setVisible(false);
		add(panelTerrenos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 12, 910, 296);
		panelTerrenos.add(scrollPane);

		tableTerrenos = new JTable();
		tableTerrenos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnActualizar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tableTerrenos);

		panelHabitables = new JPanel();
		panelHabitables.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelHabitables.setBounds(0, 150, 920, 320);
		add(panelHabitables);
		panelHabitables.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 12, 918, 296);
		panelHabitables.add(scrollPane_1);

		tableHabitables = new JTable();
		tableHabitables.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnActualizar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		scrollPane_1.setViewportView(tableHabitables);

		panel = new JPanel();
		panel.setBounds(12, 77, 920, 58);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tipo de Inmuble:");
		lblNewLabel_1.setBounds(12, 20, 114, 17);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		tglbtnNewToggleButton = new JToggleButton("Habitables");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActualizar.setEnabled(false);
				btnEliminar.setEnabled(false);
				if (tglbtnNewToggleButton.isSelected()) {
					lblTitulo.setText("Listado Inmuebles Terrenos");
					if (listadoTerrenos.size() <= 0) {
						panelSinDatos.setVisible(true);
						
						repaint();
					} else {
						panelSinDatos.setVisible(false);
						repaint();
						tglbtnNewToggleButton.setText("Terrenos");
						panelHabitables.setVisible(false);
						panelTerrenos.setVisible(true);
						isTerreno = true;
					}
				} else {
					lblTitulo.setText("Listado Inmuebles Habitables");
					if (listadoHabitable.size() <= 0) {
						panelSinDatos.setVisible(true);
						repaint();
					} else {
						panelSinDatos.setVisible(false);
						repaint();
						tglbtnNewToggleButton.setText("Habitable");
						panelHabitables.setVisible(true);
						panelTerrenos.setVisible(false);
						isTerreno = false;
					}
				} // fin else

			}
		});
		tglbtnNewToggleButton.setBounds(147, 13, 170, 33);
		panel.add(tglbtnNewToggleButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 473, 918, 53);
		add(panel_1);
		panel_1.setLayout(null);

		btnActualizar = new JButton("Actualizar Inmueble");
		btnActualizar.setEnabled(false);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarInmueble();
			}
		});
		btnActualizar.setBounds(10, 10, 170, 33);
		panel_1.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarInmueble();
			}
		});
		btnEliminar.setBounds(221, 10, 170, 33);

		if (Aplicacion.getUsuarioActual().getRol() == 0 || Aplicacion.getUsuarioActual().getRol() == 1) {
			panel_1.add(btnEliminar);
		}
		cargarHabitables();
		cargarTerrenos();
	}// CTOR

	private void eliminarInmueble() {
		int nroPadron = 0;
		if (isTerreno) {
			nroPadron = Integer.parseInt((String) tableTerrenos.getValueAt(tableTerrenos.getSelectedRow(), 1));
		} else {
			nroPadron = Integer.parseInt((String) tableHabitables.getValueAt(tableHabitables.getSelectedRow(), 1));
		}
		InmuebleController.eliminarInmo(nroPadron);
	}// fin metodo

	private void actualizarInmueble() {
		int nroPadron = 0;

		if (isTerreno) {
			nroPadron = Integer.parseInt((String) tableTerrenos.getValueAt(tableTerrenos.getSelectedRow(), 1));
			InmuebleController.EditarInmueble(obtenerInmueble(nroPadron));
		} else {
			nroPadron = Integer.parseInt((String) tableHabitables.getValueAt(tableHabitables.getSelectedRow(), 1));
			InmuebleController.EditarInmueble(obtenerInmueble(nroPadron));
		}

	}// fin metodo

	private Inmueble obtenerInmueble(int nroPadron) {
		Inmueble imno = null;
		if (isTerreno) {
			nroPadron = Integer.parseInt((String) tableTerrenos.getValueAt(tableTerrenos.getSelectedRow(), 1));
			for (Terreno terr : listadoTerrenos) {
				if (terr.getNroPadron() == nroPadron) {
					imno = terr;
					break;
				}
			}
		} else {
			nroPadron = Integer.parseInt((String) tableHabitables.getValueAt(tableHabitables.getSelectedRow(), 1));
			for (Habitable hab : listadoHabitable) {
				if (hab.getNroPadron() == nroPadron) {
					imno = hab;
					break;
				}
			}
		}
		return imno;
	}// fin metodo

	@SuppressWarnings("serial")
	private void cargarTerrenos() {
		// String[] columnas = new String[] { "indice", "Padron", "Calle", "Nro
		// Puerta","Dpto", "Valor US$", "Tamaño", "Baños", "Cuartos", "Otros",
		// "Comodidades"};
		String[] columnas = new String[] { "indice", "Padron", "Calle", "Nro Puerta", "Departamento", "Valor US$",
				"Tamaño m2", "Servicios" };
		dataTabla = new Object[listadoTerrenos.size()][columnas.length];
		int i = 0;
		for (Terreno item : this.listadoTerrenos) {
			String[] arrData = { String.valueOf(i + 1), String.valueOf(item.getNroPadron()), item.getCalle(),
					String.valueOf(item.getNroPuerta()), item.getDepartamento(),
					String.valueOf("US$" + item.getValor()), String.valueOf(item.getTamanio() + "m2"),
					item.getServicios(), };

			dataTabla[i] = arrData;
			i++;
		}
		modeloTabla = new DefaultTableModel(dataTabla, columnas) {
			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tableTerrenos.setModel(modeloTabla);
	}// fin metodo

	@SuppressWarnings("serial")
	private void cargarHabitables() {
		String[] columnas = new String[] { "indice", "Padron", "Calle", "Nro Puerta", "Dpto", "Valor US$", "Tamaño m2",
				"Baños", "Cuartos", "Otros", "Comodidades" };
		// String[] columnas = new String[] { "indice", "Padron", "Calle", "Nro Puerta",
		// "Departamento", "Valor", "Tamaño", "Servicios", "Cliente", "Tipo" };
		dataTabla = new Object[this.listadoHabitable.size()][columnas.length];
		int i = 0;
		for (Habitable item : this.listadoHabitable) {
			String[] arrData = { String.valueOf(i + 1), String.valueOf(item.getNroPadron()), item.getCalle(),
					String.valueOf(item.getNroPuerta()), item.getDepartamento(),
					String.valueOf("US$" + item.getValor()), String.valueOf(item.getTamanio() + "m2"),
					String.valueOf(item.getCantidad_Banos()), String.valueOf(item.getCantidad_Cuartos()),
					String.valueOf(item.getOtrasHabitaciones()), String.valueOf(item.getComodidades()) };
			dataTabla[i] = arrData;
			i++;
		}
		modeloTabla = new DefaultTableModel(dataTabla, columnas) {
			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tableHabitables.setModel(modeloTabla);
	}// fin metodo
}
