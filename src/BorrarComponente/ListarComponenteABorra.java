package BorrarComponente;


import java.awt.FlowLayout;
import Principal.Fondo;
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

public class ListarComponenteABorra extends JFrame{
	String nombreapellido;
	String componente;
	
	private Fondo contentPane;


	
	public ListarComponenteABorra(){

		super("Borrar Componente");
		
		setSize(550, 444);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600,400);
	
		//FlowLayout dis=new FlowLayout();
		//getContentPane().setLayout(dis);
	
		contentPane = new Fondo("tazasborrar.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox cursos = new JComboBox();
		cursos.setLocation(100, 100);
		cursos.setMaximumRowCount(30);

		
		//-----------------------------SELECCIONAR COMPONENTE--------------------------
		cursos.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Seleccionar"+cursos.getSelectedItem());
				componente=(String)cursos.getSelectedItem();
				System.out.println("Fallo1");
				SeguroBorrar s=new SeguroBorrar(componente);
				//BorrarComponente d=new BorrarComponente(componente);
				
				setVisible(false);

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
			 ResultSet rset=stm.executeQuery("select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO from COMPONENTE order by NOMBREEMPLE");
			 
			 cursos.removeAllItems();
			 while (rset.next()){
				 cursos.addItem(rset.getString(1)+" "+rset.getString(2)+" "+rset.getString(3));
				 
			 }
			 GroupLayout gl_contentPane = new GroupLayout(contentPane);
			 gl_contentPane.setHorizontalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGap(212)
			 			.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			 			.addContainerGap(279, Short.MAX_VALUE))
			 );
			 gl_contentPane.setVerticalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGap(26)
			 			.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			 			.addContainerGap(295, Short.MAX_VALUE))
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