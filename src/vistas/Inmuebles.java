package vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Inmuebles extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Inmuebles() {
		setLayout(null);
		setToolTipText("inmuebles");
		
		JLabel lblInmuebles = new JLabel("INMUEBLES");
		lblInmuebles.setBounds(344, 285, 136, 14);
		add(lblInmuebles);
	}

}
