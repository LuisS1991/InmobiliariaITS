package enumeracion;

public enum TipoContrato {


	Compra(0), Venta(1), Alquiler(2);

	private int index;

	TipoContrato(int i) {
		this.index = i;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int t) {
		this.index = t;
	}
 
}
