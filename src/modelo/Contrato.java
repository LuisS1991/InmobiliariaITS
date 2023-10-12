package modelo;

import java.util.ArrayList;

public class Contrato {

	private int NroContrato;
	private int Autorizacion;
	private ArrayList<Inmueble> ListInmuebles;

	
	public Contrato(int nroContrato, int autorizacion, ArrayList<Inmueble> listInmuebles) {
		NroContrato = nroContrato;
		Autorizacion = autorizacion;
		ListInmuebles = listInmuebles;
	}

	public Contrato(int nroContrato,  int autorizacion) {
		NroContrato = nroContrato;
		Autorizacion = autorizacion;
	}


	public int getNroContrato() {
		return NroContrato;
	}

	public void setNroContrato(int nroContrato) {
		NroContrato = nroContrato;
	}

	public int getAutorizacion() {
		return Autorizacion;
	}

	public void setAutorizacion(int autorizacion) {
		Autorizacion = autorizacion;
	}


	public ArrayList<Inmueble> getListInmuebles() {
		return ListInmuebles;
	}

	public void setListInmuebles(ArrayList<Inmueble> listInmuebles) {
		ListInmuebles = listInmuebles;
	}
	

}
