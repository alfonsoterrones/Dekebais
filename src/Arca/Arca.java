package Arca;

import java.awt.BorderLayout;
import Principal.Fondo;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.pool.OracleDataSource;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Arca extends JFrame {

	private Fondo contentPane;

	public Arca() {
		
		float saldo=0;
		float total=0;
		float falta=0;
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 532, 428);
		contentPane = new Fondo("Arca.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
	
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
			 ResultSet rset=stm.executeQuery("select SALDO, NUEVO from COMPONENTE order by NOMBREEMPLE");
			 
			
			 while (rset.next()){
				 saldo=saldo+rset.getFloat("SALDO");
				 System.out.println(rset.getFloat("SALDO"));
				 
				 if(rset.getString("NUEVO").equals("Si")){
					 total=total+106;
				 }else{
					 total=total+100;
				 }
			 }
			 
			
				 
			 stm.close();

			 } catch (Exception e) {
			 System.out.println("Excepción:"+e);
			 }
		 
		 JLabel lblSaldoActual = new JLabel("Saldo Actual : "+saldo+"€");
			
			JLabel lblSaldoFinal = new JLabel("Saldo Previsto : "+total+"€");
			
			falta=total-saldo;
			
			JLabel lblFaltaPorPagar = new JLabel("Falta por pagar: "+falta+"€");
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(166)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblSaldoActual)
							.addComponent(lblSaldoFinal)
							.addComponent(lblFaltaPorPagar))
						.addContainerGap(216, Short.MAX_VALUE))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblSaldoActual)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSaldoFinal)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblFaltaPorPagar)
						.addContainerGap(296, Short.MAX_VALUE))
			);
			contentPane.setLayout(gl_contentPane);
			setVisible(true);
		 //CONEXION------------------------------------------
		 //CONEXION--------------------------------------------
		setVisible(true);
	}
}
