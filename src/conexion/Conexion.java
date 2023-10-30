package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import utiles.CargarConfiguracion;

/*
 * ANTES DE ENTREGAR EL PROYECTO CORROBORAR QUE FUNCIONA EN LA BASE DE DATOS DE LA UTU
 * CAMBIAR CONFIGURACION DEL ARCHIVO DE ARRANQUE
 * */
/*
 * private String usuario = ""; private String pass = ""; private String db =
 * "db"; private String url = ""; private String driver =
 * "com.mysql.cj.jdbc.Driver";
 */

public class Conexion {

	private Connection conxion = null;
	private HashMap<String, String> config;

	public Conexion() {
		config = CargarConfiguracion.LoadConfigDataBase();
	}

	public Connection GetConexion() {
		try {
			try {
				Class.forName(config.get("JAVA_DRIVER"));
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de MySQL: " + ex);
			}

			conxion = DriverManager.getConnection(
					config.get("JAVA_URL_MYSQL") + config.get("JAVA_DB") + config.get("JAVA_CONFIG_TIME_ZONE"),
					config.get("JAVA_USER"), config.get("JAVA_PASS"));

			return conxion;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void CerrarConexion() {
		try {
			conxion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
