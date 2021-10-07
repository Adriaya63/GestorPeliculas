package org.gestorpeliculas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorDeFicheros {
	private static GestorDeFicheros gdf;
	//Ruta relativa del fichero a leer
	private final String rutaFicheroEntrada = System.getProperty("user.dir") + File.separator + "src" + File.separator + "files" + File.separator + "input.txt";
	private Scanner entrada;
	
	private final String rutaFicheroSalida = System.getProperty("user.dir") + File.separator + "src" + File.separator + "files" + File.separator + "output.txt";
	private FileWriter salida;
	//Constructora y getters
	@SuppressWarnings("unused")
	private GestorDeFicheros() throws FileNotFoundException, IOException{
		//Intentamos abrir el fichero de entrada. Si da algun problema lanzamos una excepcion
		entrada = new Scanner(new FileReader(rutaFicheroEntrada)); 
		if(entrada == null) throw new FileNotFoundException("Could'nt find " + rutaFicheroEntrada);
		
		//Comprobamos si exsiste el fichero de salida. Si no existe lo creamos.
		File ficheroSalida = new File(rutaFicheroSalida);
		if(ficheroSalida == null) throw new IOException("Error creating file");
		
		//Abrimos el fichero de escritura. Si no se puede, lanzamos una excepcion
		salida = new FileWriter(rutaFicheroSalida, false);
		if(salida == null) throw new IOException("Could'nt open " + rutaFicheroSalida);
			
	}
	
	public static GestorDeFicheros gestorDeFicheros() throws FileNotFoundException, IOException {
		if(gdf == null) gdf = new GestorDeFicheros();
		return gdf;
	}
	
	//Metodos
	public void cargarDatos() {
		//PRE: El fichero ha de contener los datos con el formato: PELICULA --->>> ACTOR1 ### ACTOR2.... donde cada linea es una pelicula distinta.
		//POST: Lee linea a linea el fichero y se encarga de llamar a CatalogoPeliculas y ColeccionActores por cada pelicula y actor que encuentra
		//		de tal forma que se registran todas las peliculas y actores que aparecen en el fichero.
		
		while(entrada.hasNext()) {
			String linea = entrada.next();
			String[] pelicula_actores = linea.split("--->>>");
			
			if(pelicula_actores.length > 1) {
				//Linea válida
				
			}
		}
	}
	
	public void guardarDatos() {
		//PRE: Se leen las peliculas de la clase CatalogoPeliculas. Todas las peliculas deben contener en su reparto los nombres de todos los actores 
		//	   que participan en ellas 
		//POST: Guarda en el fichero de salida la informacion de los actores y películas atendiendo al siguiente formato:  PELICULA --->>> ACTOR1 ### ACTOR2.... 
		//		donde cada linea es una pelicula distinta.
		
	}
	
	public void cerrarFicheroEntrada() {
		//PRE:
		//POST: Termina la lectura del fichero de entrada y lo cierra.
		entrada.close();
	}
	
	public void cerrarFicheroSalida() {
		//PRE:
		//POST: Termina la escritura del fichero de salida y lo cierra.
		
		try {
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error closing " + rutaFicheroSalida);
		}
	}
}
