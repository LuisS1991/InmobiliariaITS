package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import controlador.Aplicacion;
import controlador.MenuPrincipalController;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;

public class MenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;

	
	public MenuPrincipal() {
		setLayout(null);

		JPanel PMenuLateral = new JPanel();
		PMenuLateral.setBounds(0, 0, 154, 640);
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
				Configuraciones config = new Configuraciones();
				config.setBackground(Color.ORANGE);
				CambiarVista(config);
			}
		});

		btnConfiguraciones.setBounds(12, 531, 130, 37);
		PMenuLateral.add(btnConfiguraciones);
		btnCerrarSesion.setBounds(12, 578, 130, 37);
		PMenuLateral.add(btnCerrarSesion);

		JSeparator separator = new JSeparator();
		separator.setBounds(155, 0, 9, 640);
		add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(164, 0, 736, 640);
		add(layeredPane);

	}

	public void CambiarVista(JPanel panel) {
		if(layeredPane.getComponentCount() >0){
			layeredPane.remove(0);
		}
		panel.setBounds(0,0, layeredPane.getBounds().width, layeredPane.getBounds().height);
		layeredPane.add(panel);
	}
}
