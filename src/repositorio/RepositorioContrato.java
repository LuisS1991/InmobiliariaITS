package repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.ORM;
import modelo.Cliente;
import modelo.Contrato;

public class RepositorioContrato extends Repositorio{
	private ORM dateBase ;
	private ArrayList<Contrato> listado;
	
	public RepositorioContrato() {
		listado = new ArrayList<Contrato>();
		dateBase = new ORM();
	}
 	
	public void AutorizarContrato(int NroContrato) {
		String query ="UPDATE  `contrato` SET Autorizacion = 1 WHERE `NroContrato` ='"+NroContrato+"';";
		this.dateBase.Update(query);
		this.dateBase.CerrarConexion();
	}//fin
	
	public void Guardar(Contrato c) {
		String query ="INSERT INTO  `contrato` (`NroContrato`,`FechaInicial`,`FechaFinal`,`Garantia`,`Autorizacion`,`precio`,`desc`,`tipo`,`clienteComplen`,`nroPadron`)"
				+ "VALUES("+c.getNroContrato()+",'"+c.getFechaInicio()+"','"+c.getFechaFin()+"','"+c.getGarantia()
				+"',"+c.getAutorizacion()+","+c.getPrecio()+",'"+c.getDescripcion()+"',"+c.getTipo()
				+","+c.getClienteComplementario().getCI()
				+","+ c.getNroPadron()+");";
		this.dateBase.Insert(query);
	}//fin
	
	public ArrayList<Contrato> Listar() {
		this.dateBase.Select("SELECT * FROM contrato;", this);
		this.dateBase.CerrarConexion();
		return listado;
	}//fin

	public int  Eliminar(int NroContrato) {
		int res= this.dateBase.Delete("DELETE FROM `contrato` WHERE NroContrato="+NroContrato+" and Autorizacion =0;");
		this.dateBase.CerrarConexion();
		return res;
	}
	
	public void Editar(Contrato c) {
		String query ="UPDATE  `contrato` SET `FechaInicial` ='"+c.getFechaInicio()+"',`FechaFinal` ='"+c.getFechaFin()+"',"
				+ "`Garantia` ='"+c.getGarantia()+"',`Autorizacion` = "+c.getAutorizacion()+",`precio` ="+c.getPrecio()+","
				+ "`desc` = '"+c.getDescripcion()+"',"
				+ "`tipo` = "+c.getTipo()
				+ ",`clienteComplen` ="+c.getClienteComplementario().getCI()
				+ " WHERE `NroContrato` ='"+c.getNroContrato()+"';";
		this.dateBase.Update(query);
		this.dateBase.CerrarConexion();
	}

	public Contrato Buscar(int nroContrato) {
		this.dateBase.Select("SELECT * FROM contrato WHERE NroContrato="+nroContrato+";", this);
		this.dateBase.CerrarConexion();
		if(listado.size()>0) {
			return listado.get(0);
		}else {
			return null;
		}
	}//fin
	
	public Contrato BuscarContratoClienteInmo(String query) {
		this.dateBase.Select(query, this);
		this.dateBase.CerrarConexion();
		if(listado.size()>0) {
			return listado.get(0);
		}else {
			return null;
		}
	}//fin
	
	/*metodo sobre escrito para guaradar los objetos y retornarlos*/
	@Override
	public void Listar(ResultSet rs) {
		try {
			RepositorioCliente repoCliente= new RepositorioCliente();
			while(rs.next()) {
				Contrato c = new Contrato();
				c.setNroContrato(Integer.parseInt(rs.getString("NroContrato")));
				c.setAutorizacion(Integer.parseInt(rs.getString("Autorizacion")));
				c.setFechaInicio(rs.getString("FechaInicial"));
				c.setFechaFin(rs.getString("FechaFinal"));
				c.setGarantia(rs.getString("Garantia"));
				c.setPrecio(Double.parseDouble(rs.getString("precio")));
				c.setDescripcion(rs.getString("desc"));
				c.setTipo(Integer.parseInt(rs.getString("tipo")));
				Cliente cli = repoCliente.BuscarCliente(Integer.parseInt(rs.getString("clienteComplen")));
				c.setNroPadron(Integer.parseInt(rs.getString("nroPadron")));
				c.setClienteComplementario(cli);
				listado.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//fin
	
	
}
