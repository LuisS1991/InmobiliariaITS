package vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controlador.UsuariosController;
import enumeracion.Rol;

import javax.swing.DefaultComboBoxModel;

public class Usuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasena;
	private JPasswordField txtRepiteContrasena;
	@SuppressWarnings("rawtypes")
	private JComboBox cbRolUsuario;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Usuarios() {
		// GUI
		setLayout(null);

		JPanel PanelAddUsuario = new JPanel();
		PanelAddUsuario.setLayout(null);
		PanelAddUsuario.setBounds(10, 10, 662, 614);
		add(PanelAddUsuario);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(32, 57, 604, 351);
		PanelAddUsuario.add(panel_1);

		JLabel lblNewLabel = new JLabel("Nombre Usuario:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 36, 129, 30);
		panel_1.add(lblNewLabel);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBorder(null);
		txtNombreUsuario.setBounds(220, 35, 249, 33);
		panel_1.add(txtNombreUsuario);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblContrasea.setBounds(73, 94, 129, 30);
		panel_1.add(lblContrasea);

		JLabel lblRolDeUsuario = new JLabel("Rol de Usuario:");
		lblRolDeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRolDeUsuario.setBounds(73, 216, 129, 30);
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
		lblRepitaContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRepitaContrasea.setBounds(73, 153, 144, 30);
		panel_1.add(lblRepitaContrasea);

		cbRolUsuario = new JComboBox();
		cbRolUsuario.setModel(new DefaultComboBoxModel(Rol.values()));
		cbRolUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbRolUsuario.setBounds(220, 213, 249, 33);
		panel_1.add(cbRolUsuario);

		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuardarUsuario();
			}
		});
		btnAgregarUsuario.setBounds(150, 275, 142, 38);
		panel_1.add(btnAgregarUsuario);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancelar.setBounds(327, 275, 142, 38);
		panel_1.add(btnCancelar);

		JLabel lblNewLabel_1 = new JLabel("Agregar Nuevo Usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(12, 12, 636, 33);
		PanelAddUsuario.add(lblNewLabel_1);
	}

	private void GuardarUsuario() {
		UsuariosController.GuardarUsuarios(txtNombreUsuario.getText(), new String(txtContrasena.getPassword()),
				new String(txtRepiteContrasena.getPassword()), cbRolUsuario.getSelectedIndex());
	}

}
