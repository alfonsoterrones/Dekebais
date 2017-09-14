package Editar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.pool.OracleDataSource;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarApellidoUno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	String consulta;

	public EditarApellidoUno(String componente) {
		super("Editar el apellido de " + componente);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCambiarElNombre = new JLabel("Cambiar el primer apellido de " + componente);

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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
						if ((rset.getString("NOMBREEMPLE") + " " + rset.getString("APELLIDOPRIMERO"))
								.equals(componente)) {
							consulta = "UPDATE COMPONENTE SET APELLIDOPRIMERO='" + textField.getText()
									+ "' WHERE NOMBREEMPLE='" + rset.getString("NOMBREEMPLE")
									+ "' AND APELLIDOPRIMERO='" + rset.getString("APELLIDOPRIMERO")
									+ "' AND APELLIDOSEGUNDO='" + rset.getString("APELLIDOSEGUNDO") + "'";
							stm.executeUpdate(consulta);
							setVisible(false);

						}
					}

					stm.close();

				} catch (Exception x) {
					System.out.println("Excepción:" + e);
				}
				// CONEXION------------------------------------------
				// CONEXION--------------------------------------------
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblCambiarElNombre)
						.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(45))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(147).addComponent(btnAceptar)
						.addContainerGap(178, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(79)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCambiarElNombre).addComponent(textField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnAceptar).addContainerGap(99, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}