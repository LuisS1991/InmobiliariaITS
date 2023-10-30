package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import conexion.Conexion;
import modelo.Cliente;

public class RepositorioCliente {
	private Conexion conn;
	private ArrayList<Cliente> clientes;
	private Connection conexion;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;

	public RepositorioCliente() {
		conn = new Conexion();
	}

	public boolean GuardarCliente(Cliente cliente) {
		if (this.BuscarCliente(cliente.getCI()) != null) {
			return false;
		} else {
			String query = "INSERT INTO `cliente`(`CI`,`NombreCompleto`,`FechaNac`,`Email`,`telefono`,`tipoCliente`)VALUES(?,?,?,?,?,?)";
			try {
				conexion = conn.GetConexion();
				ps = conexion.prepareStatement(query);
				ps.setInt(1, cliente.getCI());
				ps.setString(2, cliente.getNombreCompleto());
				ps.setString(3, cliente.getFechaNac());
				ps.setString(4, cliente.getEmail());
				ps.setInt(5, cliente.getTelefono());
				ps.setInt(6, cliente.getTipoCliente());
				ps.executeUpdate();
				ps.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn.CerrarConexion();
			}
		}
		return false;
	}// fin metodo

	public ArrayList<Cliente> ListarClientes() {
		clientes = new ArrayList<Cliente>();
		Cliente cli = null;
		String query = "SELECT * FROM `Cliente`;";

		try {
			conexion = conn.GetConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(query);

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
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}

		return clientes;
	}// fin metodo

	public boolean EditarCliente(Cliente cliente) {
		String query = "UPDATE `cliente` SET `NombreCompleto`=?,`FechaNac`=?,`Email`=?,`telefono`=?,`tipoCliente`=? WHERE `CI` ="
				+ cliente.getCI() + ";";
		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement(query);
			ps.setString(1, cliente.getNombreCompleto());
			ps.setString(2, cliente.getFechaNac());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getTelefono());
			ps.setInt(5, cliente.getTipoCliente());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.CerrarConexion();
		}

	}// fin metodo

	public boolean EliminarCliente(int ci) {
		String query = "DELETE FROM `cliente`WHERE `CI`=" + ci + ";";
		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			conn.CerrarConexion();
		}

	}

	public Cliente BuscarCliente(int ci) {
		String query = "SELECT * FROM `Cliente` CI=" + ci + " ;";

		try {
			conexion = conn.GetConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(query);
			Cliente cli = null;
			if (rs.next()) {
				cli = new Cliente();
				cli.setCI(rs.getInt("CI"));
				cli.setNombreCompleto(rs.getString("NombreCompleto"));
				cli.setEmail(rs.getString("Email"));
				cli.setFechaNac(rs.getString("FechaNac"));
				cli.setTelefono(Integer.parseInt(rs.getString("telefono")));
				cli.setTipoCliente(Integer.parseInt(rs.getString("tipoCliente")));
			}
			st.close();
			return cli;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
		return null;
	}
}// fin metodo
