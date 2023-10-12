package vistas;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Usuarios extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Usuarios() {
		setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel PLIstarUsuarios = new JPanel();
		PLIstarUsuarios.setBackground(Color.RED);
		tabbedPane.addTab("Listar", null, PLIstarUsuarios, null);
		PLIstarUsuarios.setLayout(null);
		
		JPanel PNuevoUsuario = new JPanel();
		tabbedPane.addTab("Nuevo", null, PNuevoUsuario, null);
		PNuevoUsuario.setBackground(Color.GREEN);
		PNuevoUsuario.setLayout(null);
		add(tabbedPane, "name_23641022627419");

	}

}
