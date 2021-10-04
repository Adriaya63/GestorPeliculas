package org.gestorpeliculas;

import java.util.HashMap;

public class ListaNombres {
	private HashMap<String, Integer> lista;
	
	public ListaNombres() {
		//Constructora de la clase ListaNombres
		this.lista = new HashMap<String, Integer>();
	}
	
	public void anadirNombre(String pNombre) {
		//PRE: Recibe un string con el nombre a insertar
		//POST: Se inserta el nombre como key en la tabla de hash y su valor es 0
		this.lista.put(pNombre, 0);
	}
	
	public void eliminarNombre(String pNombre) {
		//PRE: Recibe un string con un nombre (puede estar o no en la tabla)
		//POST: Se elimina ese nombre en caso de estar. Si noo esta se deja igual.
	}
	
	public void imprimir() {
		//PRE:
		//POST: Se imprime la tabla con todos los nombres (solo las key del hashmap)
		
		this.lista.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
		});
	}
}
