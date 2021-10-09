package org.gestorpeliculas;

public class Aplicacion {
	private static Aplicacion aplicacion;
	private GestorDeFicheros gdf;
	private Consola console;
	
	//Contructora y getters
	private Aplicacion() {
		this.console = new Consola();
		
		try {
			this.gdf = GestorDeFicheros.gestorDeFicheros();
		} catch (Exception e) {
			
			console.log("Error fatal iniciando el gestor de ficheros.");
			console.esperarEnter("Pulsa enter para ver el error");
			
			e.printStackTrace();
		}
	}
	
	public static Aplicacion aplicacion() {
		if(aplicacion == null) aplicacion = new Aplicacion();
		return aplicacion;
	}
	
	public static void main(String[] args) {
		Aplicacion.aplicacion().initApp();
	}
	
	public void initApp(){
		//PRE:
		//POST: metodo principal que pedira por consola la accion a realizar
		
		String nombreActor = "";
		String nombrePelicula = "";
		boolean terminado = false;
		
		while(!terminado){
			console.imprimirMenuPrincipal();
			int res = console.leerInt("Seleccione una de las opciones disponibles");
			
			switch(res) {
				case 0:
					console.imprimirMenu0();
					this.cargarDatosDeFichero();
				break;
				
				case 1:
					console.imprimirMenu1();
					nombreActor = console.leerString("Introduzca el nombre del actor que quiere buscar.");
					this.buscarActor(nombreActor);
				break;
				
				case 2:
					console.imprimirMenu2();
					nombreActor = console.leerString("Introduzca el nombre del actor que quiere añadir.");
					ListaNombres fil = console.leerFilmografia();
					this.anadirActor(nombreActor, fil);
				break;
				
				case 3:
					console.imprimirMenu3();
					nombreActor = console.leerString("Introduzca el nombre del actor.");
					this.imprimirFilmografiaActor(nombreActor);
				break;
				
				case 4:
					console.imprimirMenu4();
					nombrePelicula = console.leerString("Introduzca el nombre de la pelicula.");
					this.imprimirRepartoPelicula(nombrePelicula);
				break;
				
				case 5:
					console.imprimirMenu5();
					nombrePelicula = console.leerString("Introduzca el nombre de la pelicula");
					int cant = console.leerInt("Introduzca la recaudacion de la pelicula");
					this.incrementarRecaudacionPelicula(nombrePelicula, cant);
				break;
				
				case 6:
					console.imprimirMenu6();
					nombreActor = console.leerString("Introduzca el nombre del actor que quiere eliminar.");
					this.eliminarActor(nombreActor);
				break;
				
				case 7:
					console.imprimirMenu7();
					this.guardarDatosEnFichero();
					terminado = true;
				break;
				
				case 8:
					console.imprimirMenu8();
					this.imprimirListaOrdenadaDeActores();
				break;
				
				default:
					terminado = true;
				break;
			}
			
			if(!terminado) {
				console.esperarEnter("Pulsa enter para continuar");
			}
		}
		
		this.closeApp();
	}
	
	private void closeApp() {
		console.close();
		gdf.cerrarFicheroEntrada();
		gdf.cerrarFicheroSalida();
	}
	
	private void cargarDatosDeFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de cargar todos los datos de la aplicacion
		
		this.gdf.cargarDatos();
	}
	
	private void guardarDatosEnFichero() {
		//PRE:
		//POST: Llama a la clase GestorDeFicheros para que se encargue de guardar todos los datos de la aplicacion
		
		this.gdf.guardarDatos();
	}
	
	private void buscarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de buscar el actor y devolverlo en caso de encontrarlo.
		//		En caso contrario devolverá null.
		Actor actor = ColeccionActores.getColAct().buscarActor(pNombreActor);
		
		if(actor == null) {
			console.log("Actor no encontrado.");
		}else {
			actor.imprimir();
		}
	}
	
	private void anadirActor(String pNombreActor, ListaNombres pFilmografia) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de anadir ese actor a la aplicacion
		ColeccionActores.getColAct().anadirActor(pNombreActor, pFilmografia);
		Actor actor = ColeccionActores.getColAct().buscarActor(pNombreActor);
		
		if(actor != null ) {
			console.log("Actor añadido/actualizado correctamente");
		}else {
			console.log("Error añadiendo el actor");
		}
	}
	
	private void eliminarActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: Llama a ColeccionActores para que se encargue de elminar a ese actor. Si ese actor no esta anadico se indicará.
		ColeccionActores.getColAct().eliminarActor(pNombreActor);
		Actor actor = ColeccionActores.getColAct().buscarActor(pNombreActor);
		
		if(actor == null ) {
			console.log("Actor eliminado correctamente");
		}else {
			console.log("Error eliminando el actor");
		}
	}
	
	private void imprimirFilmografiaActor(String pNombreActor) {
		//PRE: Recibe el nombre de un actor en formato String
		//POST: LLama a ColeccionActores para que se encarge de obtener la filmografia del actor. en caso de que el actor no exista
		// 		devolvera null.
		ListaNombres filmografia = ColeccionActores.getColAct().obtenerFilmografiaDeActor(pNombreActor);
		
		if(filmografia != null) {
			filmografia.imprimir();
		}else {
			console.log("No se pudo obtener la filmografia de " + pNombreActor);
		}
		
	}
	
	private void imprimirRepartoPelicula(String pTitulo) {
		//PRE: Recibe el titulo de una pelicula en formato String
		//POST: LLama a CatalogoPeliculas para que se encarge de obtener el reparto de la pelicula. en caso de que la pelicula no exista
		// 		devolvera null.
		
		ListaNombres reparto = CatalogoPeliculas.getCatalogo().obtenerRepartoDePelicula(pTitulo);
		
		if(reparto != null) {
			reparto.imprimir();
		}else {
			console.log("No se pudo obtener el reparto de la pelicula " + pTitulo);
		}
		
	}
	
	private void incrementarRecaudacionPelicula(String pTitulo, int pIncremento) {
		//PRE: Recibe el titulo de una pelicula en formato String y un int que conforma el incremento de la recaudacion de la pelicula
		//POST: Llama a CatalogoPeliculas para que se encargue de buscar la pelicula e incermentar su recaudacion en caso de encontrarla.
		//		En caso contrario se indicará que la pelicula no esta añadida.
		Pelicula pel = CatalogoPeliculas.getCatalogo().buscarPelicula(pTitulo);
		if(pel != null) {
			pel.incrementarRecaudacionEn(pIncremento);
		}else {
			console.log("No se pudo encontrar la pelicula " + pTitulo);
		}
		
	}
	
	private void imprimirListaOrdenadaDeActores() {
		//PRE:
		//POST: Se encarga de imprimir una lista ordenada de actores
		
		ListaActores listaOrdenada = ColeccionActores.getColAct().obtenerListaOrdenada();
		
		if(listaOrdenada != null) {
			listaOrdenada.imprimir();
		}else {
			console.log("No hay una lista de actores en la aplicacion.");
		}
		
	}
}
