package modelo;

import java.util.ArrayList;

public class Cliente {
	private int CI;
	private String NombreCompleto;
	private String FechaNac;
	private String Email;
	private int Telefono;
	private ArrayList<Inmueble> ListInmuebles;
		
	public Cliente(int cI, String nombreCompleto, String fechaNac, String email, int telefono) {
		CI = cI;
		NombreCompleto = nombreCompleto;
		FechaNac = fechaNac;
		Email = email;
		Telefono = telefono;
	}
	
	
	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	public String getFechaNac() {
		return FechaNac;
	}
	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public ArrayList<Inmueble> getListInmuebles() {
		return ListInmuebles;
	}
	public void setListInmuebles(ArrayList<Inmueble> listInmuebles) {
		ListInmuebles = listInmuebles;
	}
	
	
	
}
