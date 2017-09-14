package Modista;


import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import Principal.Fondo;
import Principal.MostrarDatos;
import java.awt.Font;

public class ListadoModista extends JFrame{
	String nombreapellido;
	String componente;

	private Fondo contentPane;
	private int total=0;
	
	
	
	public ListadoModista(){
		super("Listado de componentes co modista de la comparsa");
		setSize(665, 513);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600,400);
	
		contentPane = new Fondo("maquina_coser_4.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//FlowLayout dis=new FlowLayout();
		//getContentPane().setLayout(dis);
	
		JComboBox cursos = new JComboBox();
		cursos.setMaximumRowCount(2);
		
		//-----------------------------SELECCIONAR COMPONENTE--------------------------
		cursos.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Seleccionar"+cursos.getSelectedItem());
				componente=(String)cursos.getSelectedItem();
				MostrarDatos d=new MostrarDatos(componente);
				
			}
		});
		
		

		
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
			 ResultSet rset=stm.executeQuery("select NOMBREEMPLE,APELLIDOPRIMERO,MODISTA from COMPONENTE order by NOMBREEMPLE");
			 
			 cursos.removeAllItems();
			 while (rset.next()){
				 if(rset.getString("MODISTA").equals("Si")){
				 cursos.addItem(rset.getString(1)+" "+rset.getString(2));
				 total=total+1;
			 }
				 
				 
			 }
			 
			 JLabel lblLaModistaDe = new JLabel("La modista de la comparsa lleva a "+total+" personas");
			 lblLaModistaDe.setFont(new Font("Tahoma", Font.PLAIN, 17));
			 lblLaModistaDe.setForeground(Color.WHITE);
			 
			 
			 GroupLayout gl_contentPane = new GroupLayout(contentPane);
			 gl_contentPane.setHorizontalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addGap(201)
			 					.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addGap(162)
			 					.addComponent(lblLaModistaDe)))
			 			.addContainerGap(218, Short.MAX_VALUE))
			 );
			 gl_contentPane.setVerticalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addContainerGap()
			 			.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			 			.addPreferredGap(ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
			 			.addComponent(lblLaModistaDe)
			 			.addGap(49))
			 );
			 contentPane.setLayout(gl_contentPane);
				 
			 stm.close();

			 } catch (Exception e) {
			 System.out.println("Excepción:"+e);
			 }
		 //CONEXION------------------------------------------
		 //CONEXION--------------------------------------------
		setVisible(true);
		
	}
}