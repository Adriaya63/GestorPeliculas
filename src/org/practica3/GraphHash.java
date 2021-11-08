package org.practica3;

import java.util.ArrayList;
import java.util.HashMap;

import org.gestorpeliculas.*;

public class GraphHash {
	
	HashMap<String, ArrayList<String>> g;
	public void crearGrafo(ListaActores lista) {
		// Post: crea el grafo desde la lista de actores
		// Los nodos son nombres de actores
	
		 // COMPLETAR CÓDIGO
		
	}
	
	public boolean estanConectados(String a1, String a2) {
		// COMPLETAR CÓDIGO
		return false;
	}
	
	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			}
			
			System.out.println();
		}
	}
}
