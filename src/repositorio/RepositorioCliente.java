package repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.ORM;
import modelo.Cliente;

public class RepositorioCliente extends Repositorio {
	private ArrayList<Cliente> clientes;
	private ORM dataBase;

	public RepositorioCliente() {
		clientes = new ArrayList<Cliente>();
		dataBase = new ORM();
	}

	public boolean GuardarCliente(Cliente cliente) {
		if (this.BuscarCliente(cliente.getCI()) != null) {
			return false;
		} else {
			String query = "INSERT INTO `cliente`(`CI`,`NombreCompleto`,`FechaNac`,`Email`,`telefono`,`tipoCliente`)"
					+ "VALUES(" + cliente.getCI() + ",'" + cliente.getNombreCompleto() + "','" + cliente.getFechaNac()
					+ "','" + cliente.getEmail() + "'," + cliente.getTelefono() + "," + cliente.getTipoCliente() + ")";
			this.dataBase.Insert(query);
			return true;
		}
	}// fin metodo

	public ArrayList<Cliente> ListarClientes() {
		String query = "SELECT * FROM `Cliente`;";
		this.dataBase.Select(query, this);
		this.dataBase.CerrarConexion();
		return clientes;
	}// fin metodo

	public boolean EditarCliente(Cliente cliente) {
		String query = "UPDATE `cliente` SET `NombreCompleto`='" + cliente.getNombreCompleto() + "',`FechaNac`='"
				+ cliente.getFechaNac() + "',`Email`='" + cliente.getEmail() + "',`telefono`=" + cliente.getTelefono()
				+ ",`tipoCliente`=" + cliente.getTipoCliente() + " WHERE `CI` =" + cliente.getCI() + ";";

		if (this.dataBase.Update(query) > 0) {
			this.dataBase.CerrarConexion();
			return true;
		} else {
			return false;
		}
	}// fin metodo

	public boolean EliminarCliente(int ci) {
		String query = "DELETE FROM `cliente` WHERE `CI`=" + ci + ";";
		if (this.dataBase.Delete(query) > 0) {
			this.dataBase.CerrarConexion();
			return true;
		} else {
			return false;
		}

	}// fin

	public Cliente BuscarCliente(int ci) {
		String query = "SELECT * FROM `Cliente` WHERE `CI`=" + ci + ";";
		this.dataBase.Select(query, this);
		if (this.clientes.size() > 0) {
			return this.clientes.get(0);
		} else {
			return null;
		}
	}// fin

	@Override
	public void Listar(ResultSet rs) {
		Cliente cli = null;
		try {

			while (rs.next()) {
				cli = new Cliente();
				cli.setCI(rs.getInt("CI"));
				cli.setNombreCompleto(rs.getString("NombreCompleto"));
				cli.setEmail(rs.getString("Email"));
				cli.setFechaNac(rs.getString("FechaNac"));
				cli.setTelefono(Integer.parseInt(rs.getString("telefono")));
				cli.setTipoCliente(Integer.parseInt(rs.getString("tipoCliente")));
				clientes.add(cli);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// fin
}// fin metodo
