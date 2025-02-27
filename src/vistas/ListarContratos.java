package vistas;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Aplicacion;
import controlador.ContratoController;
import modelo.Contrato;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ListarContratos extends JPanel {
	private ArrayList<Contrato> contratoList;
	private DefaultTableModel modeloTabla;
	private Object[][] dataTabla = null;
	private JTable tablaContratos;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	
	public ListarContratos(ArrayList<Contrato> lista ) {
		this.contratoList = lista;
		setLayout(null);
	
		JPanel panelSinDatos = new JPanel();
		panelSinDatos.setBounds(0, 64, 939, 424);
		add(panelSinDatos);
		panelSinDatos.setLayout(null);
		panelSinDatos.setVisible(false);
		if(this.contratoList.size() <=0) {
			panelSinDatos.setVisible(true);
		}
		JLabel lbl = new JLabel("No Hay Datos Cargados al Momento");
		lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(10, 22, 919, 53);
		panelSinDatos.add(lbl);
			
		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTabla.setBounds(0, 100, 917, 308);
		add(panelTabla);
		panelTabla.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 899, 288);
		panelTabla.add(scrollPane);
		
		tablaContratos = new JTable();
		tablaContratos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnActualizar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tablaContratos);
		
		JLabel lblListadoDeContratos = new JLabel("Listado de Contratos");
		lblListadoDeContratos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeContratos.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblListadoDeContratos.setBounds(10, 10, 907, 48);
		add(lblListadoDeContratos);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 418, 907, 53);
		add(panel);
		panel.setLayout(null);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarRegistro();
			}
		});
		btnActualizar.setBounds(10, 10, 170, 33);
		btnActualizar.setEnabled(false);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarRegistro();
			}
		});
		btnEliminar.setBounds(205, 10, 170, 33);
		btnEliminar.setEnabled(false);
		panel.add(btnEliminar);
		
		JButton btnContratoOk = new JButton("Autorizar Contrato");
		btnContratoOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autorizarContrato();
			}
		});
		btnContratoOk.setEnabled(false);
		btnContratoOk.setBounds(397, 10, 170, 33);
		panel.add(btnContratoOk);
		if(Aplicacion.getUsuarioActual().getRol()!=2) {
			btnContratoOk.setEnabled(true);
		}
		cargarTabla();

		
	}//ctor
	
	private void cargarTabla() {
		String[] columnas = { "Indice", "NroContrato", "FechaInicial", "FechaFinal", "Garantia", "Autorizado", "precio","tipo","desc" };
		dataTabla = new Object[contratoList.size()][columnas.length];

		int i = 0;
		for (Contrato cont : contratoList) {
			String[] arrData = {String.valueOf((i+1)),String.valueOf(cont.getNroContrato()),cont.getFechaInicio(),
								cont.getFechaFin(),cont.getGarantia(),cont.toStringAutorizacion(),
								String.valueOf(cont.getPrecio()), cont.toStringTipoCliente() ,cont.getDescripcion()};
			dataTabla[i] = arrData;
			i++;
		}
		modeloTabla = new DefaultTableModel(dataTabla, columnas) {
			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tablaContratos.setModel(modeloTabla);
	}//fin

	private void ActualizarRegistro() {
		int nroContrato = Integer.parseInt((String) tablaContratos.getValueAt(tablaContratos.getSelectedRow(), 1));		
		for (Contrato cont : contratoList) {
			if (nroContrato == cont.getNroContrato()) {
				ContratoController.FormActualizarContrato(cont);
				return;
			}
		}
	}//fin

	private void EliminarRegistro() {
		int nroContrato = Integer.parseInt((String) tablaContratos.getValueAt(tablaContratos.getSelectedRow(), 1));	
		ContratoController.EliminarContrato(nroContrato);
	}//fin

	private void autorizarContrato() {
		int nroContrato = Integer.parseInt((String) tablaContratos.getValueAt(tablaContratos.getSelectedRow(), 1));	
		ContratoController.AutorizarContrato(nroContrato);
	}//fin
}
