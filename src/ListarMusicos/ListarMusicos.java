package ListarMusicos;

import java.awt.BorderLayout;
import Principal.MostrarDatos;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ExcelListado.ExcelListarInfantiles;
import ExcelListado.ExcelListarMusica;
import Principal.Fondo;
import Principal.MostrarDatos;
import oracle.jdbc.pool.OracleDataSource;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;

public class ListarMusicos extends JFrame {

	String nombreapellido;
	String componente;
	int total=0;

	private Fondo contentPane;

	
	public ListarMusicos(){
		super("Músicos");
		setSize(550, 407);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600,400);
	
		contentPane = new Fondo("Musicos.jpg");
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
			 ResultSet rset=stm.executeQuery("select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO,CUERPO from COMPONENTE order by NOMBREEMPLE");
			 
			 cursos.removeAllItems();
			 while (rset.next()){
				 if(rset.getString("CUERPO").equals("Musica")){
					 cursos.addItem(rset.getString(1)+" "+rset.getString(2));
					 total=total+1;
				 }
				 
			 }
			 
			 JLabel lblComponentesMsica = new JLabel("Componentes M\u00FAsica "+total);
			 lblComponentesMsica.setForeground(Color.WHITE);
			 
			 JButton btnImprimir = new JButton("Imprimir");
			 btnImprimir.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mousePressed(MouseEvent arg0) {
			 		ExcelListarMusica l = new ExcelListarMusica();
			 	}
			 });
			 GroupLayout gl_contentPane = new GroupLayout(contentPane);
			 gl_contentPane.setHorizontalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addContainerGap()
			 					.addComponent(lblComponentesMsica))
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addGap(21)
			 					.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
			 			.addContainerGap(378, Short.MAX_VALUE))
			 		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			 			.addContainerGap(381, Short.MAX_VALUE)
			 			.addComponent(btnImprimir)
			 			.addGap(44))
			 );
			 gl_contentPane.setVerticalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.TRAILING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addContainerGap()
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addComponent(cursos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			 					.addPreferredGap(ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
			 					.addComponent(lblComponentesMsica)
			 					.addGap(26))
			 				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			 					.addComponent(btnImprimir)
			 					.addGap(44))))
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