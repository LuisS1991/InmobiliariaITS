package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import conexion.Conexion;
import modelo.Habitable;
import modelo.Inmueble;
import modelo.Terreno;
import modelo.Cliente;

public class RepositorioInmo {
	private Conexion conn;
	private Connection conexion;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;

	public RepositorioInmo() {
		conn = new Conexion();
	}

	public ArrayList<Habitable> TodosHabitables() {
		ArrayList<Habitable> hab = new ArrayList<Habitable>();
		Habitable terr = null;
		// String query = "SELECT i.`NroPadron`, i.`calle`, i.`nroPuerta`,
		// i.`departamento`, i.`valor`, i.`tamano`, i.`cliente`,t.servicios FROM
		// `Inmueble` i INNER JOIN `Terreno` t on t.NroPadron = i.NroPadron";
		String query = "SELECT i.`NroPadron`, i.`calle`, i.`nroPuerta`, i.`departamento`, i.`valor`, i.`tamanio`,i.cliente,h.`CantCuarto`, h.`CantBano`, h.`OtrosHabitaciones`, h.`comodidades`, h.`tipo`"
				+ "FROM `Inmueble` i  INNER JOIN `Habitable` h on h.NroPadron = i.NroPadron;";
		try {
			conexion = conn.GetConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				terr = new Habitable();
				terr.setNroPadron(Integer.parseInt(rs.getString("NroPadron")));
				terr.setCalle(rs.getString("calle"));
				terr.setNroPuerta(Integer.parseInt(rs.getString("NroPadron")));
				terr.setDepartamento(rs.getString("departamento"));
				terr.setValor(Double.parseDouble(rs.getString("valor")));
				terr.setTamanio(Double.parseDouble(rs.getString("tamanio")));
				Cliente cli = new Cliente();
				cli.setCI(Integer.parseInt(rs.getString("cliente")));
				terr.setCliente(cli);
				terr.setCantidad_Banos(Integer.parseInt(rs.getString("CantBano")));
				terr.setCantidad_Cuartos(Integer.parseInt(rs.getString("CantCuarto")));
				terr.setOtrasHabitaciones(Integer.parseInt(rs.getString("OtrosHabitaciones")));
				terr.setComodidades(rs.getString("comodidades"));
				terr.setTipo(rs.getString("tipo"));
				hab.add(terr);
			}
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}

		return hab;
	}

	public ArrayList<Terreno> TodosTerrenos() {
		ArrayList<Terreno> terrenos = new ArrayList<Terreno>();
		Terreno terr = null;
		String query = "SELECT i.`NroPadron`, i.`calle`, i.`nroPuerta`, i.`departamento`, i.`valor`, i.`tamanio`,i.cliente,t.servicios"
				+ " FROM `Inmueble` i INNER JOIN `Terreno` t on t.NroPadron = i.NroPadron;";

		try {
			conexion = conn.GetConexion();
			st = conexion.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				terr = new Terreno();
				terr.setNroPadron(Integer.parseInt(rs.getString("NroPadron")));
				terr.setCalle(rs.getString("calle"));
				terr.setNroPuerta(Integer.parseInt(rs.getString("nroPuerta")));
				terr.setDepartamento(rs.getString("departamento"));
				terr.setValor(Double.parseDouble(rs.getString("valor")));
				terr.setTamanio(Double.parseDouble(rs.getString("tamanio")));
				terr.setServicios(rs.getString("servicios"));
				Cliente cli = new Cliente();
				cli.setCI(Integer.parseInt(rs.getString("cliente")));
				terr.setCliente(cli);
				terrenos.add(terr);
			}
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
		return terrenos;
	}

	public boolean GuardarTerreno(Terreno terreno) {

		String queryInmo = "INSERT INTO `Inmueble`(`NroPadron`, `calle`, `nroPuerta`, `departamento`, `valor`, `tamanio`, `cliente`)"
				+ "VALUES (" + terreno.getNroPadron() + ",'" + terreno.getCalle() + "'," + terreno.getNroPuerta() + ",'"
				+ terreno.getDepartamento() + "'," + terreno.getValor() + "," + terreno.getTamanio() + ","
				+ terreno.getCliente().getCI() + ");";
		String queryTerreno = "INSERT INTO `Terreno`(`NroPadron`, `servicios`) VALUES (" + terreno.getNroPadron() + ",'"
				+ terreno.getServicios() + "');";

		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement(queryInmo);
			if (ps.executeUpdate() > 0) {
				ps = conexion.prepareStatement(queryTerreno);
				ps.executeUpdate();
			}
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
		return false;
	}// fin

	public boolean GuardarHabitable(Habitable habitable) {
		String queryInmo = "INSERT INTO `Inmueble`(`NroPadron`, `calle`, `nroPuerta`, `departamento`, `valor`, `tamanio`, `cliente`)"
				+ "VALUES (" + habitable.getNroPadron() + ",'" + habitable.getCalle() + "'," + habitable.getNroPuerta()
				+ ",'" + habitable.getDepartamento() + "'," + habitable.getValor() + "," + habitable.getTamanio() + ","
				+ habitable.getCliente().getCI() + ");";
		String queryTerreno = "INSERT INTO `Habitable`(`NroPadron`, `CantCuarto`, `CantBano`, `OtrosHabitaciones`, `comodidades`, `tipo`)"
				+ "VALUES (" + habitable.getNroPadron() + "," + habitable.getCantidad_Cuartos() + ","
				+ habitable.getCantidad_Banos() + "," + habitable.getOtrasHabitaciones() + ",'"
				+ habitable.getComodidades() + "','" + habitable.getTipo() + "')";

		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement(queryInmo);
			if (ps.executeUpdate() > 0) {
				ps = conexion.prepareStatement(queryTerreno);
				ps.executeUpdate();
			}
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
		return false;
	}// fin

	public boolean EditarInmueble(Inmueble inmo) {
		String query = "";
		String queryInmo = "UPDATE `inmueble` SET `calle`='" + inmo.getCalle() + "', `nroPuerta`=" + inmo.getNroPuerta()
				+ ",`valor` =" + inmo.getValor() + ",`tamanio`=" + inmo.getTamanio() + ",`departamento`='"
				+ inmo.getDepartamento() + "'" + ",`cliente`=" + inmo.getCliente().getCI() + " WHERE `NroPadron`="
				+ inmo.getNroPadron() + ";";

		if (inmo.getClass().toString().equals("class modelo.Terreno")) {
			Terreno terr = (Terreno) inmo;
			query = "UPDATE `terreno` SET  `servicios`='" + terr.getServicios() + "' WHERE `NroPadron`="
					+ inmo.getNroPadron() + ";";
		} else {
			Habitable hab = (Habitable) inmo;
			query = "UPDATE  `habitable` SET `CantCuarto` =" + hab.getCantidad_Cuartos() + ", `CantBano`="
					+ hab.getCantidad_Banos() + ",`OtrosHabitaciones`=" + hab.getOtrasHabitaciones()
					+ ",`comodidades` ='" + hab.getComodidades() + "', `tipo` ='" + hab.getTipo()
					+ "' WHERE `NroPadron`=" + inmo.getNroPadron() + ";";
		}

		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement(queryInmo);
			if (ps.executeUpdate() > 0) {
				ps = conexion.prepareStatement(query);
				ps.executeUpdate();
			}
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
		return false;
	}

	public boolean ElimnarInmo(int NroPadron) {

		try {
			conexion = conn.GetConexion();
			ps = conexion.prepareStatement("DELETE FROM  `terreno` WHERE  `NroPadron` ="+NroPadron+";");
			if (ps.executeUpdate() < 0) {
				ps = conexion.prepareStatement("DELETE FROM `habitable WHERE  `NroPadron` ="+NroPadron+";");
				ps.executeUpdate();
			}
			ps = conexion.prepareStatement("DELETE FROM `inmobiliariaits`.`inmueble` WHERE `NroPadron` = "+NroPadron+";");
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.CerrarConexion();
		}
		return false;

	}

}// fin
