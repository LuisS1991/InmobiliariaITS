package repositorio;

import java.util.ArrayList;
import modelo.Usuario;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioUsuarios {
	private Conexion conn;
	private ArrayList<Usuario> usuarios;
	private Connection conexion;
	private Statement st;
	private ResultSet rs;
	
	public RepositorioUsuarios() {
		conn = new Conexion();
	}
	
	public Usuario AutenticarUsuario(Usuario usuario) {
		return null;
	}

	public boolean RegistrarUsuario(Usuario usuario) {
		return true;
	}

	public boolean EliminarUsuario(int id_usuario) {
		return true;
	}

	public Usuario BuscarUsuario(int id_usuario) {
		return null;
	}

	public boolean EditarUsuario(Usuario usuario) {
		return true;
	}

	// este metodo se obtien del repositorio de datos
	public ArrayList<Usuario> ListarUsuarios() {
		usuarios = new ArrayList<Usuario>();
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		Usuario u3 = new Usuario();
		Usuario u4 = new Usuario();
		u1.setNombreUsuario("jsoe nantes");
		u1.setRol(1);

		u2.setNombreUsuario("kratos nantes");
		u2.setRol(0);

		u3.setNombreUsuario("natalia nantes");
		u3.setRol(2);

		u4.setNombreUsuario("luis nantes");
		u4.setRol(1);

		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		usuarios.add(u4);
		return usuarios;
	}

	
	
	public void testConexionDB() {
		String query = "SELECT * FROM `Usuario`;";

		try {
			conexion = conn.GetConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("NombreUsuario"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
	}
	
	
	
	
	
	
	
}
