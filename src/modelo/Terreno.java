package modelo;

import java.util.ArrayList;

public class Terreno extends Inmueble{

	
	private ArrayList<String> Servicios;
	
	public Terreno(int nroPadron, String calle, int nroPuerta, int valor, int tamaño,
			ArrayList<String> servicios) {
		super(nroPadron, calle, nroPuerta, valor,  tamaño);
		Servicios = servicios;
	}

	public Terreno(int nroPadron, String calle, int nroPuerta, int valor,  int tamaño) {
		super(nroPadron, calle, nroPuerta, valor,  tamaño);
	}

	
	public ArrayList<String> getServicios() {
		return Servicios;
	}

	public void setServicios(ArrayList<String> servicios) {
		Servicios = servicios;
	}
		
		
		
}
