package org.practica3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.gestorpeliculas.*;

public class GraphHash {
	
	private HashMap<String, ArrayList<String>> g;
	public void crearGrafo(ListaActores lista) {
		// Post: crea el grafo desde la lista de actores
		// Los nodos son nombres de actores)
	
		 // COMPLETAR CÓDIGO
		g.clear();
		Iterator<Actor> itr = lista.getIterator();
		Actor act = null;
		while (itr.hasNext()) {
			act = itr.next();
			ArrayList<String> colegas = new ArrayList<String>();
			Iterator<Entry<String, Integer>> itrAct = act.obtenerFilmografia().iterator();
			while(itrAct.hasNext()) {
				String titulo = itrAct.next().getKey();
				Pelicula pel = CatalogoPeliculas.getCatalogo().buscarPelicula(titulo);
				HashSet<String> aux = new HashSet<String>();
				Iterator<Entry<String, Integer>> itrPel = pel.obtenerReparto().iterator();
				while(itrPel.hasNext()) {
					String nombre = itrPel.next().getKey();
					if(!aux.contains(nombre)) {
						aux.add(nombre);
					}
				}
				Iterator<String> itrAux = aux.iterator();
				while(itrAux.hasNext()) {
				String nom = itrAux.next();
				colegas.add(nom);
				}
			g.put(act.getNombre(), colegas);
			}
		}
	}
	
	
	public GraphHash(){
		this.g = new HashMap<String, ArrayList<String>>();
		
	}
	
	public boolean estanConectados(String inicio, String objetivo) {
		// COMPLETAR CÓDIGO
		Queue<String> porExaminar = new LinkedList<String>();
		HashSet<String> porExaminarSet = new HashSet<String>();
		HashSet<String> examinados = new HashSet<String>();
		
		porExaminar.add(inicio); 
		porExaminarSet.add(inicio);
		boolean encontrado = false;
		
		while(!encontrado && !porExaminar.isEmpty()) {
			String act = porExaminar.remove();
			porExaminarSet.remove(act);
			
			if(act.equals(objetivo)) {
					encontrado = true;
					
			}else {
				examinados.add(act);
				
				for(String x: g.get(act)) {
					//Añadimos los relacionados con act a la cola si no estan 
					// siendo examinados o si ya han sido examinados
					if(!examinados.contains(x) && !porExaminar.contains(x)) {
						porExaminar.add(x);
						porExaminarSet.add(x);
					}
				}
			}
		}
		
		return encontrado;
	}
	
	public static void main(String args[]) {
		GraphHash myGraph = new GraphHash();
		myGraph.pruebaEstanConectados();
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
	
	// PROGRAMAS DE RPUEBA
	public void pruebaEstanConectados() {
		this.crearEjemploEstanConectados();
		
		if(!this.estanConectados("a", "")) {
			System.out.println("PRUEBA 0 CORRECTA");
		}else {
			System.out.println("PRUEBA 0 FALLIDA");
		}
		
		if(this.estanConectados("a", "j")) {
			System.out.println("PRUEBA 1 CORRECTA");
		}else {
			System.out.println("PRUEBA 1 FALLIDA");
		}
		
		if(!this.estanConectados("a", "o")) {
			System.out.println("PRUEBA 2 CORRECTA");
		}else {
			System.out.println("PRUEBA 2 FALLIDA");
		}
		
		if(this.estanConectados("o", "o")) {
			System.out.println("PRUEBA 3 CORRECTA");
		}else {
			System.out.println("PRUEBA 3 FALLIDA");
		}
		
		if(this.estanConectados("m", "n")) {
			System.out.println("PRUEBA 4 CORRECTA");
		}else {
			System.out.println("PRUEBA 4 FALLIDA");
		}
		
		if(!this.estanConectados("a", "n")) {
			System.out.println("PRUEBA 5 CORRECTA");
		}else {
			System.out.println("PRUEBA 5 FALLIDA");
		}
	}
	
	
	private void crearEjemploEstanConectados() {
		this.g = new HashMap<String, ArrayList<String>>();

		ArrayList<String> datos = null;

		// A
		datos = new ArrayList<String>();
		datos.add("b");
		datos.add("c");
		datos.add("d");
		g.put("a", datos);

		// B
		datos = new ArrayList<String>();
		datos.add("a");
		datos.add("e");
		g.put("b", datos);

		// C
		datos = new ArrayList<String>();
		datos.add("a");
		datos.add("e");
		datos.add("f");
		g.put("c", datos);

		// D
		datos = new ArrayList<String>();
		datos.add("a");
		datos.add("f");
		datos.add("g");
		g.put("d", datos);

		// E
		datos = new ArrayList<String>();
		datos.add("b");
		datos.add("c");
		datos.add("h");
		g.put("e", datos);

		// F
		datos = new ArrayList<String>();
		datos.add("c");
		datos.add("d");
		datos.add("j");
		g.put("f", datos);

		// G
		datos = new ArrayList<String>();
		datos.add("d");
		g.put("g", datos);

		// H
		datos = new ArrayList<String>();
		datos.add("e");
		datos.add("i");
		g.put("h", datos);

		// I
		datos = new ArrayList<String>();
		datos.add("f");
		g.put("i", datos);

		// J
		datos = new ArrayList<String>();
		datos.add("h");
		g.put("j", datos);

		// K
		datos = new ArrayList<String>();
		datos.add("m");
		datos.add("n");
		g.put("k", datos);

		// M
		datos = new ArrayList<String>();
		datos.add("k");
		datos.add("n");
		g.put("m", datos);

		// N
		datos = new ArrayList<String>();
		datos.add("k");
		datos.add("m");
		g.put("n", datos);

		// O
		datos = new ArrayList<String>();
		g.put("o", datos);
	}
}
