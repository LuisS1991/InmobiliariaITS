package modelo;

import java.util.ArrayList;
import java.util.Objects;

import enumeracion.TipoClientes;

public class Cliente {
	private int CI;
	private String NombreCompleto;
	private String FechaNac;
	private String Email;
	private int Telefono;
	public int tipoCliente;

	private ArrayList<Inmueble> ListInmuebles;

	public Cliente(int cI, String nombreCompleto, String fechaNac, String email, int telefono) {
		CI = cI;
		NombreCompleto = nombreCompleto;
		FechaNac = fechaNac;
		Email = email;
		Telefono = telefono;
	}

	public Cliente() {
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipo) {
		tipoCliente = tipo;
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

	public String toStringTipoCliente(int i) {
		if (TipoClientes.Dueño.getTipoCliente() == i) {
			return TipoClientes.Dueño.name();
		} else if (TipoClientes.Comprador.getTipoCliente() == i) {
			return  TipoClientes.Comprador.name();
		} else {
			return  TipoClientes.Alquiler.name();
		}
	}//fin

	@Override
	public int hashCode() {
		return Objects.hash(CI, Email, FechaNac, ListInmuebles, NombreCompleto, Telefono, tipoCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return CI == other.CI && Objects.equals(Email, other.Email) && Objects.equals(FechaNac, other.FechaNac)
				&& Objects.equals(ListInmuebles, other.ListInmuebles)
				&& Objects.equals(NombreCompleto, other.NombreCompleto) && Telefono == other.Telefono
				&& tipoCliente == other.tipoCliente;
	}//fin
	
	
	
}
