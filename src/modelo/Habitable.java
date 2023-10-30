package modelo;

public class Habitable extends Inmueble {

	private String Tipo;
	private int Cantidad_Cuartos;
	private int Cantidad_Banos;
	private int OtrasHabitaciones;
	private String comodidades;

	public Habitable(int nroPadron, String calle, int nroPuerta, String dpto, double valor, double tamaño, Cliente cli,
			String tipo, int cantidad_Cuartos, int cantidad_Banos, int otrasHabitaciones, String comodidades) {
		super(nroPadron, calle, nroPuerta, dpto, valor, tamaño, cli);
		Tipo = tipo;
		Cantidad_Cuartos = cantidad_Cuartos;
		Cantidad_Banos = cantidad_Banos;
		OtrasHabitaciones = otrasHabitaciones;
		this.comodidades = comodidades;
	}

	public Habitable() {

	}

	public String getComodidades() {
		return comodidades;
	}

	public void setComodidades(String comodidades) {
		this.comodidades = comodidades;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public int getCantidad_Cuartos() {
		return Cantidad_Cuartos;
	}

	public void setCantidad_Cuartos(int cantidad_Cuartos) {
		Cantidad_Cuartos = cantidad_Cuartos;
	}

	public int getCantidad_Banos() {
		return Cantidad_Banos;
	}

	public void setCantidad_Banos(int cantidad_Banos) {
		Cantidad_Banos = cantidad_Banos;
	}

	public int getOtrasHabitaciones() {
		return OtrasHabitaciones;
	}

	public void setOtrasHabitaciones(int otrasHabitaciones) {
		OtrasHabitaciones = otrasHabitaciones;
	}

}
