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

	@SuppressWarnings("resource")
	public void main(){
		//PRE:
		//POST: metodo principal que pedira por consola la accion a realizar
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

		Scanner scr = new Scanner(System.in);
		int res = scr.nextInt();
		while(res!=9){
			if (res == 0){this.cargarDatosEnFichero();}
			else if (res == 1){
				System.out.println("Introduzca el nombre del actor que quiere buscar.");
				String nombreActor = scr.nextLine();
				this.buscarActor(nombreActor);
			}
			else if (res == 2){
				System.out.println("Introduzca el nombre del actor que quiere añadir.");
				String nombreActor = scr.nextLine();
				ListaNombres fil = new ListaNombres();
				this.anadirActor(nombreActor, fil);
			}
			else if (res == 3){
				System.out.println("Introduzca el nombre del actor.");
				String nombreActor = scr.nextLine();
				this.imprimirFilmografiaActor(nombreActor);
			}
			else if (res == 4){
				System.out.println("Introduzca el nombre de la pelicula.");
				String nombrePelicula = scr.nextLine();
				this.imprimirRepartoPelicula(nombrePelicula);
			}
			else if (res == 5){
				System.out.println("Introduzca el nombre de la pelicula y la cantidad.");
				String nombrePelicula = scr.nextLine();
				int cant = scr.nextInt();
				this.incrementarRecaudacionPelicula(nombrePelicula, cant);
			}
			else if (res == 6){
				System.out.println("Introduzca el nombre del actor que quiere eliminar.");
				String nombreActor = scr.nextLine();
				this.eliminarActor(nombreActor);
			}
			else if (res == 7){this.cargarDatosEnFichero();}
			else if (res == 8){this.imprimirListaOrdenadaDeActores();}
		}
	}
	
	public void cargarDatosEnFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de cargar todos los datos de la aplicacion
	}
	
	public void guardarDatosEnFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de guardar todos los datos de la aplicacion
	}
	
	public void buscarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de buscar el actor y devolverlo en caso de encontrarlo.
		//		En caso contrario devolverá null.
		Actor actor = ColeccionActores.getColAct().buscarActor(pNombreActor);
		if(actor == null) {
			
		}else {
			actor.imprimir();
		}
	}
	
	public void anadirActor(String pNombreActor, ListaNombres pFilmografia) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de anadir ese actor a la aplicacion
		ColeccionActores.getColAct().anadirActor(pNombreActor, pFilmografia);
	}
	
	public void eliminarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de elminar a ese actor. Si ese actor no esta anadico se indicará.
		ColeccionActores.getColAct().eliminarActor(pNombreActor);
	}
	
	public void imprimirFilmografiaActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de obtener la filmografia del actor. en caso de que el actor no exista
		// 		devolvera null.
		ListaNombres filmografia = ColeccionActores.getColAct().obtenerFilmografiaDeActor(pNombreActor);
		filmografia.imprimir();
	}
	
	public void imprimirRepartoPelicula(String pTitulo) {
		//PRE: Recibe el titulo de una pelicula en formato String
		//POST: LLama a CatalogoPeliculas para que se encarge de obtener el reparto de la pelicula. en caso de que la pelicula no exista
		// 		devolvera null.
		ListaNombres reparto = CatalogoPeliculas.getCatalogo().obtenerRepartoDePelicula(pTitulo);
		reparto.imprimir();
	}
	
	public void incrementarRecaudacionPelicula(String pTitulo, int pIncremento) {
		//PRE: Recibe el titulo de una pelicula en formato String y un int que conforma el incremento de la recaudacion de la pelicula
		//POST: Llama a CatalogoPeliculas para que se encargue de buscar la pelicula e incermentar su recaudacion en caso de encontrarla.
		//		En caso contrario se indicará que la pelicula no esta añadida.
		CatalogoPeliculas.getCatalogo().incrementarRecaudacionPelicula(pTitulo, pIncremento);
	}
	
	public void imprimirListaOrdenadaDeActores() {
		//PRE:
		//POST: Se encarga de imprimir una lista ordenada de actores
		
		ListaActores listaOrdenada = ColeccionActores.getColAct().obtenerListaOrdenada();
		listaOrdenada.imprimir();
		
	}
}
