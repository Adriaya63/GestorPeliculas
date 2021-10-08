package org.gestorpeliculas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListaNombres {
	private HashMap<String, Integer> lista;
	
	public ListaNombres() {
		//Constructora de la clase ListaNombres
		this.lista = new HashMap<String, Integer>();
	}
	
	public boolean esta(String pNombre) {
		return this.lista.get(pNombre) != null;
	}
	
	//get de iterador para poder cargar los datos en fichero
	public Iterator<Entry<String, Integer>> iterator(){
		return this.lista.entrySet().iterator();
	}
	
	public int getSize() {
		//PRE:
		//POST: Devuelve el numero de elementos en la lista
		return this.lista.size();
	}
	
	public void anadirNombre(String pNombre) {
		//PRE: Recibe un string con el nombre a insertar
		//POST: Se inserta el nombre como key en la tabla de hash y su valor es 0
		if(pNombre != "") this.lista.put(pNombre, 0);
	}
	
	public void eliminarNombre(String pNombre) {
		//PRE: Recibe un string con un nombre (puede estar o no en la tabla)
		//POST: Se elimina ese nombre en caso de estar. Si noo esta se deja igual.
		this.lista.remove(pNombre);
	}
	
	public void imprimir() {
		//PRE:
		//POST: Se imprime la tabla con todos los nombres (solo las key del hashmap)
		
		this.lista.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
		});
	}
	
}
