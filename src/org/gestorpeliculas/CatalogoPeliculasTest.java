package org.gestorpeliculas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CatalogoPeliculasTest {
	
	private CatalogoPeliculas cp;
	private ColeccionActores colAct;
	
	@Before
	public void setUp() throws Exception {
		this.cp = CatalogoPeliculas.getCatalogo();
		this.colAct = ColeccionActores.getColAct();
		
	}

	@After
	public void tearDown() throws Exception {
		CatalogoPeliculas.eliminarCatalogo();
		ColeccionActores.eliminarColeccion();
	}

	@Test
	public void testBuscarPelicula() {
		assertEquals(cp.buscarPelicula(""), null);
		assertEquals(cp.buscarPelicula("p"), null);
		
		ListaNombres reparto1 = new ListaNombres();
		reparto1.anadirNombre("a1");
		
		cp.anadirPelicula("p1", reparto1);
		assertTrue(cp.buscarPelicula("p1").tieneEsteTitulo("p1"));
		assertEquals(cp.buscarPelicula("b"), null);
		
		cp.anadirPelicula("p2", reparto1);
		assertTrue(cp.buscarPelicula("p2").tieneEsteTitulo("p2"));
		
	}

	@Test
	public void testAnadirPelicula() {
		ListaNombres reparto1 = new ListaNombres();
		cp.anadirPelicula("", reparto1);
		assertEquals(cp.buscarPelicula(""), null);
		
		cp.anadirPelicula("p", reparto1);
		assertEquals(cp.buscarPelicula("p"), null);
		
		reparto1.anadirNombre("a1");
		cp.anadirPelicula("", reparto1);
		assertEquals(cp.buscarPelicula(""), null);
		
		cp.anadirPelicula("p", reparto1);
		assertTrue(cp.buscarPelicula("p").tieneEsteTitulo("p"));
		Actor a1 = colAct.buscarActor("a1");
		assertTrue(a1.tieneEsteNombre("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p"));
		
		
		reparto1.anadirNombre("a2");
		cp.anadirPelicula("p", reparto1);
		assertTrue(cp.buscarPelicula("p").tieneEsteTitulo("p"));
		a1 = colAct.buscarActor("a1");
		assertTrue(a1.tieneEsteNombre("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p"));
		Actor a2 = colAct.buscarActor("a2");
		assertTrue(a2.tieneEsteNombre("a2"));
		assertTrue(a2.obtenerFilmografia().esta("p"));
		
		
		cp.anadirPelicula("p2", reparto1);
		assertTrue(cp.buscarPelicula("p").tieneEsteTitulo("p"));
		a1 = colAct.buscarActor("a1");
		assertTrue(a1.tieneEsteNombre("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p2"));
		a2 = colAct.buscarActor("a2");
		assertTrue(a2.tieneEsteNombre("a2"));
		assertTrue(a2.obtenerFilmografia().esta("p2"));
		
		
	}

	@Test
	public void testEliminarPelicula() {
		ListaNombres reparto1 = new ListaNombres();
		cp.eliminarPelicula("");
		assertEquals(cp.buscarPelicula(""), null);
		
		cp.anadirPelicula("p1", reparto1);
		assertEquals(cp.buscarPelicula("p1"), null);
		cp.eliminarPelicula("p1");
		assertEquals(cp.buscarPelicula("p1"), null);
		
		reparto1.anadirNombre("a1");
		cp.anadirPelicula("p1", reparto1);
		Pelicula p1 = cp.buscarPelicula("p1");
		assertTrue(p1.tieneEsteTitulo("p1"));
		assertTrue(p1.obtenerReparto().esta("a1"));
		Actor a1 = colAct.buscarActor("a1");
		assertTrue(a1.tieneEsteNombre("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p1"));
		cp.eliminarPelicula("p1");
		assertEquals(cp.buscarPelicula("p1"), null);
		assertEquals(colAct.buscarActor("a1"), null);
		
		cp.anadirPelicula("p1", reparto1);
		ListaNombres reparto2 = new ListaNombres();
		reparto2.anadirNombre("a2");
		cp.anadirPelicula("p2", reparto2);
		cp.eliminarPelicula("p1");
		assertEquals(cp.buscarPelicula("p1"), null);
		assertEquals(colAct.buscarActor("a1"), null);
		Pelicula p2 = cp.buscarPelicula("p2");
		Actor a2 = colAct.buscarActor("a2");
		assertTrue(p2.obtenerReparto().esta("a2"));
		assertTrue(a2.obtenerFilmografia().esta("p2"));
		
		cp.anadirPelicula("p1", reparto1);
		reparto2.anadirNombre("a1");
		cp.anadirPelicula("p2", reparto2);
		cp.eliminarPelicula("p1");
		assertEquals(cp.buscarPelicula("p1"), null);
		p2 = cp.buscarPelicula("p2");
		a1 = colAct.buscarActor("a1");
		a2 = colAct.buscarActor("a2");
		assertTrue(p2.obtenerReparto().esta("a2"));
		assertTrue(a1.obtenerFilmografia().esta("p2"));
		assertTrue(a2.obtenerFilmografia().esta("p2"));
		
		
		cp.anadirPelicula("p1", reparto1);
		cp.eliminarPelicula("p2");
		assertEquals(cp.buscarPelicula("p2"), null);
		assertEquals(colAct.buscarActor("a2"), null);
		p1 = cp.buscarPelicula("p1");
		a1 = colAct.buscarActor("a1");
		assertTrue(p1.obtenerReparto().esta("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p1"));
		
	}

	@Test
	public void testObtenerRepartoDePelicula() {
		ListaNombres reparto1 = new ListaNombres();
		cp.anadirPelicula("", reparto1);
		assertEquals(cp.obtenerRepartoDePelicula(""), null);
		
		cp.anadirPelicula("p1", reparto1);
		assertEquals(cp.obtenerRepartoDePelicula("p1"), null);
		
		reparto1.anadirNombre("a1");
		cp.anadirPelicula("p1", reparto1);
		assertTrue(cp.buscarPelicula("p1").tieneEsteTitulo("p1"));
		assertTrue(cp.obtenerRepartoDePelicula("p1").esta("a1"));
		
		assertEquals(cp.obtenerRepartoDePelicula("p2"), null);
		
	}

}
