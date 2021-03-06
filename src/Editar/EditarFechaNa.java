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
import javax.swing.JOptionPane;
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

public class EditarFechaNa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	String consulta;
	private JLabel lblEjemploDdmmaaaa;

	public EditarFechaNa(String componente) {
		super("Editar la fecha de nacimiento de " + componente);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 495, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCambiarElNombre = new JLabel("Cambiar el fecha de nacimiento de " + componente);

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
					// Establecer la conexi�n
					Connection conexion = ds.getConnection();
					// Comprobar si se ha producido la conexi�n

					Class.forName("oracle.jdbc.OracleDriver");

					Statement stm = conexion.createStatement();
					ResultSet rset = stm.executeQuery(
							"select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO, MAIL,FECHNACIMIENTO ,SALDO, AMIGO	,TELEFONO, CUERPO,	EDAD, MODISTA,COMPONENTE, NUEVO from COMPONENTE order by NOMBREEMPLE");

					while (rset.next()) {
						if ((rset.getString("NOMBREEMPLE") + " " + rset.getString("APELLIDOPRIMERO"))
								.equals(componente)) {
							consulta = "UPDATE COMPONENTE SET FECHNACIMIENTO='" + textField.getText()
									+ "' WHERE NOMBREEMPLE='" + rset.getString("NOMBREEMPLE")
									+ "' AND APELLIDOPRIMERO='" + rset.getString("APELLIDOPRIMERO")
									+ "' AND APELLIDOSEGUNDO='" + rset.getString("APELLIDOSEGUNDO") + "'";
							stm.executeUpdate(consulta);
							setVisible(false);
							JOptionPane.showMessageDialog(null,
									"Mmm.. Si la fecha de nacimiento es despues de a\u00F1o 2001\ntendremos el infantil con mayor n�mero de componentes del Carnaval!!",
									"Aviso", 1);

						}
					}

					stm.close();

				} catch (Exception x) {
					System.out.println("Excepci�n:" + e);
				}
				// CONEXION------------------------------------------
				// CONEXION--------------------------------------------
			}
		});

		lblEjemploDdmmaaaa = new JLabel("Ejemplo dd-mm-aaaa");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblEjemploDdmmaaaa))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblCambiarElNombre)
								.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnAceptar)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(56).addComponent(lblEjemploDdmmaaaa)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCambiarElNombre).addComponent(textField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAceptar)
						.addContainerGap(110, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}