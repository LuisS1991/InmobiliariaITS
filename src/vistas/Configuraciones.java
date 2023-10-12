package vistas;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Configuraciones extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Configuraciones() {
		setLayout(null);

		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tglbtnNewToggleButton.setText("Cursor");
			}
		});
		tglbtnNewToggleButton.setBounds(145, 156, 136, 24);
		add(tglbtnNewToggleButton);

	}
}

/*
 * CUROSR DE CARGA Cursor.WAIT_CURSOR
 * 
 * setCursor(new Cursor(Cursor.WAIT_CURSOR));
 * 
 */