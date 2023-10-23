package modelo;

import java.util.ArrayList;

public class Terreno extends Inmueble{

	
	public Terreno(int nroPadron, String calle, String dpto, int nroPuerta, int valor, int tamaño) {
		super(nroPadron, calle, dpto, nroPuerta, valor, tamaño);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<String> Servicios;
	

	public ArrayList<String> getServicios() {
		return Servicios;
	}

	public void setServicios(ArrayList<String> servicios) {
		Servicios = servicios;
	}
		
		
		
}
