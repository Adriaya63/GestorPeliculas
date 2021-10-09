package org.gestorpeliculas;

import java.util.Scanner;

public class Consola {
	private Scanner sc;
	
	public Consola(){
		this.sc = null;
	}
	
	private void limpiarConsola() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public void close() {
		System.out.println("Cerrando la aplicacion...");
	}
	
	public void log(String pMensaje) {
		System.out.println(pMensaje);
	}
	
	public void esperarEnter(String pMensaje) {
		System.out.println(pMensaje);
		this.sc = new Scanner(System.in);
		sc.nextLine();
	}
	
	public String leerString(String pMensaje) {
		System.out.print(pMensaje + "\n->");
		this.sc = new Scanner(System.in);
		boolean repeat = true;
		String input ="";
		
		while(repeat) {
			input = this.sc.nextLine();
			if(!input.equals("")) repeat = false;
			else System.out.print("No se puede introducir un String vacío. \n->");
		}
		 
		
		
		return input;
	}
	
	public int leerInt(String pMensaje) {
		System.out.println(pMensaje);
		this.sc = new Scanner(System.in);
		boolean repeat = true;
		int input = 0;
		
		while(repeat) {
			try {
				System.out.print("->");
				input = Integer.parseInt(sc.nextLine());
				repeat = false;
			}catch(Exception e) {
				System.out.println("Introduce un numero por favor.");
			    repeat = true;
			}
		}
		
		return input;
	}
	
	public ListaNombres leerFilmografia() {
		ListaNombres filmografia = new ListaNombres();
		int numPeliculas = 0;
		
		System.out.println("Introduce las peliculas en las que participa el actor.");
		System.out.println("Para terminar introduce: /finish");
		
		
		while(true) {
			String titulo = leerString("Numero peliculas: " + numPeliculas);
			if(titulo.equals("/finish")) {
				if(numPeliculas > 0 ) break;
			}else {
				filmografia.anadirNombre(titulo);
				numPeliculas++;
			}
		}
		
		return filmografia;
	}
	
	public void imprimirMenuPrincipal() {
		//PRE: 
		//POST: Imprime por consola el meú principal de la aplicación
		this.limpiarConsola();
		System.out.println("MENU PRINCIPAL");
		System.out.println("Seleccione una de las siguoientes opciones:");
		System.out.println("0- Cargar los datos del fichero.");
		System.out.println("1- Bucar actor/actiz.");
		System.out.println("2- Añadir actor/actriz.");
		System.out.println("3- Obtener peliculas de un actor/actiz.");
		System.out.println("4- Obtener reparto de una pelicula.");
		System.out.println("5- Incrementar la recaudacion de una pelicula.");
		System.out.println("6- Eliminar un actor/actriz.");
		System.out.println("7- Guardar datos en fichero.");
		System.out.println("8- Obtener lista ordenada de actores.");
		System.out.println("9- Finalizar programa.");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu0() {
		//PRE:
		//POST: Imprime el menu 0 de cargar datos.
		this.limpiarConsola();
		
		System.out.println("CARGAR DATOS");
		System.out.println("Cargando datos del fichero de entrada");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu1() {
		//PRE:
		//POST: Imprime el menu 1 de busqueda de actores
		this.limpiarConsola();
				
		System.out.println("BUSCAR ACTOR/ACTRIZ");
		System.out.println("Busqueda de actores o actrizes");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu2() {
		//PRE:
		//POST: Imprime el menu 2 de añadido de actores
		this.limpiarConsola();
				
		System.out.println("AÑADIR ACTOR/ACTRIZ");
		System.out.println("Añadido de un nuevo actor o actriz a la aplicacion");
		System.out.println("Un actor debe tener un nombre y una filmografía no vacía");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu3() {
		//PRE:
		//POST: Imprime el menu 2 de obtener peliculas de un actor
		this.limpiarConsola();
				
		System.out.println("OBTENER PELICULAS DE UN ACTOR/ACTRIZ");
		System.out.println("Mostrar la filmografía de un actor o actriz");
		System.out.println("Se muestra toda la lista de peliculas en las que participa un actor");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu4() {
		//PRE:
		//POST: Imprime el menu 4 de obtener el reparto de una pelicula
		this.limpiarConsola();
				
		System.out.println("OBTENER REPARTO DE UNA PELICULA");
		System.out.println("Mostrar el reparto de una pelicula");
		System.out.println("Se muestra toda la lista de peliculas en las que participa un actor");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu5() {
		//PRE:
		//POST: Imprime el menu 5 de incremento de recaudacion
		this.limpiarConsola();
				
		System.out.println("INCREMENTAR RECAUDACIÓN DE UNA PELÍCULA");
		System.out.println("Se incrementa la recaudacion de una pelicula");
		System.out.println("Dado el titulo de una pelicula y el incremento o decremento");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu6() {
		//PRE:
		//POST: Imprime el menu 6 de eliminar un actor/actriz
		this.limpiarConsola();
				
		System.out.println("ELIMINAR ACTOR/ACTRIZ");
		System.out.println("Dado el nombre de un actor o actriz se elimina de la aplicacion");
		System.out.println("Si el actor/actriz no esta añadido no se hace nada");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu7() {
		//PRE:
		//POST: Imprime el menu 7 de guardado de datos
		this.limpiarConsola();
				
		System.out.println("GUARDAR DATOS");
		System.out.println("Guardando datos en el fichero de salida y se sale de la aplicación");
		System.out.println("==================================\n");
	}
	
	public void imprimirMenu8() {
		//PRE:
		//POST: Imprime el menu 7 de guardado de datos
		this.limpiarConsola();
				
		System.out.println("OBTENER LISTA OREDNADA DE ACTORES");
		System.out.println("Se devuelve una lista de todos los actores/actrices ordenada");
		System.out.println("Esta lista se imprime por consola");
		System.out.println("==================================\n");
	}
	
}
