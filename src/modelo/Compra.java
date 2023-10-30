package modelo;

public class Compra extends Contrato {

	private String FechaCompra;
	private String FechaVenta;
	// falta metodos get y set dado que no estoy seguro del tipo de dato

	public Compra(int nroContrato, int autorizacion) {
		super(nroContrato, autorizacion);
		// TODO Auto-generated constructor stub
	}

	public String getFechaCompra() {
		return FechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		FechaCompra = fechaCompra;
	}

	public String getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		FechaVenta = fechaVenta;
	}

}
