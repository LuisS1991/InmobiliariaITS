package modelo;

import java.util.ArrayList;
import enumeracion.TipoContrato;

public class Contrato {

	private int NroContrato;
	private int Autorizacion = 0;
	private String Descripcion;
	private double Precio;
	private int Tipo;
	private String Garantia;
	private String FechaInicio;
	private String FechaFin;
	private Cliente Duenio;
	private Cliente ClienteComplementario;
	private int NroPadron;
	
	
	
	public int getNroPadron() {
		return NroPadron;
	}

	public void setNroPadron(int nroPadron) {
		NroPadron = nroPadron;
	}

	public Cliente getDuenio() {
		return Duenio;
	}

	public void setDuenio(Cliente duenio) {
		Duenio = duenio;
	}

	public Cliente getClienteComplementario() {
		return ClienteComplementario;
	}

	public void setClienteComplementario(Cliente clienteComplementario) {
		ClienteComplementario = clienteComplementario;
	}

	private ArrayList<Inmueble> ListInmuebles;

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

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}

	public String getGarantia() {
		return Garantia;
	}

	public void setGarantia(String garantia) {
		Garantia = garantia;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	public ArrayList<Inmueble> getListInmuebles() {
		return ListInmuebles;
	}

	public void setListInmuebles(ArrayList<Inmueble> listInmuebles) {
		ListInmuebles = listInmuebles;
	}


	public String toStringTipoCliente() {
		if (TipoContrato.Compra.getIndex() == this.getTipo()) {
			return TipoContrato.Compra.name();
		} else if (TipoContrato.Venta.getIndex() == this.getTipo()) {
			return  TipoContrato.Venta.name();
		} else {
			return  TipoContrato.Alquiler.name();
		}
	}//fin

	public String toStringAutorizacion() {
		if(this.getAutorizacion() !=0) {
			return "SI";
		}
		return "NO";
	}//fin
}
