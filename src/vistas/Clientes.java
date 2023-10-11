package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;


public class Clientes extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Clientes() {
		setToolTipText("clientes");
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setBounds(368, 259, 55, 14);
		add(lblNewLabel);
	}

}
