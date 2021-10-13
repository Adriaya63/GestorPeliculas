package org.gestorpeliculas;

import java.util.ArrayList;
import java.util.Collections;

public class ListaActores {
	private ArrayList<Actor> lista;
	
	public ListaActores() {
		this.lista = new ArrayList<Actor>();
	}
	
	public void setLista(ArrayList<Actor> pLista) {
		this.lista = pLista;
	}
	
	public void ordenarLista() {
		Collections.sort(this.lista);
	}
	
	public void imprimir() {
		//PRE:
		//POST: Imprime por consola la lista con los nombres de los actores
		int numActores = this.lista.size();
		for(Actor act: this.lista) {
			numActores--;
			System.out.print(act.getNombre());
			if(numActores > 0) System.out.print(" | "); 
		}
		System.out.print("\n");
	}
}
