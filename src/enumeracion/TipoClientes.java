package enumeracion;

public enum TipoClientes {

	Dueño(0), Comprador(1), Alquiler(2);

	private int TipoCliente;

	TipoClientes(int i) {
		this.TipoCliente = i;
	}

	public int getTipoCliente() {
		return TipoCliente;
	}

	public void setPuesto(int tipo) {
		TipoCliente = tipo;
	}

}
