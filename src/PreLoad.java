package taller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.event.*;
import java.awt.Toolkit;

public class PreLoad extends JFrame {
	Thread hilo;
	private Timer timer;
	private int progreso;
	private JProgressBar barra;
	private inicio login;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreLoad frame = new PreLoad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreLoad() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreLoad.class.getResource("/imagenes/casaIcon.png")));
		setTitle("Sistema Gestión de Taller");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Imagen backgroundImg = new Imagen(this.getWidth(), this.getHeight());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(backgroundImg);

		barra = new JProgressBar();
		barra.setStringPainted(true);
		barra.setBounds(12, 536, 383, 14);
		contentPane.add(barra);
		
		// carga de tus componentes para demoren en cargar que cargen y al mostrarlos ya estan disponibles
		CargaComponentes();		
		
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (progreso < 100) {
					progreso += 5; // Aumenta el progreso cada vez que se dispara el temporizador
					barra.setValue(progreso);
				} else {
					timer.stop(); // Detiene el temporizador cuando el progreso llega al 100%
					
					// Aquí puedes iniciar tu aplicación principal o realizar otras acciones
					login.setVisible(true);
					cerraVentana();
				}
			}
		});

		// Iniciamos el temporizador
		timer.start();

	}

	// Método para  carga de componentes
	private void CargaComponentes() {
		mismetodos.verificarConexionBD();
		login = new inicio();
	}

	private void cerraVentana() {
		this.dispose();
	}
	/*
	 * ESTA ES OTRA FORMA DE DIBUJAR IMAGENES Y ESCRIVIR TEXTO, LA VENTAJA QUE AL MODIFICAR LA VENTANA PODES VOLVER A REUBICAR TODO LOS ELEMENTOS
	 * */
	@SuppressWarnings("serial")
	public class Imagen extends JPanel {

		public Imagen(int ancho, int alto) {
			this.setSize(ancho, alto); // se selecciona el tamaño del panel si agrandas la ventana automatico toma el
										// mismo tamaño
		}

		// Se crea un método cuyo parámetro debe ser un objeto Graphics

		public void paint(Graphics grafico) {
			// Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
			ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/casaIcon.png"));
			// se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
			grafico.drawImage(Img.getImage(), 0, 0, 512, 512, null);
			grafico.setColor(Color.darkGray);// color de letra
			grafico.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));// fuente y tamaño
			grafico.drawString("Inmobiliaria ITS", 510, 150);// texto a escribir con las cordenasdas en x y
			grafico.drawString("Sistema de Gestiòn de Inmuebles", 510, 230);
			setOpaque(false);
			super.paintComponent(grafico);
		}
	}// fin inner clase
}
