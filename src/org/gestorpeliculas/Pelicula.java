package org.gestorpeliculas;

public class Pelicula {
	private String titulo;
	private int recaudacion;
	private ListaNombres reparto;
	
	public Pelicula(String pTitulo, int pRecaudacion) {
		//Primera constructora de Pelicula. Recibe el titulo y la recaudacion.
		
		this.titulo = pTitulo;
		this.recaudacion = pRecaudacion;
		this.reparto = new ListaNombres();
	}
	
	public Pelicula(String pTitulo) {
		//Segunda constructora de Pelicula. Recibe solo el titulo.
		
		this.titulo = pTitulo;
		this.recaudacion = 0;
		this.reparto = new ListaNombres();
	}
	
	@Override
	public boolean equals(Object obj) {
		//PRE: Recibe un objeto de tipo Pelicula
		//POST: Devuelve un booleano indicando si son iguales en funcion de si tienen el mismo nombre
		
		Pelicula pel = (Pelicula)obj;
		return pel.tieneEsteTitulo(this.titulo);
	}
	
	public boolean tieneEsteTitulo(String pTitulo) {
		//PRE: Recibe un String con el titulo de una pelicula
		//POST: Devuelve un booleano indicando si esta pelicula tiene ese titulo
		
		return this.titulo == pTitulo;
	}
	
	public void anadirEsteActorAlReparto(String pNombreActor) {
		//PRE: Recibe un String con el nombre del actor que es parte del reparto de la pelicula
		//POST: Anade el actor al reparto de la pelicula
		
		this.reparto.anadirNombre(pNombreActor);
	}
	
	public void eliminarEsteActorDelReparto(String pNombreActor) {
		//PRE: Recibe un nombre de un actor
		//POST: Elimina ese nombre de la lista de nombres del reparto de la pelicula
		
		this.reparto.eliminarNombre(pNombreActor);
	}
	
	public ListaNombres obtenerReparto() {
		//PRE:
		//POST: Devuelbe la ListaNombres del reparto de la pelicula
		
		return this.reparto;
	}
	
	public void incrementarRecaudacionEn(int pIncremento) {
		//PRE: Recibe un incremento (positivo o negativo) que es un valor de tipo int
		//POST: Incrementa (o decrementa) el valor de la recaudacion de la pelicula
		
		this.recaudacion += pIncremento;
	}
	
	public void imprimir() {
		//PRE:
		//POST: imprime por consola informacion relevante sobre la pelicula
	}
}
