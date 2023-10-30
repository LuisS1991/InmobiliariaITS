package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Contratos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Contratos() {
		setLayout(null);
		setToolTipText("contratos");

		JLabel lblNewLabel = new JLabel("contratos");
		lblNewLabel.setBounds(244, 271, 55, 14);
		add(lblNewLabel);
	}
}
