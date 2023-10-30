package repositorio;

import java.util.ArrayList;
import modelo.Usuario;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioUsuarios {
	private Conexion conn;
	private ArrayList<Usuario> usuarios;
	private Connection conexion;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;

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
		Usuario usu = null;
		String query = "SELECT * FROM `Usuario`;";

		try {
			conexion = conn.GetConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				usu = new Usuario();
				usu.setNombreUsuario(rs.getString("NombreUsuario"));
				usu.setPass(rs.getString("PassUsuario"));
				usu.setRol(Integer.parseInt(rs.getString("RolUsuario")));
				usuarios.add(usu);
			}
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}

		return usuarios;
	}

	public boolean AgregarUsuario(Usuario usu) {

		String query = "INSERT INTO `Usuario`(`NombreUsuario`, `PassUsuario`, `RolUsuario`) VALUES (?,?,?);";
		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement(query);
			ps.setString(1, usu.getNombreUsuario());
			ps.setString(2, usu.getPass());
			ps.setInt(3, usu.getRol());
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

}
