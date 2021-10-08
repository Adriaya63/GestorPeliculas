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
		
	}
}
