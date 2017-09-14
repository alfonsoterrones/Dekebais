package Pagos;

import java.sql.*;

import javax.swing.JOptionPane;

import crearFichero.ManejoDeArchivos;
import crearFichero.crearFichero;
import oracle.jdbc.pool.OracleDataSource;

public class InsertarPago {

	public InsertarPago(String nombre, String apellido, Float pago, String quePago) {

		try {
			OracleDataSource ds = new OracleDataSource();
			// Cargar el driver de Oracle
			Class.forName("oracle.jdbc.OracleDriver");
			// url de la base de datos a la que vaamos a conectar
			String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
			String usuario = "DAW1", password = "DAW1";
			// Introducir valores al objeto OracleDataSource
			ds.setURL(BaseDeDatos);
			ds.setUser(usuario);
			ds.setPassword(password);
			// Establecer la conexión
			Connection conexion = ds.getConnection();

			Class.forName("oracle.jdbc.OracleDriver");

			float saldoFinal = 0f;

			Statement stm = conexion.createStatement();

			ResultSet rset = stm.executeQuery(
					"select NOMBREEMPLE, APELLIDOPRIMERO, APELLIDOSEGUNDO, MAIL, FECHNACIMIENTO, SALDO, AMIGO,NUEVO from DAW1.COMPONENTE");
			System.out.println("Estamos aquiiiiiiiiiiiii");

			while (rset.next()) {
				System.out.println("Estamos dentro del bucle");
				System.out.println(rset.getString("NOMBREEMPLE") + "" + nombre);
				System.out.println(rset.getString("APELLIDOPRIMERO") + "" + apellido);

				if ((rset.getString("NOMBREEMPLE").equals(nombre) || rset.getString("NOMBREEMPLE").equals(nombre + " "))
						&& (rset.getString("APELLIDOPRIMERO").equals(apellido + " ")
								|| rset.getString("APELLIDOPRIMERO").equals(apellido))) {

					// System.out.println(nombre);
					// System.out.println(apellido);
					saldoFinal = rset.getFloat("SALDO");
					// System.out.println("El saldo antes era.."+saldoFinal);
					saldoFinal = saldoFinal + pago;
					System.out.println("El pago era.." + pago + " y el saldo pasa a.." + saldoFinal);
					// JOptionPane.showMessageDialog(null,
					// "Nombre"+nombre+"nombre"+rset.getString("NOMBREEMPLE")+"el if
					// Apellido"+apellido+"apellido"+rset.getString("APELLIDOPRIMERO")+"el if",
					// "Aviso",1);
					String saldoFinalString = String.valueOf(saldoFinal);
					String consulta = "update componente set saldo=" + saldoFinalString + " where nombreemple='"
							+ nombre + "' and APELLIDOPRIMERO='" + apellido + "'";
					stm.executeUpdate(consulta);
				}

			}

			// crear recibo---------------------
			// crearFichero archivo=new crearFichero();
			// archivo.crearFichero(nombre, apellido,pago);
			ManejoDeArchivos m = new ManejoDeArchivos();

			String pagado = String.valueOf(pago);
			m.crearRecibo(nombre, apellido, pagado, quePago);

			// ----------------------------------

			stm.close();

		} catch (Exception e) {
			System.out.println("Excepción:" + e);
		}

	}

}