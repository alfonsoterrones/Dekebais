package BorrarComponente;

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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeguroBorrar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SeguroBorrar(String componente) {
		metodoSeguroBorrar(componente);
	}

	public void metodoSeguroBorrar(String componente) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);

		JLabel lblseguroQueDeseas = new JLabel("\u00BFSeguro que deseas eliminar a " + componente + " ?");

		JButton btnSi = new JButton("Si");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSi.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Cargarrrrr
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
							"select NOMBREEMPLE,APELLIDOPRIMERO, APELLIDOSEGUNDO from COMPONENTE order by NOMBREEMPLE");

					while (rset.next()) {
						if ((rset.getString("NOMBREEMPLE") + " " + rset.getString("APELLIDOPRIMERO") + " "
								+ rset.getString("APELLIDOSEGUNDO")).equals(componente)) {
							String Consulta = "delete from COMPONENTE where NOMBREEMPLE='"
									+ rset.getString("NOMBREEMPLE") + "' and APELLIDOPRIMERO='"
									+ rset.getString("APELLIDOPRIMERO") + "'";
							System.out.println(Consulta);

							stm.executeQuery(Consulta);

							setVisible(false);
							JOptionPane.showMessageDialog(null, "" + componente + " a tomar por culo!!", "Aviso", 1);

						}

					}

					stm.close();

				} catch (Exception z) {
					System.out.println("Excepción:" + z);
				}
				// -------------------------------------------------------
			}
		});

		JButton btnNo = new JButton("No");
		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addContainerGap(93, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnSi, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNo, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblseguroQueDeseas)).addGap(73)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(42).addComponent(lblseguroQueDeseas)
						.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE).addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(btnNo).addComponent(btnSi))
						.addGap(29)));
		contentPane.setLayout(gl_contentPane);
	}

}
