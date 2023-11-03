package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Contrato {

	private int NroContrato;
	private int Autorizacion;
	private String Descripcion;
	private double Precio;
	private String Tipo;
	private String Garantia;
	private Date FechaInicio;
	private Date FechaFin;
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
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getGarantia() {
		return Garantia;
	}
	public void setGarantia(String garantia) {
		Garantia = garantia;
	}
	public Date getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}
	public ArrayList<Inmueble> getListInmuebles() {
		return ListInmuebles;
	}
	public void setListInmuebles(ArrayList<Inmueble> listInmuebles) {
		ListInmuebles = listInmuebles;
	}

	
	
	
	

}
