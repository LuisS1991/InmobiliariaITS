package repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import conexion.ManipularBd;

public abstract class ADataBase {
	public ManipularBd baseDatos;
	private  ArrayList<Object> listaobj;
	
	
	public ADataBase(ManipularBd bd){
		this.baseDatos = bd;
	}
	
	public abstract int Alta(Arrays[] parametros);
	public abstract int Modificar(Arrays[] parametros);
	public abstract int Eliminar(Arrays[] parametros);
	public abstract void Listar(ResultSet rs);

	public ArrayList<Object> getListaobj() {
		return listaobj;
	}

	public void setListaobj(ArrayList<Object> listaobj) {
		this.listaobj = listaobj;
	}
	

}
