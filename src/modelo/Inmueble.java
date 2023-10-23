package modelo;

public class Inmueble {
	
	private int NroPadron;
	private String Calle;
	private int NroPuerta;
	private String Departamento;
	private int Valor;
	private int Tamaño; //metros cuadrados
	
	public Inmueble(int nroPadron, String calle, String dpto,int nroPuerta, int valor, int tamaño) {
		super();
		NroPadron = nroPadron;
		Calle = calle;
		Departamento = dpto;
		NroPuerta = nroPuerta;
		Valor = valor;
		Tamaño = tamaño;
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
	public int getValor() {
		return Valor;
	}
	public void setValor(int valor) {
		Valor = valor;
	}
	public int getTamaño() {
		return Tamaño;
	}
	public void setTamaño(int tamaño) {
		Tamaño = tamaño;
	}


	public String getDepartamento() {
		return Departamento;
	}


	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}
	
	

	
}
