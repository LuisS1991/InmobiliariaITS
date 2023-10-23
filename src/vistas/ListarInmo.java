package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Habitable;
import modelo.Terreno;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;


public class ListarInmo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableTerrenos;
	private JTable tableHabitables;
	private JPanel panelHabitables;
	private JPanel panelTerrenos;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JPanel panel;
	private ArrayList<Terreno> listadoTerrenos;
	private ArrayList<Habitable> listadoHabitable;
	private DefaultTableModel modeloTabla;
	private Object[][] dataTabla = null;
	
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ListarInmo(ArrayList<Terreno> listTerrenos,ArrayList<Habitable> listHabitable) {
		listadoTerrenos = listTerrenos;
		listadoHabitable = listHabitable;
		//GUI
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Listado Inmuebles");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 12, 906, 36);
		add(lblNewLabel);

		panelTerrenos = new JPanel();
		panelTerrenos.setLayout(null);
		panelTerrenos.setBounds(2, 150, 930, 320);
		panelTerrenos.setVisible(false);
		add(panelTerrenos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 906, 296);
		panelTerrenos.add(scrollPane);

		tableTerrenos = new JTable();
		scrollPane.setViewportView(tableTerrenos);

		panelHabitables = new JPanel();
		panelHabitables.setBounds(2, 150, 930, 320);
		add(panelHabitables);
		panelHabitables.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 12, 906, 296);
		panelHabitables.add(scrollPane_1);

		tableHabitables = new JTable();
		scrollPane_1.setViewportView(tableHabitables);

		panel = new JPanel();
		panel.setBounds(12, 77, 365, 58);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tipo de Inmuble:");
		lblNewLabel_1.setBounds(12, 20, 96, 17);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		comboBox = new JComboBox();
		comboBox.setBounds(126, 12, 170, 33);
		panel.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					panelHabitables.setVisible(true);
					panelTerrenos.setVisible(false);
				} else {
					panelHabitables.setVisible(false);
					panelTerrenos.setVisible(true);
				}
			}
		});
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Habitable", "Terreno" }));

		cargarHabitables();
		cargarTerrenos();
	}//CTOR
	
	@SuppressWarnings("serial")
	private void cargarTerrenos() {
		 //String[] columnas = new String[] { "indice", "Padron", "Calle", "Nro Puerta","Dpto", "Valor US$", "Tamaño", "Baños", "Cuartos", "Otros", "Comodidades", "Cliente", "Tipo" };
		String[] columnas = new String[] { "indice", "Padron", "Calle",	"Nro Puerta", "Departamento", "Valor", "Tamaño", "Servicios", "Cliente", "Tipo" };
		dataTabla = new Object[listadoTerrenos.size()][columnas.length];
		 int i=0;
		 for(Terreno item : this.listadoTerrenos) {
			String[] arrData = { String.valueOf(i + 1),String.valueOf(item.getNroPadron()),item.getCalle(),String.valueOf(item.getNroPuerta()),
								item.getDepartamento(),String.valueOf("US$"+item.getValor()),String.valueOf(item.getTamaño()+"m2"),item.getServicios(),
								String.valueOf(item.getCliente().getCI()),String.valueOf(item.getCliente().getTipoCliente()) };
				
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
	}//fin metodo
	
	@SuppressWarnings("serial")
	private void cargarHabitables() {
		 String[] columnas = new String[] { "indice", "Padron", "Calle", "Nro Puerta","Dpto", "Valor US$", "Tamaño", "Baños", "Cuartos", "Otros", "Comodidades", "Cliente", "Tipo" };
		//String[] columnas = new String[] { "indice", "Padron", "Calle",	"Nro Puerta", "Departamento", "Valor", "Tamaño", "Servicios", "Cliente", "Tipo" };
		dataTabla = new Object[this.listadoHabitable.size()][columnas.length];
		 int i=0;
		 for(Habitable item : this.listadoHabitable) {
			String[] arrData = { String.valueOf(i + 1),String.valueOf(item.getNroPadron()),item.getCalle(),String.valueOf(item.getNroPuerta()),
								item.getDepartamento(),String.valueOf("US$"+item.getValor()),String.valueOf(item.getTamaño()+"m2"),String.valueOf(item.getCantidad_Banos()),
								String.valueOf(item.getCantidad_Cuartos()),String.valueOf(item.getOtrasHabitaciones()),String.valueOf(item.getComodidades()),							
								String.valueOf(item.getCliente().getCI()),String.valueOf(item.getCliente().getTipoCliente()) };
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
	}//fin metodo
	
	
	
}
