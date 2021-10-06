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
		assertEquals(lista.getSize(), 0);
		
		lista.anadirNombre("");
		assertEquals(lista.getSize(), 0);
		
		lista.anadirNombre("a1");
		assertEquals(lista.getSize(), 1);
		
		lista.anadirNombre("a1");
		assertEquals(lista.getSize(), 1);
		
		lista.anadirNombre("a2");
		assertEquals(lista.getSize(), 2);
	}
	
	@Test
	public final void testEliminarNombre() {
		assertEquals(lista.getSize(), 0);
		
		lista.eliminarNombre("");
		assertEquals(lista.getSize(), 0);
		
		lista.eliminarNombre("a1");
		assertEquals(lista.getSize(), 0);
		
		lista.anadirNombre("a1");
		assertEquals(lista.getSize(), 1);
		lista.eliminarNombre("");
		assertEquals(lista.getSize(), 1);
		lista.eliminarNombre("a1");
		assertEquals(lista.getSize(), 0);
		
		lista.anadirNombre("a1");
		lista.anadirNombre("a2");
		assertEquals(lista.getSize(), 2);
		lista.eliminarNombre("a1");
		assertEquals(lista.getSize(), 1);
	}

}
