package vistas;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import controlador.Aplicacion;
import controlador.MenuPrincipalController;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;



public class MenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JDesktopPane DPVistas;

	public MenuPrincipal() {
		setLayout(null);

		JPanel PMenuLateral = new JPanel();
		PMenuLateral.setBounds(0, 0, 154, 630);
		add(PMenuLateral);
		PMenuLateral.setLayout(null);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.ShowCliente();
			}
		});

		btnClientes.setBounds(12, 95, 130, 37);
		PMenuLateral.add(btnClientes);

		JButton btnNewButton_1 = new JButton("Contratos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.ShowContratos();
			}
		});
		btnNewButton_1.setBounds(12, 193, 130, 37);
		PMenuLateral.add(btnNewButton_1);

		JButton btnInmuebles = new JButton("Inmuebles");
		btnInmuebles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.ShowInmuebles();
			}
		});
		btnInmuebles.setBounds(12, 144, 130, 37);
		PMenuLateral.add(btnInmuebles);

		JButton btnNewButton_1_2 = new JButton("Usuarios");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.ShowUsuarios();
			}
		});
		btnNewButton_1_2.setBounds(12, 242, 130, 37);
		PMenuLateral.add(btnNewButton_1_2);

		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion.CerrarSesion();
			}
		});

		JButton btnConfiguraciones = new JButton("Configuraciones");
		btnConfiguraciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Configuraciones");
				Configuraciones config = new Configuraciones();
				config.setBackground(Color.ORANGE);
				CambiarVista(config);
			}
		});

		btnConfiguraciones.setBounds(12, 467, 130, 37);
		PMenuLateral.add(btnConfiguraciones);
		btnCerrarSesion.setBounds(12, 516, 130, 37);
		PMenuLateral.add(btnCerrarSesion);

		JSeparator separator = new JSeparator();
		separator.setBounds(155, 0, 9, 630);
		add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);

		DPVistas = new JDesktopPane();
		DPVistas.setBackground(new Color(238, 238, 236));
		DPVistas.setBounds(166, 0, 684, 630);
		add(DPVistas);
		DPVistas.setLayout(new CardLayout(0, 0));

	}

	public void CambiarVista(JPanel panel) {
		DPVistas.removeAll();
		panel.setBounds(0, 0, DPVistas.getBounds().width, DPVistas.getBounds().height);
		DPVistas.add(panel);
	}
}
