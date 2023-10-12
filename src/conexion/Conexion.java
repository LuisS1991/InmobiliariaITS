package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ANTES DE ENTREGAR EL PROYECTO CORROBORAR QUE FUNCIONA EN LA BASE DE DATOS DE LA UTU
 * 
 * */
public class Conexion {

	private String usuario = "root";
	private String pass = "";
	private String db = "inmobiliariaITS";
	// private String url = "jdbc:mysql:localhost:3306/" + db;
	private String urlDebug = "jdbc:mariadb://localhost:3306/" + db;
	private Connection conxion = null;

	public Connection GetConexion() {
		if(conxion !=null) {
			return conxion;
		}else {
			try {
				// Registramos el driver de MySQL (MariaDB)
				/*
				 * no olvidar cambiar al presentar el proyecto sino no funciona
				 * 
				 */
				try {
					// Class.forName("com.mysql.jdbc.Driver");
					Class.forName("org.mariadb.jdbc.Driver");
				} catch (ClassNotFoundException ex) {
					System.out.println("Error al registrar el driver de MySQL: " + ex);
				}
				conxion = DriverManager.getConnection(urlDebug, usuario, pass);

				return conxion;

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
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
