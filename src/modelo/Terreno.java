package modelo;


public class Terreno extends Inmueble{

	

	private String Servicios;
	

	public String getServicios() {
		return Servicios;
	}

	public void setServicios(String servicios) {
		Servicios = servicios;
	}

	public Terreno(int nroPadron, String calle, int nroPuerta, String dpto, int valor, int tamaño, String servicios,
			Cliente cli) {
		super(nroPadron, calle, nroPuerta, dpto, valor, tamaño, cli);
		Servicios = servicios;
	}

	public Terreno() {
		
	}
		
			
}
