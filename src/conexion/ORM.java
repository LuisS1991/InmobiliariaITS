package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import repositorio.Repositorio;

public class ORM {
	private Conexion conn;
	private Connection conexion;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;

	public ORM() {
		conn = new Conexion();
	}

	public int Insert(String query) {
		return this.modificarBD(query);
	}// fin

	public int Update(String query) {
		return this.modificarBD(query);
	}// fin

	public void Select(String query,Repositorio repo) {
		try {
			conexion = conn.GetConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(query);
			repo.Listar(rs);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
	}// fin

	public int Delete(String query) {
		return this.modificarBD(query);
	}// fin
	
	private int modificarBD(String query) {
		int resultado = 0;
		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement(query);
			resultado = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}// fin

	public void CerrarConexion() {
		conn.CerrarConexion();
	}//fin
}
