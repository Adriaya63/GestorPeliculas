package org.gestorpeliculas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ColeccionActoresTest {
	
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
	public void testBuscarActor() {
		assertEquals(colAct.buscarActor(""), null);
		assertEquals(colAct.buscarActor("a"), null);
		
		ListaNombres filmografia1 = new ListaNombres();
		filmografia1.anadirNombre("p1");
		
		colAct.anadirActor("a1", filmografia1);
		assertTrue(colAct.buscarActor("a1").tieneEsteNombre("a1"));
		assertEquals(colAct.buscarActor("b"), null);
		
		colAct.anadirActor("a2", filmografia1);
		assertTrue( colAct.buscarActor("a2").tieneEsteNombre("a2"));
	}

	@Test
	public void testAnadirActor() {
		ListaNombres filmografia1 = new ListaNombres();
		colAct.anadirActor("", filmografia1);
		assertEquals(colAct.buscarActor(""), null);
		
		colAct.anadirActor("a", filmografia1);
		assertEquals(colAct.buscarActor("a"), null);
		
		filmografia1.anadirNombre("p1");
		colAct.anadirActor("", filmografia1);
		assertEquals(colAct.buscarActor(""), null);
		
		colAct.anadirActor("a1", filmografia1);
		Actor a1 = colAct.buscarActor("a1");
		assertTrue(a1.tieneEsteNombre("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p1"));
		Pelicula p1 = cp.buscarPelicula("p1");
		assertTrue(p1.tieneEsteTitulo("p1"));
		assertTrue(p1.obtenerReparto().esta("a1"));
		
		
		filmografia1.anadirNombre("p2");
		colAct.anadirActor("a1", filmografia1);
		a1 = colAct.buscarActor("a1");
		assertTrue(a1.tieneEsteNombre("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p1"));
		assertTrue(a1.obtenerFilmografia().esta("p2"));
		p1 = cp.buscarPelicula("p1");
		assertTrue(p1.tieneEsteTitulo("p1"));
		assertTrue(p1.obtenerReparto().esta("a1"));
		Pelicula p2 = cp.buscarPelicula("p2");
		assertTrue(p2.tieneEsteTitulo("p2"));
		assertTrue(p2.obtenerReparto().esta("a1"));
		
	}

	@Test
	public void testEliminarActor() {
		ListaNombres filmografia1 = new ListaNombres();
		colAct.eliminarActor("");
		assertEquals(colAct.buscarActor(""), null);
		
		colAct.anadirActor("a1", filmografia1);
		assertEquals(colAct.buscarActor("a1"), null);
		colAct.eliminarActor("a1");
		assertEquals(colAct.buscarActor("a1"), null);
		
		filmografia1.anadirNombre("p1");
		colAct.anadirActor("a1", filmografia1);
		Actor a1 = colAct.buscarActor("a1");
		assertTrue(a1.tieneEsteNombre("a1"));
		assertTrue(a1.obtenerFilmografia().esta("p1"));
		Pelicula p1 = cp.buscarPelicula("p1");
		assertTrue(p1.tieneEsteTitulo("p1"));
		assertTrue(p1.obtenerReparto().esta("a1"));
		colAct.eliminarActor("a1");
		assertEquals(colAct.buscarActor("a1"), null);
		assertEquals(cp.buscarPelicula("p1"), null);
		
		colAct.anadirActor("a1", filmografia1);
		ListaNombres filmografia2 = new ListaNombres();
		filmografia2.anadirNombre("p2");
		colAct.anadirActor("a2", filmografia2);
		colAct.eliminarActor("a1");
		assertEquals(colAct.buscarActor("a1"), null);
		assertEquals(cp.buscarPelicula("p1"), null);
		Actor a2 = colAct.buscarActor("a2");
		Pelicula p2 = cp.buscarPelicula("p2");
		assertTrue(a2.obtenerFilmografia().esta("p2"));
		assertTrue(p2.obtenerReparto().esta("a2"));
		
		colAct.anadirActor("a1", filmografia1);
		filmografia2.anadirNombre("p1");
		colAct.anadirActor("a2", filmografia2);
		colAct.eliminarActor("a1");
		assertEquals(colAct.buscarActor("a1"), null);
		a2 = colAct.buscarActor("a2");
		p1 = cp.buscarPelicula("p1");
		p2 = cp.buscarPelicula("p2");
		assertTrue(a2.obtenerFilmografia().esta("p1"));
		assertTrue(a2.obtenerFilmografia().esta("p2"));
		assertTrue(p1.obtenerReparto().esta("a2"));
		assertTrue(p2.obtenerReparto().esta("a2"));
		
		colAct.anadirActor("a1", filmografia1);
		colAct.eliminarActor("a2");
		assertEquals(colAct.buscarActor("a2"), null);
		assertEquals(cp.buscarPelicula("p2"), null);
		a1 = colAct.buscarActor("a1");
		p1 = cp.buscarPelicula("p1");
		assertTrue(a1.obtenerFilmografia().esta("p1"));
		assertTrue(p1.obtenerReparto().esta("a1"));
		
	}

	@Test
	public void testObtenerFilmografiaDeActor() {
		ListaNombres filmografia1 = new ListaNombres();
		colAct.anadirActor("", filmografia1);
		assertEquals(colAct.obtenerFilmografiaDeActor(""), null);
		
		colAct.anadirActor("a1", filmografia1);
		assertEquals(colAct.obtenerFilmografiaDeActor("a1"), null);
		
		filmografia1.anadirNombre("p1");
		colAct.anadirActor("a1", filmografia1);
		assertTrue(colAct.buscarActor("a1").tieneEsteNombre("a1"));
		assertTrue(colAct.obtenerFilmografiaDeActor("a1").esta("p1"));
		
		assertEquals(colAct.obtenerFilmografiaDeActor("a2"), null);
	}

}
