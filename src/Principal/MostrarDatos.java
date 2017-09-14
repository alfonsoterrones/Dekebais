package Principal;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import oracle.jdbc.pool.OracleDataSource;

import javax.swing.JTextArea;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import crearFichero.ManejoDeArchivosDatosPersonales;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MostrarDatos extends JFrame {
	String datosAMostrar;
	String nombre;
	String apellido1;
	String apellido2;

	public MostrarDatos(String s) {
		super("Datos del componente " + s);
		setSize(551, 463);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600, 400);

		TextArea textArea = new TextArea();

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
					"select NOMBREEMPLE,APELLIDOPRIMERO, APELLIDOSEGUNDO, MAIL,TELEFONO ,FECHNACIMIENTO ,SALDO, AMIGO ,CUERPO, NUEVO ,EDAD, MODISTA,COMPONENTE from COMPONENTE");

			// -------------------comparamos el nombre para que nos muestre los
			// datos---------------------
			while (rset.next()) {

				if ((rset.getString("NOMBREEMPLE") + " " + rset.getString("APELLIDOPRIMERO")).equals(s)) {
					datosAMostrar = "Nombre\t" + rset.getString("NOMBREEMPLE") + "\nApellido1:\t"
							+ rset.getString("APELLIDOPRIMERO") + "\nApellido2:\t" + rset.getString("APELLIDOSEGUNDO")
							+ "\nMail:\t" + rset.getString("MAIL") + "\nTelefono:\t" + rset.getInt("TELEFONO")
							+ "\nNac:\t" + rset.getString("FECHNACIMIENTO").substring(0, 10) + "\nSaldo:\t"
							+ rset.getFloat("SALDO") + "\nCuerpo:\t" + rset.getString("CUERPO") + "\nAmigo:\t"
							+ rset.getString("AMIGO") + "\nTiene:\t" + rset.getInt("EDAD") + " años"
							+ "\nModista de la comparsa:\t" + rset.getString("MODISTA")
							+ "\nEsta en la comparsa este año:\t" + rset.getString("COMPONENTE") + "\nNuevo:\t"
							+ rset.getString("NUEVO");
					nombre = rset.getString("NOMBREEMPLE");
					apellido1 = rset.getString("APELLIDOPRIMERO");
					apellido2 = rset.getString("APELLIDOSEGUNDO");

				}
			}

			stm.close();

		} catch (Exception e) {
			System.out.println("Excepción:" + e);
		}
		// CONEXION------------------------------------------
		// CONEXION--------------------------------------------
		setVisible(true);

		textArea.setText(datosAMostrar);

		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ManejoDeArchivosDatosPersonales pers = new ManejoDeArchivosDatosPersonales(nombre, apellido1,
						apellido2);
				JOptionPane.showMessageDialog(null, "Se creo un txt con los datos de " + nombre, "Aviso", 1);

			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(46)
										.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 448,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(39, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addContainerGap(424, Short.MAX_VALUE)
												.addComponent(btnImprimir).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE).addComponent(btnImprimir)
						.addContainerGap()));
		getContentPane().setLayout(groupLayout);

		setVisible(true);
	}
}