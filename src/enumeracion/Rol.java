package enumeracion;

public enum Rol {

	CEO(0),
	GERENTE(1),
	ADMINISTRATIVO(2);

	private int Puesto;
	
	Rol(int i) {
		this.Puesto = i;
	}

	public int getPuesto() {
		return Puesto;
	}

	public void setPuesto(int puesto) {
		Puesto = puesto;
	}
		
	
	
}
