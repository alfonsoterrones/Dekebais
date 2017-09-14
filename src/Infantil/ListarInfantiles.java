package Infantil;

import java.awt.BorderLayout;
import Principal.Fondo;
import Principal.MostrarDatos;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ExcelListado.ExcelListarInfantiles;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeSet;

import javax.swing.*;

import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;

public class ListarInfantiles extends JFrame{
	String nombreapellido;
	String componente;
	private Fondo contentPane;
	private int totalComponentes=0;
	private int totalComparsa=0;
	private float porciento=0f;


	public ListarInfantiles(){
		super("Componentes Infantiles");
		setSize(550, 561);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600,400);
		contentPane = new Fondo("Infantil.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
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
			 ResultSet rset=stm.executeQuery("select NOMBREEMPLE,COMPONENTE,APELLIDOPRIMERO,FECHNACIMIENTO from COMPONENTE order by NOMBREEMPLE");
			 
			 cursos.removeAllItems();
			
			//Calcular y meter infantill 
			 int ano;
			 int mes;
			 int dia;
			 //fechaCarnavales
			 int anoCarnaval=2002;
			 int mesCarnaval=2;
			 int diaCarnaval=9;
			 while (rset.next()){
				

				 ano = Integer.parseInt(rset.getString("FECHNACIMIENTO").substring(0,4));
				 mes = Integer.parseInt(rset.getString("FECHNACIMIENTO").substring(5,7));
				 dia = Integer.parseInt(rset.getString("FECHNACIMIENTO").substring(8,10));
				 
				 if((ano>anoCarnaval || (ano==anoCarnaval && mes>mesCarnaval) || (ano==anoCarnaval && mes==mesCarnaval && dia>diaCarnaval)) && rset.getString("COMPONENTE").equals("Si")){
					 System.out.println (rset.getString("NOMBREEMPLE") + " " +rset.getString (2) ) ;
					 cursos.addItem(rset.getString(1)+" "+rset.getString(2));
					 totalComponentes=totalComponentes+1;
					 totalComparsa=totalComparsa+1;
				 }else{
				 totalComparsa=totalComparsa+1;
				 }
				 }
			 porciento=totalComponentes*100/totalComparsa;
			 
			 
			 System.out.println("Todos"+totalComparsa);
			 JLabel lblTotalInfantiles = new JLabel("Total Infantiles: "+totalComponentes);
			 lblTotalInfantiles.setForeground(Color.WHITE);
			 
			 JLabel lblElDeLa = new JLabel("el "+porciento+"% de la comparsa son infantiles!!");
			 lblElDeLa.setFont(new Font("Tahoma", Font.PLAIN, 16));
			 lblElDeLa.setForeground(Color.WHITE);
			 
			 JButton btnImprimir = new JButton("Imprimir");
			 btnImprimir.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		ExcelListarInfantiles l = new ExcelListarInfantiles();
			 	}
			 });
			 GroupLayout groupLayout = new GroupLayout(getContentPane());
			 groupLayout.setHorizontalGroup(
			 	groupLayout.createParallelGroup(Alignment.LEADING)
			 		.addGroup(groupLayout.createSequentialGroup()
			 			.addContainerGap()
			 			.addComponent(lblElDeLa)
			 			.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
			 			.addComponent(btnImprimir)
			 			.addGap(21))
			 		.addGroup(groupLayout.createSequentialGroup()
			 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
			 				.addGroup(groupLayout.createSequentialGroup()
			 					.addGap(21)
			 					.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			 				.addGroup(groupLayout.createSequentialGroup()
			 					.addContainerGap()
			 					.addComponent(lblTotalInfantiles)))
			 			.addContainerGap(409, Short.MAX_VALUE))
			 );
			 groupLayout.setVerticalGroup(
			 	groupLayout.createParallelGroup(Alignment.LEADING)
			 		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
			 			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
			 				.addGroup(groupLayout.createSequentialGroup()
			 					.addContainerGap()
			 					.addComponent(btnImprimir))
			 				.addGroup(groupLayout.createSequentialGroup()
			 					.addGap(31)
			 					.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			 					.addPreferredGap(ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
			 					.addComponent(lblElDeLa)))
			 			.addPreferredGap(ComponentPlacement.RELATED)
			 			.addComponent(lblTotalInfantiles)
			 			.addContainerGap())
			 );
			 getContentPane().setLayout(groupLayout);
				 
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