package org.gestorpeliculas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PeliculaTest {

	private Pelicula pel_a, pel_A, pel_b; 
	
	@Before
	public void setUp() throws Exception {
		pel_a = new Pelicula("a");
		pel_A = new Pelicula("A");
		pel_b = new Pelicula("b");
	}

	@After
	public void tearDown() throws Exception {
		pel_a = null;
		pel_A = null;
		pel_b = null;
	}

	@Test
	public void testEqualsObject() {
		assertTrue(pel_a.equals(pel_a));
		assertTrue(pel_a.equals(new Pelicula("a")));
		
		assertFalse(pel_a.equals(pel_A));
		assertFalse(pel_a.equals(pel_b));
	}

	@Test
	public void testTieneEsteTitulo() {
		assertTrue(pel_a.tieneEsteTitulo("a"));
		assertFalse(pel_a.tieneEsteTitulo(""));
		assertFalse(pel_a.tieneEsteTitulo("A"));
	}

	@Test
	public void testAnadirEsteActorAlReparto() {
		
		pel_a.anadirEsteActorAlReparto("a1");
		assertTrue(pel_a.obtenerReparto().esta("a1"));
		
		pel_a.obtenerReparto().eliminarNombre("a1");
		assertFalse(pel_a.obtenerReparto().esta("a1"));
		
		pel_a.anadirEsteActorAlReparto("a1");
		pel_a.anadirEsteActorAlReparto("a2");
		assertTrue(pel_a.obtenerReparto().esta("a1"));
		assertTrue(pel_a.obtenerReparto().esta("a2"));
	}

	@Test
	public void testEliminarEsteActorDelReparto() {
		
		pel_a.anadirEsteActorAlReparto("p1");
		assertTrue(pel_a.obtenerReparto().esta("p1"));
		assertFalse(pel_a.obtenerReparto().esta("p2"));
		
		pel_a.eliminarEsteActorDelReparto("p2");
		assertTrue(pel_a.obtenerReparto().esta("p1"));
		assertFalse(pel_a.obtenerReparto().esta("p2"));
		
		pel_a.eliminarEsteActorDelReparto("p1");
		assertFalse(pel_a.obtenerReparto().esta("p1"));
	}
	
}
