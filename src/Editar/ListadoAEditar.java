package Editar;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ExcelListado.ExcelListado2;
import Principal.Fondo;
import crearFichero.ManejoDeArchivosDatosPersonales;
import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoAEditar extends JFrame {
	String nombreapellido;
	String componente;

	private Fondo contentPane;
	private float total = 0;
	private float anos = 0;
	private float media = 0;

	public ListadoAEditar() {
		super("Componentes");
		setSize(568, 513);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600, 400);

		contentPane = new Fondo("rana.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// FlowLayout dis=new FlowLayout();
		// getContentPane().setLayout(dis);

		JComboBox cursos = new JComboBox();
		cursos.setMaximumRowCount(30);

		// -----------------------------SELECCIONAR COMPONENTE--------------------------
		cursos.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Seleccionar" + cursos.getSelectedItem());
				componente = (String) cursos.getSelectedItem();
				ElegirQueEditar edit = new ElegirQueEditar(componente);

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
			// Establecer la conexi�n
			Connection conexion = ds.getConnection();
			// Comprobar si se ha producido la conexi�n

			Class.forName("oracle.jdbc.OracleDriver");

			Statement stm = conexion.createStatement();
			ResultSet rset = stm.executeQuery(
					"select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO, MAIL,FECHNACIMIENTO ,SALDO, AMIGO	,TELEFONO, CUERPO,	EDAD, MODISTA,COMPONENTE, NUEVO from COMPONENTE order by NOMBREEMPLE");

			cursos.removeAllItems();

			while (rset.next()) {
				cursos.addItem(rset.getString(1) + " " + rset.getString(2));
				total = total + 1;
				anos = anos + rset.getInt("EDAD");

			}
			media = anos / total;
			System.out.println("total anoss" + anos);
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane
					.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup().addGap(201).addComponent(cursos,
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(308, Short.MAX_VALUE)));
			gl_contentPane
					.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(cursos,
									GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(421, Short.MAX_VALUE)));
			contentPane.setLayout(gl_contentPane);

			stm.close();

		} catch (Exception e) {
			System.out.println("Excepci�n:" + e);
		}
		// CONEXION------------------------------------------
		// CONEXION--------------------------------------------
		setVisible(true);

	}

}