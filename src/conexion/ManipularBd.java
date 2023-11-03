package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import repositorio.ADataBase;

public class ManipularBd {
	private Conexion conn;
	private Connection conexion;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	
	
	public ManipularBd() {
		conn = new Conexion();
	}
	
	public int Modificar(String query) {
		int resultado=0;
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
	}
	
	public void Listar(ADataBase repo,String query) {

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
		
	}//fin
}
