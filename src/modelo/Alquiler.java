package modelo;

public class Alquiler extends Contrato {

	private String FechaInicioAlquiler;
	private String FechaFinAlquiler;
	private String Garantia;
	//mismo caso que el anterior
	
	public Alquiler(int nroContrato, int autorizacion) {
 		super(nroContrato,  autorizacion);
		// TODO Auto-generated constructor stub
	}

	public String getFechaInicioAlquiler() {
		return FechaInicioAlquiler;
	}

	public void setFechaInicioAlquiler(String fechaInicioAlquiler) {
		FechaInicioAlquiler = fechaInicioAlquiler;
	}

	public String getFechaFinAlquiler() {
		return FechaFinAlquiler;
	}

	public void setFechaFinAlquiler(String fechaFinAlquiler) {
		FechaFinAlquiler = fechaFinAlquiler;
	}

	public String getGarantia() {
		return Garantia;
	}

	public void setGarantia(String garantia) {
		Garantia = garantia;
	}

	
	
}
