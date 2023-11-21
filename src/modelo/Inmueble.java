package modelo;

public class Inmueble {

	private int NroPadron;
	private String Calle;
	private int NroPuerta;
	private String Departamento;
	private float Valor;
	private double Tamanio; // metros cuadrados
	private Cliente ClienteDuenio;

	public Inmueble(int nroPadron, String calle, int nroPuerta, String dpto, float valor, double tamaño, Cliente cli) {
		super();
		NroPadron = nroPadron;
		Calle = calle;
		Departamento = dpto;
		NroPuerta = nroPuerta;
		Valor = valor;
		Tamanio = tamaño;
		ClienteDuenio = cli;
	}

	public Inmueble() {

	}

	public Cliente getClienteDuenio() {
		return this.ClienteDuenio;
	}

	public void setClienteDuenio(Cliente cliente) {
		this.ClienteDuenio = cliente;
	}

	public int getNroPadron() {
		return NroPadron;
	}

	public void setNroPadron(int nroPadron) {
		NroPadron = nroPadron;
	}

	public String getCalle() {
		return Calle;
	}

	public void setCalle(String calle) {
		Calle = calle;
	}

	public int getNroPuerta() {
		return NroPuerta;
	}

	public void setNroPuerta(int nroPuerta) {
		NroPuerta = nroPuerta;
	}

	public float getValor() {
		return Valor;
	}

	public void setValor(float valor) {
		Valor = valor;
	}

	public double getTamanio() {
		return this.Tamanio;
	}

	public void setTamanio(double Tamanio) {
		this.Tamanio = Tamanio;
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

}
