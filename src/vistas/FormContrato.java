package vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;
import controlador.ClienteController;
import controlador.ContratoController;
import controlador.InmuebleController;
import enumeracion.TipoContrato;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Inmueble;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FormContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser dcFechaInicio;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoContrato;
	private JDateChooser dcFechaFin;
	private JTextArea taDesc;
	private JTextField txtNroContrato;
	private JTextField txtPrecio;
	private JTextField txtGarantia;
	private Contrato contrato;
	private JTextField txtBuscarCliente;
	private JTextField txtBuscarInmo;
	private JButton btnBuscarCliente;
	private JButton btnBuscarInmo;
	private Cliente cliente;
	private Inmueble inmo;
	private JLabel lblNomCliente;
	private JLabel lblNroPadron;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FormContrato(VentanaPpl ventana, boolean modal, Contrato con) {
		super(ventana, modal);
		this.contrato = con;
		setTitle("Alta Contrato");
		setBounds(100, 100, 762, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nro. Contrato:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 48, 92, 33);
		contentPanel.add(lblNewLabel);
		{
			txtNroContrato = new JTextField();
			txtNroContrato.setBounds(122, 49, 170, 33);
			contentPanel.add(txtNroContrato);
			txtNroContrato.setColumns(10);
		}
		{
			JLabel lblTipoContrato = new JLabel("Tipo Contrato:");
			lblTipoContrato.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTipoContrato.setBounds(431, 48, 106, 33);
			contentPanel.add(lblTipoContrato);
		}
		{
			cbTipoContrato = new JComboBox();
			cbTipoContrato.setModel(new DefaultComboBoxModel(TipoContrato.values()));
			cbTipoContrato.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			cbTipoContrato.setBounds(547, 49, 170, 33);
			contentPanel.add(cbTipoContrato);
		}
		{
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblCliente.setBounds(20, 179, 98, 33);
			contentPanel.add(lblCliente);
		}
		{
			JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
			lblFechaInicio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblFechaInicio.setBounds(20, 110, 92, 33);
			contentPanel.add(lblFechaInicio);
		}
		{
			dcFechaInicio = new JDateChooser();
			dcFechaInicio.setDateFormatString("yyyy-MM-dd");
			dcFechaInicio.setDate(Date.from(Instant.now()));
			dcFechaInicio.setBounds(122, 110, 170, 33);
			contentPanel.add(dcFechaInicio);
		}
		{
			JLabel lblFechaFin = new JLabel("Fecha Fin:");
			lblFechaFin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblFechaFin.setBounds(444, 109, 92, 33);
			contentPanel.add(lblFechaFin);
		}
		{
			dcFechaFin = new JDateChooser();
			dcFechaFin.setDateFormatString("yyyy-MM-dd");
			dcFechaFin.setDate(Date.from(Instant.now()));
			dcFechaFin.setBounds(547, 110, 170, 33);
			contentPanel.add(dcFechaFin);
		}
		{
			JLabel lblTipoContrato = new JLabel("Garantia:");
			lblTipoContrato.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTipoContrato.setBounds(444, 178, 92, 33);
			contentPanel.add(lblTipoContrato);
		}
		{
			txtGarantia = new JTextField();
			txtGarantia.setColumns(10);
			txtGarantia.setBounds(547, 179, 170, 33);
			contentPanel.add(txtGarantia);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblPrecio.setBounds(444, 236, 92, 33);
			contentPanel.add(lblPrecio);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(547, 237, 170, 33);
			contentPanel.add(txtPrecio);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 415, 748, 51);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GuardarContrato();
					}
				});
				okButton.setBounds(384, 5, 170, 33);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						cerrar();
					}
				});
				cancelButton.setBounds(564, 5, 170, 33);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton btnActualizar = new JButton("Actualizar");
				btnActualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actualizar();
					}
				});
				btnActualizar.setActionCommand("OK");
				btnActualizar.setBounds(194, 5, 170, 33);

				if (this.contrato != null) {
					buttonPane.add(btnActualizar);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Descricion", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(47, 296, 670, 109);
			contentPanel.add(panel);
			panel.setLayout(new CardLayout(0, 0));
			{
				taDesc = new JTextArea();
				panel.add(taDesc, "name_1466205351062700");
			}
		}
		{
			txtBuscarCliente = new JTextField();
			txtBuscarCliente.setBounds(123, 180, 170, 33);
			contentPanel.add(txtBuscarCliente);
			txtBuscarCliente.setColumns(10);
		}
		{
			JLabel lblClientea = new JLabel("Inmueble:");
			lblClientea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblClientea.setBounds(19, 252, 98, 33);
			contentPanel.add(lblClientea);
		}
		{
			txtBuscarInmo = new JTextField();
			txtBuscarInmo.setColumns(10);
			txtBuscarInmo.setBounds(122, 253, 170, 33);
			contentPanel.add(txtBuscarInmo);
		}
		{
			btnBuscarCliente = new JButton("");
			btnBuscarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscarCliente();
				}
			});
			btnBuscarCliente.setIcon(new ImageIcon(FormContrato.class.getResource("/imagenes/person_search.png")));
			btnBuscarCliente.setBounds(303, 188, 24, 24);
			contentPanel.add(btnBuscarCliente);
		}
		{
			btnBuscarInmo = new JButton("");
			btnBuscarInmo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buscarInmo();
				}
			});
			btnBuscarInmo.setIcon(new ImageIcon(FormContrato.class.getResource("/imagenes/search.png")));
			btnBuscarInmo.setBounds(303, 260, 24, 24);
			contentPanel.add(btnBuscarInmo);
		}
		{
			lblNomCliente = new JLabel("");
			lblNomCliente.setBounds(122, 153, 115, 24);
			contentPanel.add(lblNomCliente);
		}
		{
			lblNroPadron = new JLabel("");
			lblNroPadron.setBounds(122, 229, 115, 24);
			contentPanel.add(lblNroPadron);
		}

		if (this.contrato != null)

		{
			CargarContrato();
		}
	}// ctor

	private void buscarCliente() {
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		cliente = ClienteController.Buscar(txtBuscarCliente.getText());
		if (cliente != null) {
			lblNomCliente.setText(cliente.getNombreCompleto());
			txtBuscarCliente.setText(String.valueOf(cliente.getCI()));
			btnBuscarCliente.setIcon(new ImageIcon(FormContrato.class.getResource("/imagenes/search_check.png")));
		}else {
			JOptionPane.showMessageDialog(null, "cliente no encontrado", "alerta", 0, null);
		}
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin

	private void buscarInmo() {
		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		inmo = InmuebleController.BuscarInmo(txtBuscarInmo.getText());
		if (inmo != null) {
			lblNroPadron.setText(String.valueOf(inmo.getNroPadron()));
			txtBuscarInmo.setText(String.valueOf(inmo.getNroPadron()));
			btnBuscarInmo.setIcon(new ImageIcon(FormContrato.class.getResource("/imagenes/search_check.png")));
		}else {
			JOptionPane.showMessageDialog(null, "inmueble no encontrado", "alerta", 0, null);
		}
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}// fin

	private void GuardarContrato() {
		ContratoController.AltaContratos(dcFechaInicio.getDate(), dcFechaFin.getDate(), txtNroContrato.getText(),
				cliente, cbTipoContrato.getSelectedIndex(), txtPrecio.getText(), txtGarantia.getText(),
				taDesc.getText(),txtBuscarInmo.getText());
		limpiar();
		cerrar();
	}

	private void cerrar() {
		this.dispose();
	}

	private void limpiar() {
		dcFechaInicio.setDate(Date.from(Instant.now()));
		cbTipoContrato.setSelectedIndex(0);
		txtBuscarCliente.setText("");
		txtBuscarCliente.setText("");
		dcFechaFin.setDate(Date.from(Instant.now()));
		taDesc.append("");
		txtNroContrato.setText("");
		txtPrecio.setText("");
		txtGarantia.setText("");
	}

	private void CargarContrato() {
		txtNroContrato.setText(String.valueOf(contrato.getNroContrato()));
		txtPrecio.setText(String.valueOf(contrato.getPrecio()));
		taDesc.append(contrato.getDescripcion());
		txtGarantia.setText(contrato.getGarantia());
		cbTipoContrato.setSelectedItem(contrato.getTipo());
		txtBuscarCliente.setText(String.valueOf(cliente.getCI()));
		txtBuscarInmo.setText(String.valueOf(inmo.getNroPadron()));
		cbTipoContrato.setSelectedIndex(contrato.getTipo());

		SimpleDateFormat formato = new SimpleDateFormat(dcFechaInicio.getDateFormatString());
		Date fecha;
		try {
			fecha = formato.parse(contrato.getFechaInicio());
			dcFechaInicio.setDate(fecha);
			fecha = formato.parse(contrato.getFechaFin());
			dcFechaFin.setDate(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// fin

	private void actualizar() {
		ContratoController.ActualizarContrato(dcFechaInicio.getDate(), dcFechaFin.getDate(), txtNroContrato.getText(),
				cliente, cbTipoContrato.getSelectedIndex(), txtPrecio.getText(), txtGarantia.getText(),
				taDesc.getText(),txtBuscarInmo.getText());
		limpiar();
		cerrar();
	}// fin

}
