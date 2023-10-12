package vistas;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

public class Usuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuarios;
	private DefaultTableModel modeloTabla;
	private Object[][] dataTabla = null;
	private JTable tableUsuarios;

	public Usuarios(ArrayList<Usuario> lista) {
		usuarios = lista;
		// GUI
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 360, 648, 245);
		add(scrollPane);
		tableUsuarios = new JTable();
		scrollPane.setViewportView(tableUsuarios);
		loadDatos();
	}

	@SuppressWarnings("serial")
	private void loadDatos() {
		String[] columnas = { "id", "Nombre Completo", "Rol" };
		dataTabla = new Object[usuarios.size()][columnas.length];
		int i = 0;
		for (Usuario u : usuarios) {
			String[] arrData = { String.valueOf(i + 1), u.getNombreUsuario(), String.valueOf(u.getRol()) };
			dataTabla[i] = arrData;
			i++;
		}
		modeloTabla = new DefaultTableModel(dataTabla, columnas) {
			// membuat tabel tidak bisa diedit saat diklik
			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tableUsuarios.setModel(modeloTabla);
	}

}
