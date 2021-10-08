package org.gestorpeliculas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Aplicacion {
	private static Aplicacion aplicacion;
	private BufferedReader br;
	
	//Contructora y getters
	private Aplicacion() {
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static Aplicacion aplicacion() {
		if(aplicacion == null) aplicacion = new Aplicacion();
		return aplicacion;
	}
	
	public static void main(String[] args) {
		Aplicacion.aplicacion().initApp();
	}
	
	public void initApp(){
		//PRE:
		//POST: metodo principal que pedira por consola la accion a realizar

		String nombreActor = "";
		String nombrePelicula = "";
		int res = 10;
		
		while(res!=9){
			this.imprimirMenu();
			
			
			switch(res) {
				case 0:
					this.cargarDatosEnFichero();
				break;
				
				case 1:
					nombreActor = leerString("Introduzca el nombre del actor que quiere buscar.");
					this.buscarActor(nombreActor);
				break;
				
				case 2:
					nombreActor = leerString("Introduzca el nombre del actor que quiere añadir.");
					ListaNombres fil = new ListaNombres();
					this.anadirActor(nombreActor, fil);
				break;
				
				case 3:
					nombreActor = leerString("Introduzca el nombre del actor.");
					this.imprimirFilmografiaActor(nombreActor);
				break;
				
				case 4:
					nombrePelicula = leerString("Introduzca el nombre de la pelicula.");
					this.imprimirRepartoPelicula(nombrePelicula);
				break;
				
				case 5:
					System.out.println("Introduzca el nombre de la pelicula");
					nombrePelicula = leerString("Introduzca el nombre de la pelicula");
					int cant = leerInt("Introduzca la recaudacion de la pelicula");
					this.incrementarRecaudacionPelicula(nombrePelicula, cant);
				break;
				
				case 6:
					System.out.println("Introduzca el nombre del actor que quiere eliminar.");
					nombreActor = leerString("Introduzca el nombre del actor que quiere eliminar.");
					this.eliminarActor(nombreActor);
				break;
				
				case 7:
					this.cargarDatosEnFichero();
				break;
				
				case 8:
					this.imprimirListaOrdenadaDeActores();
				break;
			}
			
			leerString("Introduce culaquier valor para continuar");
			this.limpiarConsola();
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
	
	private String leerString(String pMensaje) {
		System.out.println(pMensaje);
		String input = "";
		
		try {
			input = this.br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return input;
	}
	
	private int leerInt(String pMensaje) {
		System.out.println(pMensaje);
		String input = "";
		
		try {
			input = this.br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Integer.parseInt(input);
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
