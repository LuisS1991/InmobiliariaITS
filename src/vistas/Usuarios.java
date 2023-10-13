package vistas;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import controlador.UsuariosController;
import enumeracion.Rol;
import modelo.Usuario;

public class Usuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuarios;
	private DefaultTableModel modeloTabla;
	private Object[][] dataTabla = null;
	private JTable tableUsuarios;
	private JPanel PanelTabla;
	private JPanel PanelAddUsuario;
	private JLayeredPane dpPpincipal;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasena;
	private JPasswordField txtRepiteContrasena;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRolUsuario;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Usuarios(ArrayList<Usuario> lista) {
		usuarios = lista;
		// GUI
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 660, 54);
		add(panel);
		panel.setLayout(null);
		
		JButton btnListarUsuarios = new JButton("Agregar Usuario");
		btnListarUsuarios.setBounds(86, 12, 127, 24);
		panel.add(btnListarUsuarios);
		
		JButton btnListarUsuario = new JButton("Listar Usuario");
		btnListarUsuario.setBounds(450, 12, 127, 24);
		panel.add(btnListarUsuario);
		btnListarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dpPpincipal.remove(0);
				dpPpincipal.add(PanelTabla);
			}
		});
		btnListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dpPpincipal.remove(0);
				dpPpincipal.add(PanelAddUsuario);
			}
		});
		
		dpPpincipal = new JLayeredPane();
		dpPpincipal.setBounds(12, 78, 660, 530);
		add(dpPpincipal);
	
		
		PanelTabla = new JPanel();
		PanelTabla.setBounds(0, 0, 660, 530);
		dpPpincipal.add(PanelTabla);
		PanelTabla.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 46, 660, 484);
		PanelTabla.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "name_19689224426204");
		tableUsuarios = new JTable();
		scrollPane.setViewportView(tableUsuarios);
		
		JLabel lblNewLabel_2 = new JLabel("Listado de Usuarios");
		lblNewLabel_2.setBounds(12, 12, 636, 33);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		PanelTabla.add(lblNewLabel_2);
		
		PanelAddUsuario = new JPanel();
		PanelAddUsuario.setBounds(0, 0, 660, 530);
		//dpPpincipal.add(PanelAddUsuario);
		PanelAddUsuario.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(32, 57, 604, 351);
		PanelAddUsuario.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Usuario:");
		lblNewLabel.setBounds(97, 36, 105, 30);
		panel_1.add(lblNewLabel);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBorder(null);
		txtNombreUsuario.setBounds(220, 35, 249, 33);
		panel_1.add(txtNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(97, 94, 105, 30);
		panel_1.add(lblContrasea);
		
		JLabel lblRolDeUsuario = new JLabel("Rol de Usuario:");
		lblRolDeUsuario.setBounds(97, 216, 105, 30);
		panel_1.add(lblRolDeUsuario);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBorder(null);
		txtContrasena.setBounds(220, 93, 249, 33);
		panel_1.add(txtContrasena);
		
		txtRepiteContrasena = new JPasswordField();
		txtRepiteContrasena.setBorder(null);
		txtRepiteContrasena.setBounds(220, 152, 249, 33);
		panel_1.add(txtRepiteContrasena);
		
		JLabel lblRepitaContrasea = new JLabel("Repita Contraseña:");
		lblRepitaContrasea.setBounds(97, 153, 120, 30);
		panel_1.add(lblRepitaContrasea);
		
		cbRolUsuario = new JComboBox();
		cbRolUsuario.setModel(new DefaultComboBoxModel(Rol.values()));
		cbRolUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		cbRolUsuario.setBounds(220, 213, 249, 33);
		panel_1.add(cbRolUsuario);
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuardarUsuario();
				usuarios = UsuariosController.ListarUsuarios();
				loadDatos(); 
			}
		});
		btnAgregarUsuario.setBounds(150, 275, 142, 38);
		panel_1.add(btnAgregarUsuario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarCampos();
			}

		});
		btnCancelar.setBounds(327, 275, 142, 38);
		panel_1.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Agregar Nuevo Usuario");
		lblNewLabel_1.setBounds(12, 12, 636, 33);
		PanelAddUsuario.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		loadDatos();
	}

	@SuppressWarnings("serial")
	private void loadDatos() {
		String[] columnas = { "id", "Nombre Completo", "Rol" };
		dataTabla = new Object[usuarios.size()][columnas.length];
		int i = 0;
		for (Usuario u : usuarios) {
			String[] arrData = { String.valueOf(i + 1), u.getNombreUsuario(), String.valueOf( u.ToStringRol(u.getRol()) ) };
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

	private void LimpiarCampos() {
		txtNombreUsuario.setText("");
		txtContrasena.setText("");
		txtRepiteContrasena.setText("");
		cbRolUsuario.setSelectedIndex(0);
	}
	
	private void GuardarUsuario() {
		UsuariosController.GuardarUsuarios(txtNombreUsuario.getText(),
											new String(txtContrasena.getPassword()),
											new String(txtRepiteContrasena.getPassword()),
											cbRolUsuario.getSelectedIndex());
	}
	

}
