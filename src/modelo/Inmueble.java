package modelo;

public class Inmueble {

	private int NroPadron;
	private String Calle;
	private int NroPuerta;
	private String Departamento;
	private double Valor;
	private double Tamanio; // metros cuadrados
	private Cliente Cliente;

	public Inmueble(int nroPadron, String calle, int nroPuerta, String dpto, double valor, double tamaño, Cliente cli) {
		super();
		NroPadron = nroPadron;
		Calle = calle;
		Departamento = dpto;
		NroPuerta = nroPuerta;
		Valor = valor;
		Tamanio = tamaño;
		Cliente = cli;
	}

	public Inmueble() {

	}

	public Cliente getCliente() {
		return this.Cliente;
	}

	public void setCliente(Cliente cliente) {
		this.Cliente = cliente;
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

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
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
