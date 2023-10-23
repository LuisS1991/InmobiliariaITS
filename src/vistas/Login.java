package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import controlador.Aplicacion;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreUsuario;
	private JPasswordField txtPass;

	/**
	 * Create the panel.
	 */
	public Login(){

		setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("Inmobiliaria I.T.S.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(543, 192, 335, 40);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Version 0.1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(679, 536, 80, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/casaIcon.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 12, 452, 618);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "INICIAR SESION", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(543, 244, 335, 280);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre Usuario:");
		lblNewLabel_3.setBounds(54, 67, 114, 19);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Contraseña:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setBounds(54, 127, 114, 19);
		panel.add(lblNewLabel_3_1);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(54, 90, 230, 35);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(54, 144, 230, 35);
		panel.add(txtPass);
		
		JButton ntmIngresar = new JButton("Ingresar");
		ntmIngresar.setBounds(54, 207, 230, 40);
		panel.add(ntmIngresar);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sistema de Gestion Inmobiliario");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_2_1.setBounds(68, 12, 838, 40);
		add(lblNewLabel_2_1);
		ntmIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion.InicioSesion();
			}
		});

	}

}
