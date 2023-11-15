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
		dateBase = new ORM();
	}
 
	 
	public void Guardar(Contrato c) {
		String query ="INSERT INTO  `contrato` (`NroContrato`,`FechaInicial`,`FechaFinal`,`Garantia`,`Autorizacion`,`precio`,`desc`,`tipo`,`cliente`)"
				+ "VALUES("+c.getNroContrato()+",'"+c.getFechaInicio()+"','"+c.getFechaFin()+"','"+c.getGarantia()
				+"',"+c.getAutorizacion()+","+c.getPrecio()+",'"+c.getDescripcion()+"',"+c.getTipo()+","+c.getCliente().getCI()+");";
		this.dateBase.Insert(query);
		
	}//fin
	
	public ArrayList<Contrato> Listar() {
		this.dateBase.Select("SELECT * FROM contrato;", this);
		this.dateBase.CerrarConexion();
		return listado;
	}//fin

	public void Eliminar(int NroContrato) {
		this.dateBase.Delete("DELETE FROM `contrato` WHERE NroContrato="+NroContrato+";");
		this.dateBase.CerrarConexion();
	}
	
	public void Editar(Contrato c) {
		String query ="UPDATE  `contrato` SET `FechaInicial` ='"+c.getFechaInicio()+"',`FechaFinal` ='"+c.getFechaFin()+"',"
				+ "`Garantia` ='"+c.getGarantia()+"',`Autorizacion` = "+c.getAutorizacion()+",`precio` ="+c.getPrecio()+","
				+ "`desc` = '"+c.getDescripcion()+"',"
				+ "`tipo` = "+c.getTipo()
				+ ",`cliente` ="+c.getCliente().getCI()
				+ " WHERE `NroContrato` ='"+c.getNroContrato()+"';";
		this.dateBase.Update(query);
		this.dateBase.CerrarConexion();
	}
	
	/*metodo sobre escrito para guaradar los objetos y retornarlos*/
	@Override
	public void Listar(ResultSet rs) {
		try {
			RepositorioCliente repoCliente= new RepositorioCliente();
			 listado = new ArrayList<Contrato>();
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
				Cliente cli = repoCliente.BuscarCliente(Integer.parseInt(rs.getString("cliente")));
				c.setCliente(cli);
				listado.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//fin
	
	
	
}
