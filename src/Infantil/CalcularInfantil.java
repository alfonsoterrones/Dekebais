package Infantil;


import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;


public class CalcularInfantil {

	 public static void main (String args []) throws SQLException {

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
		 ResultSet rset=stm.executeQuery("select NOMBREEMPLE, FECHNACIMIENTO from DAW1.COMPONENTE");
		 
		 
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
			 
			 if(ano>anoCarnaval || (ano==anoCarnaval && mes>mesCarnaval) || (ano==anoCarnaval && mes==mesCarnaval && dia>diaCarnaval)){
				 System.out.println (rset.getString("NOMBREEMPLE") + " " +rset.getString (2) ) ;

			 }
			 
			 }
			 
		 stm.close();

		 } catch (Exception e) {
		 System.out.println("Excepción:"+e);
		 }


		 }

}