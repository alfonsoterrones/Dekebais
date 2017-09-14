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

import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarMorosos extends JFrame{
	String nombreapellido;
	String componente;
	private Fondo contentPane;


	
	public ListarMorosos(){
		super("Componentes");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600,400);
		contentPane = new Fondo("sindinero.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		//FlowLayout dis=new FlowLayout();
		//getContentPane().setLayout(dis);
	
		JComboBox cursos = new JComboBox();
		cursos.setMaximumRowCount(30);

		
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
			 ResultSet rset=stm.executeQuery("select NOMBREEMPLE, APELLIDOPRIMERO, SALDO, NUEVO from COMPONENTE order by NOMBREEMPLE");
			 
			 cursos.removeAllItems();
			 while (rset.next()){
				 if((rset.getInt("SALDO")<100 && rset.getString("NUEVO").equals("No")) || (rset.getInt("SALDO")<106 && rset.getString("NUEVO").equals("Si"))){
					 cursos.addItem(rset.getString(1)+" "+rset.getString(2)); 
				 }
				 
				 
			 }
			 getContentPane().add(cursos);
				 
			 stm.close();

			 } catch (Exception e) {
			 System.out.println("Excepción:"+e);
			 }
		 //CONEXION------------------------------------------
		 //CONEXION--------------------------------------------
		setVisible(true);
		
	}
	
	public String MandarComponenteAMostrarDatosComponentes(){
		return componente;
	}

}