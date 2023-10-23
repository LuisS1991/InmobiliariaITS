package modelo;

public class Habitable extends Inmueble {
	
	private String Tipo;
	private int Cantidad_Cuartos;
	private int Cantidad_Banos;
	private int OtrasHabitaciones;

	public Habitable(int nroPadron, String calle, String dpto, int nroPuerta, int valor, int tamaño) {
		super(nroPadron, calle, dpto, nroPuerta, valor, tamaño);
		// TODO Auto-generated constructor stub
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
