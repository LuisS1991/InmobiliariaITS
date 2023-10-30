import java.awt.EventQueue;

import controlador.Aplicacion;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Aplicacion();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
