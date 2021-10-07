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
		assertEquals(pel_a.obtenerReparto().getSize(), 0);
		
		pel_a.anadirEsteActorAlReparto("a1");
		assertEquals(pel_a.obtenerReparto().getSize(), 1);
		
		pel_a.obtenerReparto().eliminarNombre("a1");
		assertEquals(pel_a.obtenerReparto().getSize(), 0);
		
		pel_a.anadirEsteActorAlReparto("a1");
		pel_a.anadirEsteActorAlReparto("a2");
		assertEquals(pel_a.obtenerReparto().getSize(), 2);
	}

	@Test
	public void testEliminarEsteActorDelReparto() {
		assertEquals(pel_a.obtenerReparto().getSize(), 0);
		
		pel_a.anadirEsteActorAlReparto("p1");
		assertEquals(pel_a.obtenerReparto().getSize(), 1);
		
		pel_a.eliminarEsteActorDelReparto("p2");
		assertEquals(pel_a.obtenerReparto().getSize(), 1);
		
		pel_a.eliminarEsteActorDelReparto("p1");
		assertEquals(pel_a.obtenerReparto().getSize(), 0);
	}

	@Test
	public void testIncrementarRecaudacionEn() {
		fail("Not yet implemented");
	}

}
