package vistas;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import controlador.Aplicacion;
import controlador.ContratoController;
import controlador.MenuPrincipalController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.Font;

@SuppressWarnings("serial")
public class MenuPrincipal extends JPanel {
	private JPanel panelVistas;
	private JPanel subMenuCliente;
	private JPanel PMenuLateral;
	private JToggleButton btnCliente;
	private JToggleButton btnContratos;
	private JButton btnUsuarios;
	private JSeparator separator;
	private JToggleButton btnInmuble;
	private JButton btnNuevoInmuble;
	private JButton btnListarInmuble;
	private JPanel subMenuInmuble;
	private JPanel subMenuContrato;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNombre;

	public MenuPrincipal() {
		setLayout(null);

		PMenuLateral = new JPanel();
		PMenuLateral.setBounds(0, 0, 154, 655);
		add(PMenuLateral);
		PMenuLateral.setLayout(null);

		btnContratos = new JToggleButton("Contratos");
		btnContratos.setName("Contratos");
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnContratos.isSelected()) {
					btnCliente.setEnabled(false);
					btnInmuble.setEnabled(false);
					btnUsuarios.setVisible(false);
				} else {
					btnCliente.setEnabled(true);
					btnInmuble.setEnabled(true);
					btnUsuarios.setVisible(true);
				}
				AnimacionSubMenu(subMenuContrato, btnContratos);
			}
		});

		btnCliente = new JToggleButton("Clientes");
		btnCliente.setName("Clientes");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnCliente.isSelected()) {
					btnInmuble.setVisible(false);
					btnContratos.setVisible(false);
				} else {
					btnInmuble.setVisible(true);
					btnContratos.setVisible(true);
				}
				AnimacionSubMenu(subMenuCliente, btnCliente);
			}
		});

		subMenuInmuble = new JPanel();
		subMenuInmuble.setLayout(null);
		subMenuInmuble.setBackground(new Color(174, 174, 174));
		subMenuInmuble.setBounds(12, 190, 130, 0);
		PMenuLateral.add(subMenuInmuble);

		btnNuevoInmuble = new JButton("Nuevo");
		btnNuevoInmuble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.VerNuevoInmuble();
			}
		});
		btnNuevoInmuble.setBounds(21, 10, 85, 21);
		subMenuInmuble.add(btnNuevoInmuble);

		btnListarInmuble = new JButton("Listar");
		btnListarInmuble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.ListarInmo();
			}
		});
		btnListarInmuble.setBounds(21, 45, 85, 21);
		subMenuInmuble.add(btnListarInmuble);

		subMenuCliente = new JPanel();
		subMenuCliente.setBackground(new Color(174, 174, 174));
		subMenuCliente.setBounds(12, 133, 130, 0);
		PMenuLateral.add(subMenuCliente);
		subMenuCliente.setLayout(null);

		JButton btnNuevoCliente = new JButton("Nuevo");
		btnNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.VerAddClienteNuevo();
			}
		});
		btnNuevoCliente.setBounds(21, 10, 85, 21);
		subMenuCliente.add(btnNuevoCliente);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.VerListadoClientes();
			}
		});
		btnListar.setBounds(21, 45, 85, 21);
		subMenuCliente.add(btnListar);

		subMenuContrato = new JPanel();
		subMenuContrato.setLayout(null);
		subMenuContrato.setBackground(new Color(174, 174, 174));
		subMenuContrato.setBounds(12, 247, 130, 0);
		PMenuLateral.add(subMenuContrato);

		JButton btnNuevoContrato = new JButton("Nuevo");
		btnNuevoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContratoController.FormAltaContrato();
			}
		});
		btnNuevoContrato.setBounds(21, 10, 85, 21);
		subMenuContrato.add(btnNuevoContrato);

		JButton btnListarContrato = new JButton("Listar");
		btnListarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.ListarContrato();
			}
		});
		btnListarContrato.setBounds(21, 45, 85, 21);
		subMenuContrato.add(btnListarContrato);
		btnCliente.setBounds(12, 96, 130, 37);
		PMenuLateral.add(btnCliente);
		btnContratos.setBounds(12, 210, 130, 37);
		PMenuLateral.add(btnContratos);

		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalController.VerUsuarios();
			}
		});
		btnUsuarios.setBounds(12, 269, 130, 37);
		PMenuLateral.add(btnUsuarios);
		btnUsuarios.setVisible(false);
		if(Aplicacion.getUsuarioActual().getRol() == 0) {
			btnUsuarios.setVisible(true);
		}
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacion.CerrarSesion();
			}
		});
		btnCerrarSesion.setBounds(12, 587, 130, 37);
		PMenuLateral.add(btnCerrarSesion);

		JLabel lblNewLabel = new JLabel(Aplicacion.configApp.get("JAVA_NAME"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 154, 32);
		PMenuLateral.add(lblNewLabel);

		btnInmuble = new JToggleButton("Inmubles");
		btnInmuble.setName("Inmubles");
		btnInmuble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnInmuble.isSelected()) {
					btnContratos.setVisible(false);
					btnCliente.setEnabled(false);
				} else {
					btnContratos.setVisible(true);
					btnCliente.setEnabled(true);
				}
				AnimacionSubMenu(subMenuInmuble, btnInmuble);
			}
		});
		btnInmuble.setBounds(12, 155, 130, 37);
		PMenuLateral.add(btnInmuble);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(164, 0, 935, 655);
		add(panel_1);

		lblNewLabel_1 = new JLabel("BIENVENIDO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(26, 51, 376, 90);
		panel_1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("AL SISTEMA DE GESTION INMOBILIARIO");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setBounds(61, 283, 788, 90);
		panel_1.add(lblNewLabel_2);

		lblNombre = new JLabel(Aplicacion.getUsuarioActual().getNombreUsuario());
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNombre.setBounds(504, 51, 311, 90);
		panel_1.add(lblNombre);

		separator = new JSeparator();
		separator.setBounds(155, 0, 16, 655);
		add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);

		panelVistas = new JPanel();
		panelVistas.setBounds(164, 0, 935, 655);
		add(panelVistas);
		panelVistas.setLayout(new CardLayout(0, 0));

	}

	public void CambiarVista(JPanel panel) {
		panelVistas.removeAll();
		panel.setBounds(0, 0, panelVistas.getBounds().width, panelVistas.getBounds().height);
		panelVistas.add(panel);
		panelVistas.revalidate();
		panelVistas.repaint();
	}

	private void AnimacionSubMenu(JPanel contenedor, JToggleButton boton) {
		if (contenedor.getBounds().height <= 0) {
			boton.setText("ocultar");
			Thread hilo = new Thread() {
				public void run() {
					for (int i = 0; i < 95; i++) {
						contenedor.setBounds(contenedor.getBounds().x, contenedor.getBounds().y,
								contenedor.getBounds().width, i);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			};
			hilo.start();
			return;
		}
		if (contenedor.getBounds().height >= 0) {
			boton.setText(boton.getName());
			Thread hilo = new Thread() {
				public void run() {
					for (int i = 95; i >= 0; i--) {
						contenedor.setBounds(contenedor.getBounds().x, contenedor.getBounds().y,
								contenedor.getBounds().width, i);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			hilo.start();
			return;
		}
	}// fin
}
