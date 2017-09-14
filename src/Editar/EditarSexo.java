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

public class EditarSexo extends JFrame {
String consulta;
	private JPanel contentPane;

	public EditarSexo(String componente) {
		super("�Cambiamos de sexo?");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 375, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblestaEsteAo = new JLabel("�Hombre o Mujer?");
		
		JRadioButton mujer = new JRadioButton("Mujer");
		
		JRadioButton hombre = new JRadioButton("Hombre");
		
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
					 // Establecer la conexi�n
					 Connection conexion = ds.getConnection();
					 //Comprobar si se ha producido la conexi�n
					 
					 Class.forName("oracle.jdbc.OracleDriver");
					 
					
					 Statement stm=conexion.createStatement();
					 ResultSet rset=stm.executeQuery("select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO, MAIL,FECHNACIMIENTO ,SALDO, AMIGO	,TELEFONO, CUERPO,	EDAD, MODISTA,COMPONENTE, NUEVO from COMPONENTE order by NOMBREEMPLE");
					
					 while (rset.next()){
							if( (rset.getString ("NOMBREEMPLE")+" "+rset.getString ("APELLIDOPRIMERO")).equals(componente)){
								if(mujer.getSelectedObjects()!=null){
									consulta="UPDATE COMPONENTE SET SEXO='Mujer' WHERE NOMBREEMPLE='"+rset.getString("NOMBREEMPLE")+"' AND APELLIDOPRIMERO='"+rset.getString("APELLIDOPRIMERO")+"' AND APELLIDOSEGUNDO='"+rset.getString("APELLIDOSEGUNDO")+"'";
					                stm.executeUpdate(consulta);
					                setVisible(false);
					                JOptionPane.showMessageDialog(null, "Le has cortado la pilila!!", "Aviso",1);
								}else{
									if(hombre.getSelectedObjects()!=null){
										consulta="UPDATE COMPONENTE SET SEXO='Hombre' WHERE NOMBREEMPLE='"+rset.getString("NOMBREEMPLE")+"' AND APELLIDOPRIMERO='"+rset.getString("APELLIDOPRIMERO")+"' AND APELLIDOSEGUNDO='"+rset.getString("APELLIDOSEGUNDO")+"'";
						                stm.executeUpdate(consulta);
						                setVisible(false);
						                JOptionPane.showMessageDialog(null, "Le has quitado las tetitas!!", "Aviso",1);
									}

									
								}
							}

						 
					 }
					
						 
					 stm.close();

					 } catch (Exception x) {
					 System.out.println("Excepci�n:"+e);
					 }
				 //CONEXION------------------------------------------
				 //CONEXION--------------------------------------------
				
				
				
				
				
				
			}
		});
		
		
		
		 
		setVisible(true);
		
		JLabel lblSiemprePuedeSuceder = new JLabel("Siempre puede suceder que una persona cambie de sexo");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(btnAceptar)
					.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addComponent(mujer)
					.addGap(18)
					.addComponent(hombre)
					.addGap(118))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addComponent(lblestaEsteAo)
					.addContainerGap(161, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSiemprePuedeSuceder)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSiemprePuedeSuceder)
					.addGap(21)
					.addComponent(lblestaEsteAo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(mujer)
						.addComponent(hombre))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAceptar)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
	
	
}
