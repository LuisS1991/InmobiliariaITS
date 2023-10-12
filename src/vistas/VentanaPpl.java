package vistas;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;


public class VentanaPpl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaPpl() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPpl.class.getResource("/imagenes/casaIcon.png")));
		setTitle("Inmobiliaria ITS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}


	public void CambiarVistaPanel(JPanel panel) {
		if(contentPane.getComponentCount() > 0)
			contentPane.remove(0);
		panel.setBounds(0, 0, this.getBounds().width, this.getBounds().height);
		contentPane.add(panel);
	}


}
