package crearFichero;

import java.io.BufferedWriter;

/*Clase que permite escribir en un archivo de texto*/

//Importamos clases que se usaran
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Calendar;


public class ManejoDeArchivos{
	

		public void crearRecibo(String persona,String Apellido,String pago, String quePago){
		
			
			
					try{
						
						//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
						File archivo=new File("texto.txt");
						
						
						
						
						
						Calendar cal=Calendar.getInstance();
						int mes=cal.get(Calendar.MONTH)+1;
						
						String texto=(   "\r\n" +"\r\n" +"\r\n" +"\r\n" +"\r\n" +"\r\n" + "\r\n" + "Recibo comparsa Dekebais \n pago: "+quePago+" y fué de: "+pago+"€\r\n");
						String texto2=("fecha "+cal.get(Calendar.DAY_OF_MONTH)+"-"+mes+"-"+cal.get(Calendar.YEAR)+"\n Componente: "+persona+ " "+Apellido);
						
						
						//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
						FileWriter escribir=new FileWriter(archivo,true);
						
						//Escribimos en el archivo con el metodo write 
						escribir.write(texto);
						escribir.write(texto2);
						
						
						

						//Cerramos la conexion
						escribir.close();
						System.out.println("Escrito");
						}

					//Si existe un problema al escribir cae aqui
					catch(Exception e)
					{
						System.out.println("Error al escribir");
					}
		}
}
