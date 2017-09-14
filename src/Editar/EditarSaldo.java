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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditarSaldo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	String consulta;
	private JLabel lblEliminaTodosLos;

	public EditarSaldo(String componente) {
		super("Editar pago de " + componente);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);

		JLabel lblCuantoDineroLleva = new JLabel("Cuanto dinero lleva pagado " + componente);

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
					boolean semaforo = true;
					while (rset.next()) {
						if ((rset.getString("NOMBREEMPLE") + " " + rset.getString("APELLIDOPRIMERO"))
								.equals(componente)) {
							consulta = "UPDATE COMPONENTE SET SALDO=" + textField.getText() + " WHERE NOMBREEMPLE='"
									+ rset.getString("NOMBREEMPLE") + "' AND APELLIDOPRIMERO='"
									+ rset.getString("APELLIDOPRIMERO") + "' AND APELLIDOSEGUNDO='"
									+ rset.getString("APELLIDOSEGUNDO") + "'";
							stm.executeUpdate(consulta);
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Le has añadido el dinero a Alfonso Terrones!!",
									"Aviso", 1);

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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		lblEliminaTodosLos = new JLabel("Elimina todos los pagos de " + componente
				+ " que haya pagado para que tenga que pagar todo de nuevo xD");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(200, Short.MAX_VALUE)
								.addComponent(lblEliminaTodosLos).addGap(166))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblCuantoDineroLleva)
						.addGap(111)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnAceptar)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(108, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(75)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCuantoDineroLleva).addComponent(textField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnAceptar)
						.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
						.addComponent(lblEliminaTodosLos).addGap(31)));
		contentPane.setLayout(gl_contentPane);
	}
}
