package Pagos;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Principal.Fondo;
import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaPagos extends JFrame {
	String nombreapellido;

	String componente;
	private Fondo contentPane;

	public ListaPagos() {
		super("Componentes");
		setSize(550, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600, 400);

		// FlowLayout dis=new FlowLayout();
		// getContentPane().setLayout(dis);

		contentPane = new Fondo("dinero.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JComboBox cursos = new JComboBox();
		cursos.setMaximumRowCount(30);

		// -----------------------------SELECCIONAR COMPONENTE--------------------------
		cursos.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Seleccionar" + cursos.getSelectedItem());
				componente = (String) cursos.getSelectedItem();

				/// STRING DIVIDIR
				String nombre = "";
				String apellido = "";
				String delimiter = " ";
				String[] temp;
				temp = componente.split(delimiter);
				for (int i = 0; i < temp.length; i++) {
					if (i == 0) {
						nombre = temp[i];
					} else {
						apellido = temp[i];
					}
					// System.out.println(temp[i]);
					System.err.println(nombre);
					System.err.println(apellido);
				}

				CuantoAPagado p = new CuantoAPagado(nombre, apellido);
			}
		});

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
			ResultSet rset = stm.executeQuery("select NOMBREEMPLE,APELLIDOPRIMERO from COMPONENTE");

			cursos.removeAllItems();
			while (rset.next()) {
				cursos.addItem(rset.getString(1) + " " + rset.getString(2));

			}
			getContentPane().add(cursos);

			stm.close();

		} catch (Exception e) {
			System.out.println("Excepción:" + e);
		}
		// CONEXION------------------------------------------
		// CONEXION--------------------------------------------
		setVisible(true);

	}

	public String MandarComponenteAMostrarDatosComponentes() {
		return componente;
	}

}
