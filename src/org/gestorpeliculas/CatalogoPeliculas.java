package org.gestorpeliculas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CatalogoPeliculas{
	private static CatalogoPeliculas cp;
	private HashMap<String, Pelicula> lista;
	
	//Constructora y getters
	private CatalogoPeliculas() {
		this.lista = new HashMap<String, Pelicula>();
	}
	
	//Metodo para facilitar los test de la clase CatalogoPeliculas
	//No usar fuera de los test
	public static void eliminarCatalogo() {
		cp = null;
	}
	
	//Get de iterador para poder guardar los datos en el fichero
	public Iterator<Pelicula> iterator(){
		ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>(this.lista.values());
		return listaPeliculas.iterator();
	}
	
	public static CatalogoPeliculas getCatalogo() {
		if(cp == null) cp = new CatalogoPeliculas();
		return cp;
	}
	
	//Metodos
	public Pelicula buscarPelicula(String pTitulo) {
		//PRE: Recibe un String titulo de pelicula
		//POST: Devuelve la pelicula con ese mismo titulo en caso de encontrarla. En caso contrario devuelve null
		
		//Como en la clase pelicula hemos definido que dos objetos pelicula son iguales si tienen el mismo titulo,
		//para buscar una pelicula en la lista podemos crear un nuevo objeto con dicho nombre, buscarla y luego eliminar
		//la pelicula auxiliar.
		
		return this.lista.get(pTitulo);
	}
	
	public void anadirPelicula(String pTitulo, ListaNombres pReparto) {
		//PRE: Recibe un titulo de una pelicula y una lista de nombres de actores que conforman el reparto
		//POST: Primero se comprueba si la pelicula ya se encuentra en el catálogo. De ser así se actualizará su reparto
		//		y se comprobará en la coleccion de actores que todos estan añadidos y que contienen el titulo de la pelicula en 
		//		su filmografía. De ser necesario se añadirán nuevos actores. En caso contrario se seguirá un proceso similar pero
		//		creando una pelicula nueva.

		if(pTitulo.equals("") || pReparto.getSize() == 0) {return;}
		
		Pelicula peli = this.buscarPelicula(pTitulo);
		if(peli == null) {
				peli = new Pelicula(pTitulo);
				this.lista.put(pTitulo, peli);
		}
		
		Iterator<java.util.Map.Entry<String, Integer>> itr = pReparto.iterator();
		
		while(itr.hasNext()) {
			String nombre = itr.next().getKey();
			peli.anadirEsteActorAlReparto(nombre);
			
			Actor act = ColeccionActores.getColAct().buscarActor(nombre);
			if(act == null) {
				ListaNombres filmografia = new ListaNombres();
				filmografia.anadirNombre(pTitulo);
				ColeccionActores.getColAct().anadirActor(nombre, filmografia);
			}else {
				act.anadirEstaPeliculaAFilmografia(pTitulo);
			}
		}
	}
	
	public void eliminarPelicula(String pTitulo) {
		//PRE: Recibe un String con el titulo de una pelicula
		//POST: Si esta la pelicula, se elimina del catalogo de peliculas y de todas las filmografias de actores en las que aparece.
		//		Si no esta, no se hace nada
		Pelicula peli = this.buscarPelicula(pTitulo);
		if(peli == null) return;
		
		Iterator<java.util.Map.Entry<String, Integer>> itr = peli.obtenerReparto().iterator();
		
		while(itr.hasNext()) {
			String nombre = itr.next().getKey();
			Actor act = ColeccionActores.getColAct().buscarActor(nombre);
			if(act != null) {
				act.eliminarEstaPeliculaDeFilmografia(pTitulo);
				if (act.obtenerFilmografia().getSize() == 0) {
					ColeccionActores.getColAct().eliminarActor(nombre);
				}
			}
		}
		
		this.lista.remove(pTitulo);

	}
	
	public ListaNombres obtenerRepartoDePelicula(String pTitulo) {
		//PRE: Recibe un String con el nombre de un actor
		//POST: Si esta el actor se devuelve su filmografia. En caso contrario se devuelve null
		
		Pelicula pel = this.buscarPelicula(pTitulo);
		if(pel != null) return pel.obtenerReparto();
		return null;
	}
	
	public void imprimir() {
		//PRE:
		//POST: Imprime por consola informacion relevante sobre el catalogo
	}
	
	
}
