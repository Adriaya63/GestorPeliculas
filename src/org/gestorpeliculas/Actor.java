package org.gestorpeliculas;

public class Actor implements Comparable<Actor>{
	private String nombre;
	private ListaNombres filmografia;
	
	//Constructora y metodos sobreescritos
	public Actor(String pNombre) {
		//Constructora de la clase Actor. Recibe un nombre como parameto. No puede ser un string vacio!
		
		this.nombre = pNombre;
		this.filmografia = new ListaNombres();
	}
	
	@Override
	public int compareTo(Actor act) {
		//PRE: Recibe un actor que va a ser comparado con este
		//Post: Devuelve un valor negativo si este actor se ordena despues que act; 0 si tienen la misma prioridad 
		//		y un valor positivo si este actor se ordena antes que act.
		
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		//PRE: recibe un objeto de tipo Actor
		//POST: Devuelve un booleano indicando si son iguales en base a si tienen el mismo nombre;
		
		Actor act = (Actor)obj;
		return act.tieneEsteNombre(this.nombre);
	}
	
	//Metodos
	public void setearFilmografia(ListaNombres pFilmografia){
		//PRE: recibe un objeto de tipo ListaNombres
		//POST: establece la filmografia como la del actor
		this.filmografia = pFilmografia;
	}

	public boolean tieneEsteNombre(String pNombre) {
		//PRE: Recibe un String con un nombre
		//POST: Devuelve un booleano indicando si el actor tiene ese nombre
		
		return this.nombre.equals(pNombre);
	}
	
	public void anadirEstaPeliculaAFilmografia(String pTitulo) {
		//PRE: Recibe un titulo de pelicula
		//POST: Anade ese titulo a la filmografia del actor. Si ya esta, no se hace nada.
		
		this.filmografia.anadirNombre(pTitulo);
	}
	
	public void eliminarEstaPeliculaDeFilmografia(String pTitulo) {
		//PRE: Recibe un titulo de pelicula (String no vacio)
		//POST: Elimina el nombre de la pelicula de la filmografia del actor en caso de contenerla. Si no la deja igual.
		
		this.filmografia.eliminarNombre(pTitulo);
	}
	
	public ListaNombres obtenerFilmografia() {
		//PRE:
		//POST: Devuelve la ListaNombres con la filmografia del actor
		
		return this.filmografia;
	}
	
	public void imprimir() {
		//PRE:
		//POST: imprime informacion sobre el actor
		System.out.println("Nombre: "+this.nombre);
		this.filmografia.imprimir();
	}

}
