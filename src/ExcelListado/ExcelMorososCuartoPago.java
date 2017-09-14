package ExcelListado;


import org.apache.poi.hssf.usermodel.*;

import oracle.jdbc.pool.OracleDataSource;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author Beto Rojas
 */
public class ExcelMorososCuartoPago{

    public ExcelMorososCuartoPago(){
        //Creamos una instancia de la clase HSSFWorkbook llamada libro
        HSSFWorkbook libro = new HSSFWorkbook();
        
        //Creamos una instancia de la clase HSSFSheet llamada hoja y la creamos
        HSSFSheet hoja = libro.createSheet();
        
        //Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
        HSSFRow fila = hoja.createRow(0);
        HSSFRow fila1 = hoja.createRow(1);
        
        
     
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
   		 ResultSet rset=stm.executeQuery("select NOMBREEMPLE, APELLIDOPRIMERO, APELLIDOSEGUNDO, SALDO, TELEFONO,  NUEVO, EDAD from COMPONENTE");
   		 
   		int contador=1;
   		
   		
        HSSFRow fila0 = hoja.createRow(0);
        
        HSSFCell celdauno = fila.createCell(0);
        HSSFCell celdados = fila.createCell(1);
        HSSFCell celdatres = fila.createCell(2);
        HSSFCell celdacuatro = fila.createCell(3);
        HSSFCell celdacinco = fila.createCell(4);
        HSSFCell celdaseis = fila.createCell(5);
        HSSFCell celdasiete = fila.createCell(6);
       



        
					  HSSFRichTextString textoA2 = new HSSFRichTextString("Nombre");
			          HSSFRichTextString textoB22 = new HSSFRichTextString("Apellido1");
			          HSSFRichTextString textoC2 = new HSSFRichTextString("Apellido2");
			          HSSFRichTextString textoD2 = new HSSFRichTextString("Saldo");
			          HSSFRichTextString textoF2 = new HSSFRichTextString("Telefono");
			          HSSFRichTextString textoG2 = new HSSFRichTextString("Nuevo");
			          HSSFRichTextString textoH2 = new HSSFRichTextString("Edad");
			          
			          
			          celdauno.setCellValue(textoA2);
			          celdados.setCellValue(textoB22);
			          celdatres.setCellValue(textoC2);
			          celdacuatro.setCellValue(textoD2);
			          celdacinco.setCellValue(textoF2);
			          celdaseis.setCellValue(textoG2);
			          celdasiete.setCellValue(textoH2);
			         		   		 
			         
   					int contadores=1;
					 while (rset.next()){
						 if(rset.getInt("SALDO")<80 && rset.getInt("EDAD")>11 || (rset.getInt("EDAD")<12 && rset.getString("NUEVO").equals("No") && rset.getInt("SALDO")<50)){

						 HSSFRow filaPrueba = hoja.createRow(contadores);
						 
						 	for(int i=0;i<=6;i++){
						 		HSSFCell prueba = filaPrueba.createCell(i);
						 		HSSFRichTextString textoB2 = new HSSFRichTextString(rset.getString(i+1));
						 		prueba.setCellValue(textoB2);
						}
						 	contadores++;
						 }
					 }
					/*
					
		         
					
			          
				}
			}
   		 }
   			*/ 
   		 stm.close();

   		 } catch (Exception e) {
   		 System.out.println("Excepci�n:"+e);
   		 }


        try{
            
            
            
        	String ex = "MorososCuartoPago";
            
            
            
            
            
            do{
               // ex = JOptionPane.showInputDialog(null, "Nombre del Excel",JOptionPane.QUESTION_MESSAGE);
                if(ex == null){
                    JOptionPane.showMessageDialog(null, "Te falto introducir el nombre del Excel", "Error",2);
                }
            }while(ex == null);
            FileOutputStream archivo = new FileOutputStream("MosososCuartoPago.xls");
            libro.write(archivo);
            archivo.close();
            
            JOptionPane.showMessageDialog(null, "Se ha creado el Excel con exito!!!", "Aviso",1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
    }
}