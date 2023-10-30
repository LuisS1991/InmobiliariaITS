package enumeracion;

public enum Departamentos {
	Artigas(0), Canelones(1), Cerro_Largo(2), Colonia(3), Durazno(4), Flores(5), Florida(6), Lavalleja(7), Maldonado(8),
	Montevideo(9), Paysandú(10), Río_Negro(11), Rivera(12), Rocha(13), Salto(14), San_José(15), Tacuarembó(16),
	Treinta_y_Tres(17), SORIANO(18);

	private int departamento;

	Departamentos(int i) {
		this.departamento = i;
	}

	public int getDpto() {
		return departamento;
	}

	public void setDpto(int dpto) {
		departamento = dpto;
	}

}
