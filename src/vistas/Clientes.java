package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class Clientes extends JPanel {

	/**
	 * Create the panel.
	 */
	public Clientes() {
		setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Clientes");
		add(lblNewLabel, "name_20678242258600");

	}

}
