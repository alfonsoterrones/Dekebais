package AgregarComponente;

import java.sql.*;
import java.util.Calendar;

import oracle.jdbc.pool.OracleDataSource;


public class InsertarComponenteEnLaBaseDeDatos {

	 public InsertarComponenteEnLaBaseDeDatos( String nombre, String apellido1, String apellido2, String mail,String fecha, String saldo, String amigo, String telefono, String cuerpo, String nuevo, String sexo,String modista,String apuntado){

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
		 
		 //CALCULAR EDAD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 int ano;
		 int mes;
		 int dia;
		 
		 int anoDeComponente=0;
		 int auxAno;
		 
		 System.out.println(fecha.substring(6,10));
		 System.out.println(fecha.substring(3,5));
		 System.out.println(fecha.substring(0,2));
		 
		 ano = Integer.parseInt(fecha.substring(6,10));
		 mes = Integer.parseInt(fecha.substring(3,5));
		 dia = Integer.parseInt(fecha.substring(0,2));
		 
		 
		 Calendar cal=Calendar.getInstance();
			
		
		auxAno=ano;
		while(auxAno<cal.get(Calendar.YEAR)){
			
			auxAno++;
			anoDeComponente=anoDeComponente+1;
		
		}
		
		if(cal.get(Calendar.MONTH)+1<mes){
			anoDeComponente=anoDeComponente-1;

		}else{
			if(cal.get(Calendar.MONTH)+1==mes && cal.get(Calendar.DAY_OF_MONTH)<dia){
				anoDeComponente=anoDeComponente-1;
			}
		}
		

		 Statement stm=conexion.createStatement();
		
		 

		// insert the data
		 String Consulta="INSERT INTO Componente " + "VALUES ('"+nombre+"', '"+apellido1+"', '"+apellido2+"', '"+mail+"','"+fecha+"',"+saldo+",'"+amigo+"','"+telefono+"','"+cuerpo+"','"+sexo+"','"+anoDeComponente+"','"+modista+"','"+apuntado+"','"+nuevo+"')";
		 System.out.println(Consulta);

		 stm.executeUpdate(Consulta);
		
			 
		 stm.close();

		 } catch (Exception e) {
		 System.out.println("Excepción:"+e);
		 ErrorAgegar el=new ErrorAgegar("Excepción:"+e);
		 }


		 }

	

}