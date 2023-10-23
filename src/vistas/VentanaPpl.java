package vistas;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.Aplicacion;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class VentanaPpl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaPpl() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				  int a=JOptionPane.showConfirmDialog(null,"Estas Seguro de salir?");
				  if(a==JOptionPane.YES_OPTION){
				  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); }
			}
		});
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPpl.class.getResource("/imagenes/casaIcon.png")));
		this.setTitle(Aplicacion.configApp.get("JAVA_NAME"));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1108, 700);
		contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}

	public void CambiarVistaPanel(JPanel panel) {
		if (contentPane.getComponentCount() > 0)
			contentPane.remove(0);
		panel.setBounds(0, 0, this.getBounds().width, this.getBounds().height);
		contentPane.add(panel);
	}

}
