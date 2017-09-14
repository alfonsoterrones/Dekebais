package crearFichero;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ExcelListado.ExcelListado2;
import Principal.Fondo;
import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManejoDeArchivosDatosPersonales extends JFrame {
	String nombreapellido;
	String componente;
	FileWriter fichero = null;
	PrintWriter pw = null;

	public ManejoDeArchivosDatosPersonales(String nombre, String apellido1, String apellido2) {

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
			// Comprobar si se ha producido la conexión

			Class.forName("oracle.jdbc.OracleDriver");

			Statement stm = conexion.createStatement();
			ResultSet rset = stm.executeQuery(
					"select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO, MAIL,FECHNACIMIENTO ,SALDO, AMIGO	,TELEFONO, CUERPO,	EDAD, MODISTA,COMPONENTE, NUEVO from COMPONENTE order by NOMBREEMPLE");

			while (rset.next()) {
				if (rset.getString(1).equals(nombre) && rset.getString(2).equals(apellido1)
						&& rset.getString(3).equals(apellido2))

					try {
						fichero = new FileWriter("Datos" + rset.getString(1) + ".txt");
						pw = new PrintWriter(fichero);
						Calendar cal = Calendar.getInstance();
						int mes = cal.get(Calendar.MONTH) + 1;
						// for (int i = 0; i < 10; i++)
						// pw.println("Linea " + i);
						pw.println("Nombre del componente:\t" + rset.getString(1) + " " + rset.getString(2) + " "
								+ rset.getString(3));
						pw.println("Mail:\t\t\t" + rset.getString(4));
						pw.println("Fecha de Nacimiento:\t" + rset.getString(5));
						pw.println("Lleva pagado :\t\t" + rset.getString(6) + " €");
						pw.println("Su amigo es:\t\t" + rset.getString(7));
						pw.println("Teléfono:\t\t" + rset.getString(8));
						pw.println("Cuerpo de:\t\t" + rset.getString(9));
						pw.println("Edad:\t\t\t" + rset.getString(10));
						pw.println("Utiliza Modista:\t" + rset.getString(11));
						pw.println("Se disfraza este año:\t" + rset.getString(12));
						pw.println("Es nuevo:\t\t" + rset.getString(13));

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							// Nuevamente aprovechamos el finally para
							// asegurarnos que se cierra el fichero.
							if (null != fichero)
								fichero.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}

			}

			stm.close();

		} catch (Exception e) {
			System.out.println("Excepción:" + e);
		}
		// CONEXION------------------------------------------
		// CONEXION--------------------------------------------

	}
}