package vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;
import controlador.ContratoController;
import enumeracion.TipoContrato;
import modelo.Cliente;
import modelo.Contrato;

@SuppressWarnings("serial")
public class FormContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JDateChooser dcFechaInicio;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTipoContrato;
	@SuppressWarnings("rawtypes")
	private JComboBox cbCliente;
	private JDateChooser dcFechaFin;
	private JTextArea taDesc;
	private JTextField txtNroContrato;
	private JTextField txtPrecio;
	private JTextField txtGarantia;
	private ArrayList<Cliente> listadoCliente;
	private Contrato contrato;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FormContrato(VentanaPpl ventana, boolean modal, ArrayList<Cliente> cliente, Contrato con) {
		super(ventana, modal);
		this.listadoCliente = cliente;
		this.contrato = con;
		setTitle("Alta Contrato");
		setBounds(100, 100, 762, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nro. Contrato:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(62, 48, 92, 33);
		contentPanel.add(lblNewLabel);
		{
			txtNroContrato = new JTextField();
			txtNroContrato.setBounds(165, 49, 170, 33);
			contentPanel.add(txtNroContrato);
			txtNroContrato.setColumns(10);
		}
		{
			JLabel lblTipoContrato = new JLabel("Tipo Contrato:");
			lblTipoContrato.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTipoContrato.setBounds(364, 48, 106, 33);
			contentPanel.add(lblTipoContrato);
		}
		{
			cbTipoContrato = new JComboBox();
			cbTipoContrato.setModel(new DefaultComboBoxModel(TipoContrato.values()));
			cbTipoContrato.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			cbTipoContrato.setBounds(480, 49, 170, 33);
			contentPanel.add(cbTipoContrato);
		}
		{
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblCliente.setBounds(62, 172, 106, 33);
			contentPanel.add(lblCliente);
		}
		{
			cbCliente = new JComboBox();
			cbCliente.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			cbCliente.setBounds(165, 172, 170, 33);
			contentPanel.add(cbCliente);
		}
		{
			JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
			lblFechaInicio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblFechaInicio.setBounds(62, 109, 92, 33);
			contentPanel.add(lblFechaInicio);
		}
		{
			dcFechaInicio = new JDateChooser();
			dcFechaInicio.setDateFormatString("yyyy-MM-dd");
			dcFechaInicio.setDate(Date.from(Instant.now()));
			dcFechaInicio.setBounds(165, 110, 170, 33);
			contentPanel.add(dcFechaInicio);
		}
		{
			JLabel lblFechaFin = new JLabel("Fecha Fin:");
			lblFechaFin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblFechaFin.setBounds(377, 109, 92, 33);
			contentPanel.add(lblFechaFin);
		}
		{
			dcFechaFin = new JDateChooser();
			dcFechaFin.setDateFormatString("yyyy-MM-dd");
			dcFechaFin.setDate(Date.from(Instant.now()));
			dcFechaFin.setBounds(480, 110, 170, 33);
			contentPanel.add(dcFechaFin);
		}
		{
			JLabel lblTipoContrato = new JLabel("Garantia:");
			lblTipoContrato.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTipoContrato.setBounds(364, 172, 106, 33);
			contentPanel.add(lblTipoContrato);
		}
		{
			txtGarantia = new JTextField();
			txtGarantia.setColumns(10);
			txtGarantia.setBounds(480, 172, 170, 33);
			contentPanel.add(txtGarantia);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblPrecio.setBounds(62, 255, 92, 33);
			contentPanel.add(lblPrecio);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(165, 256, 170, 33);
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
				buttonPane.add(btnActualizar);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Descricion", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(364, 229, 377, 109);
			contentPanel.add(panel);
			panel.setLayout(new CardLayout(0, 0));
			{
				taDesc = new JTextArea();
				panel.add(taDesc, "name_331396085020200");
			}
		}
		CargarClietnes();
		if (this.contrato != null) {
			CargarContrato();
		}
	}// ctor

	@SuppressWarnings({ "unchecked" })
	private void CargarClietnes() {
		for (Cliente cliente : listadoCliente) {
			cbCliente.addItem(cliente.getNombreCompleto());
		}
	}

	private void GuardarContrato() {
		ContratoController.AltaContratos(dcFechaInicio.getDate(), dcFechaFin.getDate(), txtNroContrato.getText(),
				this.obtenerCliente((String)cbCliente.getSelectedItem()),cbTipoContrato.getSelectedIndex(), txtPrecio.getText(),
				txtGarantia.getText(), taDesc.getText());
		limpiar();
		cerrar();
	}

	private void cerrar() {
		this.dispose();
	}

	private void limpiar() {
		dcFechaInicio.setDate(Date.from(Instant.now()));
		cbTipoContrato.setSelectedIndex(0);
		cbCliente.setSelectedIndex(0);
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
		cbCliente.setSelectedIndex(this.listadoCliente.indexOf(contrato.getCliente()));
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
				this.obtenerCliente((String)cbCliente.getSelectedItem()),cbTipoContrato.getSelectedIndex(), txtPrecio.getText(),
				txtGarantia.getText(), taDesc.getText());
		limpiar();
		cerrar();
	}
	
	private Cliente obtenerCliente(String clienteNombre){
		for (Cliente cliente : listadoCliente) {
			if(cliente.getNombreCompleto().equals(clienteNombre)) {
				return cliente;
			}
		}
		return null;
	}//fin
	
}
