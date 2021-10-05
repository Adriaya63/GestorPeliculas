package org.gestorpeliculas;

public class Aplicacion {
	private static Aplicacion aplicacion;
	
	//Contructora y getters
	private Aplicacion() {}
	
	public static Aplicacion aplicacion() {
		if(aplicacion == null) aplicacion = new Aplicacion();
		return aplicacion;
	}
	
	public void cargarDatosEnFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de cargar todos los datos de la aplicacion
	}
	
	public void guardarDatosEnFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de guardar todos los datos de la aplicacion
	}
	
	public Actor buscarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de buscar el actor y devolverlo en caso de encontrarlo.
		//		En caso contrario devolverá null.
	}
	
	public void anadirActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de anadir ese actor a la aplicacion
	}
	
	public void eliminarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de elminar a ese actor. Si ese actor no esta anadico se indicará.
	}
	
	public ListaNombres obtenerFilmografiaActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de obtener la filmografia del actor. en caso de que el actor no exista
		// 		devolvera null.
	}
	
	public ListaNombres obtenerRepartoPelicula(String pTitulo) {
		//PRE: Recibe el titulo de una pelicula en formato String
		//POST: LLama a CatalogoPeliculas para que se encarge de obtener el reparto de la pelicula. en caso de que la pelicula no exista
		// 		devolvera null.
	}
	
	public void incrementarRecaudacionPelicula(String pTitulo, int pIncremento) {
		//PRE: Recibe el titulo de una pelicula en formato String y un int que conforma el incremento de la recaudacion de la pelicula
		//POST: Llama a CatalogoPeliculas para que se encargue de buscar la pelicula e incermentar su recaudacion en caso de encontrarla.
		//		En caso contrario se indicará que la pelicula no esta añadida.
	}
	
	public _____ obtenerListaOrdenadaDeActores() {
		//PRE:
		//POST: Devuleve un ____ que conforma una lista ordenada de todos los actores de la aplicacion.
	}
}
