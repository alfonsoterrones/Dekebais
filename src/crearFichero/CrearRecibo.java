package crearFichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class CrearRecibo {

	public static void main(String[] args) {

		try {
			FileWriter archivo = new FileWriter("texto.txt", true);
			PrintWriter escribir = new PrintWriter(archivo);

			String dato = "";

			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

			do {
				escribir.println("Holaa");
				System.out.println("Dnidddddddddd");
				String dni = bf.readLine();

				System.out.println("Nombre");
				String nombre = bf.readLine();

				System.out.println("Direccion");
				String direccion = bf.readLine();

				String hola = "hola";
				String cadena = dni + "/" + nombre + "/" + direccion;

				escribir.println("SAAS");

				System.out.println("Desea ingresar nuevo dato si-no");
				dato = bf.readLine();

			} while ("si".equals(dato));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
