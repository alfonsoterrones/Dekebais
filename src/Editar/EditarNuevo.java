package Editar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ExcelListado.ExcelListado2;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class EditarNuevo extends JFrame {
String consulta;
	private JPanel contentPane;

	public EditarNuevo(String componente) {
		super("¿Nuevo?");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 432, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblestaEsteAo = new JLabel("¿Es nuevo en la comparsa?");
		
		JRadioButton si = new JRadioButton("Si");
		
		JRadioButton no = new JRadioButton("No");
		
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
					 String usuario="DAW1", password="DAW1";
					 //Introducir valores al objeto OracleDataSource
					 ds.setURL(BaseDeDatos);
					 ds.setUser(usuario);
					 ds.setPassword(password);
					 // Establecer la conexión
					 Connection conexion = ds.getConnection();
					 //Comprobar si se ha producido la conexión
					 
					 Class.forName("oracle.jdbc.OracleDriver");
					 
					
					 Statement stm=conexion.createStatement();
					 ResultSet rset=stm.executeQuery("select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO, MAIL,FECHNACIMIENTO ,SALDO, AMIGO	,TELEFONO, CUERPO,	EDAD, MODISTA,COMPONENTE, NUEVO from COMPONENTE order by NOMBREEMPLE");
					
					 while (rset.next()){
							if( (rset.getString ("NOMBREEMPLE")+" "+rset.getString ("APELLIDOPRIMERO")).equals(componente)){
								if(si.getSelectedObjects()!=null){
									consulta="UPDATE COMPONENTE SET NUEVO='Si' WHERE NOMBREEMPLE='"+rset.getString("NOMBREEMPLE")+"' AND APELLIDOPRIMERO='"+rset.getString("APELLIDOPRIMERO")+"' AND APELLIDOSEGUNDO='"+rset.getString("APELLIDOSEGUNDO")+"'";
					                stm.executeUpdate(consulta);
					                setVisible(false);
								}else{
									if(no.getSelectedObjects()!=null){
										consulta="UPDATE COMPONENTE SET NUEVO='No' WHERE NOMBREEMPLE='"+rset.getString("NOMBREEMPLE")+"' AND APELLIDOPRIMERO='"+rset.getString("APELLIDOPRIMERO")+"' AND APELLIDOSEGUNDO='"+rset.getString("APELLIDOSEGUNDO")+"'";
						                stm.executeUpdate(consulta);
						                setVisible(false);
						                JOptionPane.showMessageDialog(null, "Si todos son nuevos todos pagaran 10 euritos mas piensalo...", "Aviso",1);

									}

									
								}
							}

						 
					 }
					
						 
					 stm.close();

					 } catch (Exception x) {
					 System.out.println("Excepción:"+e);
					 }
				 //CONEXION------------------------------------------
				 //CONEXION--------------------------------------------
				
				
				
				
				
				
			}
		});
		
		
		
		 
		setVisible(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(lblestaEsteAo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(109)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAceptar)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(si)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(no)))))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblestaEsteAo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(si)
						.addComponent(no))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAceptar)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	
}
