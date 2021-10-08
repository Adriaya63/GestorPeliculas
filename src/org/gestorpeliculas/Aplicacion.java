package org.gestorpeliculas;

import java.util.Scanner;

public class Aplicacion {
	private static Aplicacion aplicacion;
	
	//Contructora y getters
	private Aplicacion() {}
	
	public static Aplicacion aplicacion() {
		if(aplicacion == null) aplicacion = new Aplicacion();
		return aplicacion;
	}
	
	public static void main(String[] args) {
		Aplicacion.aplicacion().initApp();
	}
	
	@SuppressWarnings("resource")
	public void initApp(){
		//PRE:
		//POST: metodo principal que pedira por consola la accion a realizar

		Scanner scr = new Scanner(System.in);
		String nombreActor = "";
		this.imprimirMenu();
		int res = scr.nextInt();
		
		while(res!=9){
			
			switch(res) {
				case 0:
					this.cargarDatosEnFichero();
				break;
				
				case 1:
					System.out.println("Introduzca el nombre del actor que quiere buscar.");
					nombreActor = scr.nextLine();
					this.buscarActor(nombreActor);
				break;
				
				case 2:
					System.out.println("Introduzca el nombre del actor que quiere añadir.");
					nombreActor = scr.nextLine();
					ListaNombres fil = new ListaNombres();
					this.anadirActor(nombreActor, fil);
				break;
				
				case 3:
					System.out.println("Introduzca el nombre del actor.");
					nombreActor = scr.nextLine();
					this.imprimirFilmografiaActor(nombreActor);
				break;
				
				case 4:
					System.out.println("Introduzca el nombre de la pelicula.");
					String nombrePelicula = scr.nextLine();
					this.imprimirRepartoPelicula(nombrePelicula);
				break;
				
				case 5:
					System.out.println("Introduzca el nombre de la pelicula y la cantidad.");
					nombrePelicula = scr.nextLine();
					int cant = scr.nextInt();
					this.incrementarRecaudacionPelicula(nombrePelicula, cant);
				break;
				
				case 6:
					System.out.println("Introduzca el nombre del actor que quiere eliminar.");
					nombreActor = scr.nextLine();
					this.eliminarActor(nombreActor);
				break;
				
				case 7:
					this.cargarDatosEnFichero();
				break;
				
				case 8:
					this.imprimirListaOrdenadaDeActores();
				break;
				
				case 9:
				break;
			}
		}
			
			
	}
	
	private void imprimirMenu() {
		//PRE: 
		//POST: Imprime por consola el menú de la aplicacion
		
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
	}
	
	private void limpiarConsola() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	private void cargarDatosEnFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de cargar todos los datos de la aplicacion
	}
	
	private void guardarDatosEnFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de guardar todos los datos de la aplicacion
	}
	
	private void buscarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de buscar el actor y devolverlo en caso de encontrarlo.
		//		En caso contrario devolverá null.
		Actor actor = ColeccionActores.getColAct().buscarActor(pNombreActor);
		if(actor == null) {
			
		}else {
			actor.imprimir();
		}
	}
	
	private void anadirActor(String pNombreActor, ListaNombres pFilmografia) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de anadir ese actor a la aplicacion
		ColeccionActores.getColAct().anadirActor(pNombreActor, pFilmografia);
	}
	
	private void eliminarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de elminar a ese actor. Si ese actor no esta anadico se indicará.
		ColeccionActores.getColAct().eliminarActor(pNombreActor);
	}
	
	private void imprimirFilmografiaActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de obtener la filmografia del actor. en caso de que el actor no exista
		// 		devolvera null.
		ListaNombres filmografia = ColeccionActores.getColAct().obtenerFilmografiaDeActor(pNombreActor);
		filmografia.imprimir();
	}
	
	private void imprimirRepartoPelicula(String pTitulo) {
		//PRE: Recibe el titulo de una pelicula en formato String
		//POST: LLama a CatalogoPeliculas para que se encarge de obtener el reparto de la pelicula. en caso de que la pelicula no exista
		// 		devolvera null.
		ListaNombres reparto = CatalogoPeliculas.getCatalogo().obtenerRepartoDePelicula(pTitulo);
		reparto.imprimir();
	}
	
	private void incrementarRecaudacionPelicula(String pTitulo, int pIncremento) {
		//PRE: Recibe el titulo de una pelicula en formato String y un int que conforma el incremento de la recaudacion de la pelicula
		//POST: Llama a CatalogoPeliculas para que se encargue de buscar la pelicula e incermentar su recaudacion en caso de encontrarla.
		//		En caso contrario se indicará que la pelicula no esta añadida.
		CatalogoPeliculas.getCatalogo().incrementarRecaudacionPelicula(pTitulo, pIncremento);
	}
	
	private void imprimirListaOrdenadaDeActores() {
		//PRE:
		//POST: Se encarga de imprimir una lista ordenada de actores
		
		ListaActores listaOrdenada = ColeccionActores.getColAct().obtenerListaOrdenada();
		listaOrdenada.imprimir();
		
	}
}
