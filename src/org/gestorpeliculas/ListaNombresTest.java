package org.gestorpeliculas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaNombresTest {
	
	private ListaNombres lista;
	
	@Before
	public void setUp() throws Exception {
		lista = new ListaNombres();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}

	@Test
	public final void testAnadirNombre() {
		
		lista.anadirNombre("");
		assertFalse(lista.esta(""));
		
		lista.anadirNombre("a1");
		assertTrue(lista.esta("a1"));
		
		lista.anadirNombre("a1");
		assertTrue(lista.esta("a1"));
		assertFalse(lista.esta("a2"));
		
		
		lista.anadirNombre("a2");
		assertTrue(lista.esta("a2"));
	}
	
	@Test
	public final void testEliminarNombre() {
		assertFalse(lista.esta(""));
		lista.eliminarNombre("");
		
		assertFalse(lista.esta("a1"));
		lista.eliminarNombre("a1");
		assertFalse(lista.esta("a1"));
		
		lista.anadirNombre("a1");
		assertTrue(lista.esta("a1"));
		lista.eliminarNombre("");
		assertTrue(lista.esta("a1"));
		lista.eliminarNombre("a1");
		assertFalse(lista.esta("a1"));
		
		lista.anadirNombre("a1");
		lista.anadirNombre("a2");
		assertTrue(lista.esta("a1"));
		assertTrue(lista.esta("a2"));
		lista.eliminarNombre("a1");
		assertFalse(lista.esta("a1"));
	}

}
