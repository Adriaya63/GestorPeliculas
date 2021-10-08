package org.gestorpeliculas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActorTest {
	
	private Actor act_a, act_A, act_b, act_B;
	
	@Before
	public void setUp() throws Exception {
		act_a= new Actor("a");
		act_A= new Actor("A");
		act_b = new Actor("b");
		act_B = new Actor("B");
	}

	@After
	public void tearDown() throws Exception {
		act_a = null;
		act_A = null;
		act_b = null;
		act_B = null;
	}
	
	@Test
	public void testCompareTo() {
		Actor act_ab = new Actor("ab");
		Actor act_ba = new Actor("ba");
		Actor act_aa = new Actor("aa");
		Actor act_aB = new Actor("aB");
		
		assertEquals(act_a.compareTo(act_a), 0);
		assertEquals(act_a.compareTo(new Actor("a")), 0);
		assertEquals(act_aB.compareTo(act_aB), 0);
		assertEquals(act_aB.compareTo(new Actor("aB")), 0);
		
		
		assertTrue(act_a.compareTo(act_A) > 0);
		assertTrue(act_b.compareTo(act_a) > 0);
		assertTrue(act_a.compareTo(act_B) > 0);
		assertTrue(act_ba.compareTo(act_ab) > 0);
		assertTrue(act_aa.compareTo(act_aB) > 0);
		
		assertTrue(act_A.compareTo(act_a) < 0);
		assertTrue(act_a.compareTo(act_b) < 0);
		assertTrue(act_ab.compareTo(act_ba) < 0);
		
		Actor act_1 = new Actor("1");
		Actor act_2 = new Actor("2");
		
		assertTrue(act_1.compareTo(act_2) < 0);
		assertTrue(act_2.compareTo(act_1) > 0);
		assertTrue(act_1.compareTo(act_A) < 0);
		assertTrue(act_1.compareTo(act_a) < 0);
	}

	@Test
	public void testEqualsObject() {
		assertTrue(act_a.equals(act_a));
		assertTrue(act_a.equals(new Actor("a")));
		
		assertFalse(act_a.equals(act_A));
		assertFalse(act_a.equals(new Actor("b")));
	}

	@Test
	public void testTieneEsteNombre() {
		assertTrue(act_a.tieneEsteNombre("a"));
		assertFalse(act_a.tieneEsteNombre(""));
		assertFalse(act_a.tieneEsteNombre("A"));
	}

	@Test
	public void testAnadirEstaPeliculaAFilmografia() {
		assertFalse(act_a.obtenerFilmografia().esta(""));
		assertFalse(act_a.obtenerFilmografia().esta("p1"));
		
		act_a.anadirEstaPeliculaAFilmografia("p1");
		assertTrue(act_a.obtenerFilmografia().esta("p1"));
		
		act_a.obtenerFilmografia().eliminarNombre("p1");
		assertFalse(act_a.obtenerFilmografia().esta("p1"));
		
		act_a.anadirEstaPeliculaAFilmografia("p1");
		act_a.anadirEstaPeliculaAFilmografia("p2");
		assertTrue(act_a.obtenerFilmografia().esta("p1"));
		assertTrue(act_a.obtenerFilmografia().esta("p2"));
	}

	@Test
	public void testEliminarEstaPeliculaDeFilmografia() {
		assertFalse(act_a.obtenerFilmografia().esta(""));
		assertFalse(act_a.obtenerFilmografia().esta("p1"));
		
		act_a.anadirEstaPeliculaAFilmografia("p1");
		assertTrue(act_a.obtenerFilmografia().esta("p1"));
		
		act_a.eliminarEstaPeliculaDeFilmografia("p2");
		assertTrue(act_a.obtenerFilmografia().esta("p1"));
		assertFalse(act_a.obtenerFilmografia().esta("p2"));
		
		act_a.eliminarEstaPeliculaDeFilmografia("p1");
		assertFalse(act_a.obtenerFilmografia().esta("p1"));
	}


}
