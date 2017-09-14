package Morosos;

import java.awt.FlowLayout;
import Principal.Fondo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeSet;
import Principal.MostrarDatos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ExcelListado.ExcelMorososSegundoPago;
import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuotaDos extends JFrame {
	String nombreapellido;
	String componente;
	private Fondo contentPane;

	public CuotaDos() {
		super("Componentes que faltan por pagar el segundo pago");
		setSize(553, 434);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600, 400);
		contentPane = new Fondo("morosos2.jpg");
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
				MostrarDatos d = new MostrarDatos(componente);

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
			ResultSet rset = stm.executeQuery(
					"select NOMBREEMPLE, APELLIDOPRIMERO, SALDO, NUEVO, EDAD from COMPONENTE order by NOMBREEMPLE");

			cursos.removeAllItems();
			while (rset.next()) {
				if (rset.getInt("SALDO") < 40 && rset.getInt("EDAD") > 11 || (rset.getInt("EDAD") < 12
						&& rset.getString("NUEVO").equals("No") && rset.getInt("SALDO") < 50)) {
					cursos.addItem(rset.getString(1) + " " + rset.getString(2));
				}

			}

			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					ExcelMorososSegundoPago seg = new ExcelMorososSegundoPago();
				}
			});
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup().addGap(125)
							.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(369, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(416, Short.MAX_VALUE).addComponent(btnImprimir).addContainerGap()));
			gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
							.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 304, Short.MAX_VALUE).addComponent(btnImprimir)
							.addContainerGap()));
			contentPane.setLayout(gl_contentPane);

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