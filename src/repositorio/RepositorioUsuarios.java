package repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.ORM;
import modelo.Usuario;

public class RepositorioUsuarios extends Repositorio {

	private ORM dateBase;
	private ArrayList<Usuario> usuarios;

	public RepositorioUsuarios() {
		dateBase = new ORM();
	}

	public Usuario AutenticarUsuario(String cedula, String pass) {
		this.dateBase.Select("SELECT * FROM  `Usuario`  WHERE cedula='" + cedula + "' and PassUsuario =" + pass + " ;",
				this);
		this.dateBase.CerrarConexion();
		if (usuarios.size() > 0) {
			return usuarios.get(0);
		} else {
			return null;
		}
	}// fin

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
		this.dateBase.Select("SELECT * FROM  `Usuario`;", this);
		this.dateBase.CerrarConexion();
		return usuarios;
	}

	public boolean AgregarUsuario(Usuario usu) {
		String query = "INSERT INTO `Usuario`(`NombreUsuario`, `PassUsuario`, `RolUsuario`) VALUES ('"
				+ usu.getNombreUsuario() + "','" + usu.getPass() + "'," + usu.getRol() + ");";
		if (this.dateBase.Insert(query) > 0) {
			this.dateBase.CerrarConexion();
			return true;
		} else
			return false;
	}// fin

	@Override
	public void Listar(ResultSet rs) {
		usuarios = new ArrayList<Usuario>();
		Usuario usu = null;
		try {
			while (rs.next()) {
				usu = new Usuario();
				usu.setNombreUsuario(rs.getString("NombreUsuario"));
				usu.setPass(rs.getString("PassUsuario"));
				usu.setRol(Integer.parseInt(rs.getString("RolUsuario")));
				usuarios.add(usu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// fin

}
