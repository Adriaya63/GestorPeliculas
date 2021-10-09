package org.gestorpeliculas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ColeccionActores {
	//MAE que controla todos los actores de la aplicacion
	private static ColeccionActores colAct;
	private HashMap<String, Actor> lista;

	//Constructora y getters
	private ColeccionActores() {
		this.lista = new HashMap<String, Actor>();
	}
	//Metodo para facilitar los test de la clase ColeccionActores
	//No usar fuera de los test
	public static void eliminarColeccion() {
		colAct = null;
	}
	
	
	public static ColeccionActores getColAct() {
		if(colAct == null) colAct = new ColeccionActores();
		return colAct;
		
	}
	
	//Metodos
	public Actor buscarActor(String pNombreActor) {
		//PRE: Recibe un String de un nombre de actor
		//POST: Devuelve el actor con ese mismo nombre en caso de encontrarlo. En caso contrario devuelve null
		
		//Como en la clase actor hemos definido que dos objetos actores son iguales si tienen el mismo nombre,
		//para buscar un actor en la lista podemos crear un nuevo objeto actor con dicho nombre, buscarlo y luego eliminar
		//el actor auxiliar.
		return this.lista.get(pNombreActor);
	}
	
	public void anadirActor(String pNombreActor, ListaNombres pFilmografia) {
		//PRE: Recibe un String de un nomrbre de actor y la lista de nombres de las peliculas en las que participa
		//POST:	Se cromprueba si el actor ya existe en la lista. Si no existe se crea un nuevo objeto Actor con pNombreActor
		//		y se itera sobre su filmografia añadiendo el nombre del actor al reparto de las peliculas en las que aparece. 
		//		Si alguna pelicula aun no esta anadida, se crea una pelicula nueva y se anade con el actor en su reparto.
		//		Si por el contrario el actor ya existe en la lista, se actualiza su filmografia con un proceso similar al anterior.
		if(pNombreActor.equals("") || pFilmografia.getSize() == 0) {return;}
		
		Actor act = this.buscarActor(pNombreActor);
			if(act == null) {
				act = new Actor(pNombreActor);
				this.lista.put(pNombreActor, act);
			}
		
		Iterator<Entry<String, Integer>> itr = pFilmografia.iterator();
		
		while(itr.hasNext()) {
			String titulo = itr.next().getKey();
			act.anadirEstaPeliculaAFilmografia(titulo);
			
			Pelicula peli = CatalogoPeliculas.getCatalogo().buscarPelicula(titulo);
			if(peli == null) {
				ListaNombres reparto = new ListaNombres();
				reparto.anadirNombre(pNombreActor);
				CatalogoPeliculas.getCatalogo().anadirPelicula(titulo, reparto);
			}else {
				peli.anadirEsteActorAlReparto(pNombreActor);
			}
		}
		
	}
	
	public void eliminarActor(String pNombreActor) {
		//PRE: Recibe un String con el nombre de un actor
		//POST: Si esta el actor, se elimina de la coleccion de actores y de todos los repartos de peliculas en los que aparece.
		//		Si no esta, no se hace nada
		Actor act = this.buscarActor(pNombreActor);
		if(act == null) return;
		
		Iterator<Entry<String, Integer>> itr = act.obtenerFilmografia().iterator();
		
		while(itr.hasNext()) {
			String titulo = itr.next().getKey();
			Pelicula pelicula = CatalogoPeliculas.getCatalogo().buscarPelicula(titulo);
			if(pelicula != null) {
				pelicula.eliminarEsteActorDelReparto(pNombreActor);
			}
			
			if (pelicula.obtenerReparto().getSize() == 0) {
				CatalogoPeliculas.getCatalogo().eliminarPelicula(titulo);
			}
		}
		
		this.lista.remove(pNombreActor);
		
	}
	
	public ListaNombres obtenerFilmografiaDeActor(String pNombreActor) {
		//PRE: Recibe un String con el nombre de un actor
		//POST: Si esta el actor se devuelve su filmografia. En caso contrario se devuelve null
		
		Actor act = this.buscarActor(pNombreActor);
		if(act != null) return act.obtenerFilmografia();
		return null;
	}
	
	public ListaActores obtenerListaOrdenada() {
		ListaActores listaOrdenada = new ListaActores();
		listaOrdenada.setLista(new ArrayList<Actor>(lista.values()));
		listaOrdenada.ordenarLista();
		
		return listaOrdenada;
	}
}
