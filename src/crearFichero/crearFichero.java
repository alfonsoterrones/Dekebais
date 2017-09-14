package crearFichero;


import java.io.*;
import java.util.Calendar;



public class crearFichero
{
	
	
	
public void crearFichero(String Nombre, String apellido,float pago){ 
	 
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
        	fichero = new FileWriter("prueba.txt");
            pw = new PrintWriter(fichero);
        	Calendar cal=Calendar.getInstance();
			int mes=cal.get(Calendar.MONTH)+1;
            //for (int i = 0; i < 10; i++)
             //   pw.println("Linea " + i);
            pw.println("La persona "+Nombre+" "+apellido+" Realizó el pago de :"+pago+" €");
            pw.println("Con fecha de: "+cal.get(Calendar.DAY_OF_MONTH)+"-"+mes+"-"+cal.get(Calendar.YEAR));
            pw.println("\t\t Comparsa Dekebais");
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
 		}
 
 

    }
