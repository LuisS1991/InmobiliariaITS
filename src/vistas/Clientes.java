package vistas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import com.toedter.calendar.JDateChooser;
import controlador.ClienteController;
import enumeracion.TipoClientes;
import modelo.Cliente;
import java.util.Date;

@SuppressWarnings("serial")
public class Clientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCI;
	private JTextField txtNombreCompleto;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JDateChooser dateFechaNac;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoDuenio;
	private JLabel lblTitulo;
	private JButton btnGuardar;
	private JButton btnEditar;

	public Clientes(VentanaPpl ventana, boolean modal, Cliente cli) {
		super(ventana, modal);
		initComponents();
		if (cli != null) {
			cargarCliente(cli);
		}
	}// ctor

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/imagenes/casaIcon.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Nuevo Cliente");
		setType(Type.POPUP);
		setBounds(100, 100, 735, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		{
			lblTitulo = new JLabel("Agregar Nuevo Cliente");
			lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 26));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBounds(10, 10, 701, 37);
			contentPanel.add(lblTitulo);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cedula Identidad:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(10, 115, 107, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombe Completo:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(373, 115, 117, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Fecha Nacimiento:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(10, 182, 107, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("E-mail:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(373, 182, 107, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Telefono:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(10, 262, 107, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtCI = new JTextField();
			txtCI.setBounds(122, 99, 170, 33);
			contentPanel.add(txtCI);
			txtCI.setColumns(10);
		}
		{
			txtNombreCompleto = new JTextField();
			txtNombreCompleto.setColumns(10);
			txtNombreCompleto.setBounds(482, 99, 170, 33);
			contentPanel.add(txtNombreCompleto);
		}

		dateFechaNac = new JDateChooser();
		dateFechaNac.setDateFormatString("yyyy-MM-dd");
		dateFechaNac.setDate(Date.from(Instant.now()));
		dateFechaNac.setBounds(122, 166, 170, 33);
		contentPanel.add(dateFechaNac);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(482, 166, 170, 33);
		contentPanel.add(txtEmail);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(122, 246, 170, 33);
		contentPanel.add(txtTelefono);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 382, 701, 52);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guardarCliente();
					}
				});
				btnGuardar.setBounds(372, 5, 155, 37);
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cerraJDialog();
					}
				});
				cancelButton.setBounds(550, 5, 141, 37);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				btnEditar = new JButton("Actualizar");
				btnEditar.setVisible(false);
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						editarCliente();
					}
				});
				btnEditar.setActionCommand("OK");
				btnEditar.setBounds(372, 5, 155, 37);
				buttonPane.add(btnEditar);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Tipo Dueño:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(373, 256, 107, 17);
			contentPanel.add(lblNewLabel_1);
		}
		{
			cbTipoDuenio = new JComboBox();
			cbTipoDuenio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			cbTipoDuenio.setModel(new DefaultComboBoxModel(TipoClientes.values()));
			cbTipoDuenio.setBounds(482, 245, 170, 33);
			contentPanel.add(cbTipoDuenio);
		}
	}

	private void cargarCliente(Cliente cli) {
		setTitle("Editar Cliente");
		lblTitulo.setText("Editar Cliente");
		txtCI.setText(String.valueOf(cli.getCI()));
		txtCI.setEnabled(false);
		txtNombreCompleto.setText(cli.getNombreCompleto());
		txtEmail.setText(cli.getEmail());
		txtTelefono.setText(String.valueOf(cli.getTelefono()));
		cbTipoDuenio.setSelectedIndex(cli.getTipoCliente());
		SimpleDateFormat formato = new SimpleDateFormat(dateFechaNac.getDateFormatString());
		Date fechaNac;
		try {
			fechaNac = formato.parse(cli.getFechaNac());
			dateFechaNac.setDate(fechaNac);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnGuardar.setVisible(false);
		btnEditar.setVisible(true);
	}// fin metodo

	private void guardarCliente() {
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		String formato = dateFechaNac.getDateFormatString();
		Date fecha = dateFechaNac.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fnacim = String.valueOf(sdf.format(fecha));
		ClienteController.GuardarCliente(txtCI.getText(), txtNombreCompleto.getText(), txtEmail.getText(),
				txtTelefono.getText(), fnacim, cbTipoDuenio.getSelectedIndex());
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		limpiarCampos();
	}

	private void editarCliente() {
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		String formato = dateFechaNac.getDateFormatString();
		Date fecha = dateFechaNac.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fnacim = String.valueOf(sdf.format(fecha));
		ClienteController.ActualizarCliente(txtCI.getText(), txtNombreCompleto.getText(), txtEmail.getText(),
				txtTelefono.getText(), fnacim, cbTipoDuenio.getSelectedIndex());
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		limpiarCampos();
	}

	private void cerraJDialog() {
		this.dispose();
	}

	private void limpiarCampos() {
		txtCI.setText("");
		txtNombreCompleto.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		cbTipoDuenio.setSelectedIndex(0);
		dateFechaNac.setDateFormatString("yyyy-MM-dd");
		dateFechaNac.setDate(Date.from(Instant.now()));
	}

	
	
}
