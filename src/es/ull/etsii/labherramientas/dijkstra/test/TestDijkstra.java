package es.ull.etsii.labherramientas.dijkstra.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import es.ull.etsii.labherramientas.dijkstra.Arista;
import es.ull.etsii.labherramientas.dijkstra.Dijkstra;
import es.ull.etsii.labherramientas.dijkstra.Vertice;

public class TestDijkstra 
{
	private Dijkstra m_Algoritmo;
	private Vertice[] m_Vertices;
	private Double m_Resultado;
	private Vertice v1;
	private Vertice v2;
	
	@Before
	public void antesDelTest() {
		/**
		 * El metodo precedido por la etiqueta @Before
		 * es para indicar a JUnit que debe ejecutarlo
		 * antes de ejecutar los Tests que figuran en
		 * esta clase.
		 */
		Vertice v0 = new Vertice("SantaCruz");
		Vertice v1 = new Vertice("LaLaguna");
		Vertice v2 = new Vertice("Tacoronte");
		Vertice v3 = new Vertice("Candelaria");
		Vertice v4 = new Vertice("Guimar");

		v0.adjacencies = new Arista[]{ new Arista(v1, 10), new Arista(v2, 24), new Arista(v3, 16) };
		v1.adjacencies = new Arista[]{ new Arista(v0, 10), new Arista(v2, 14), new Arista(v4, 40) };
		v2.adjacencies = new Arista[]{ new Arista(v0, 24), new Arista(v1, 14) };	
		v3.adjacencies = new Arista[]{ new Arista(v0, 16), new Arista(v4, 24) };
		v4.adjacencies = new Arista[]{ new Arista(v1, 40), new Arista(v3, 24) };
		Vertice[] vertices = { v0, v1, v2, v3, v4 };
		m_Vertices = vertices;
		m_Algoritmo.computePaths(v0);
	}

	@After
	public void despuesDelTest() {
		/**
		 * La etiqueta @After es la antítesis de @Before.
		 * Simplemente este metodo se ejecutara despues de
		 * ejecutar todos los tests de esta clase.
		 */
	}

	@Test
	public void testSantaCruz() 
	{	
		Vertice v0 = m_Vertices[0];
		m_Resultado = v0.minDistance;
		assertTrue(m_Resultado == 0.0);
	}
	
	@Test
	public void testLaLaguna() 
	{	
		Vertice v1 = m_Vertices[1];
		m_Resultado = v1.minDistance;
		assertTrue(m_Resultado == 10.0);
	}
	
	@Test
	public void testTacoronte() 
	{	
		Vertice v2 = m_Vertices[2];
		m_Resultado = v2.minDistance;
		assertTrue(m_Resultado == 24.0);
	}
	
	@Test
	public void testCandelaria() 
	{	
		Vertice v = m_Vertices[3];
		m_Resultado = v.minDistance;
		assertTrue(m_Resultado == 16.0);
	}
	
	@Test
	public void testGuimar() 
	{	
		Vertice v = m_Vertices[4];
		m_Resultado = v.minDistance;
		assertTrue(m_Resultado == 40.0);
	}
	
	@Test
	public void testVectorGuimar() 
	{	
		List<Vertice> vertices = m_Algoritmo.getShortestPathTo(m_Vertices[4]);
		int resultado = vertices.size();
		assertTrue(resultado == 3);
	}
	
	@Test
	public void testVectorCandelaria() 
	{	
		List<Vertice> vertices = m_Algoritmo.getShortestPathTo(m_Vertices[3]);
		int resultado = vertices.size();
		assertTrue(resultado == 2);
	}
	
	@Test
	public void testVectorLaLaguna() 
	{	
		List<Vertice> vertices = m_Algoritmo.getShortestPathTo(m_Vertices[2]);
		int resultado = vertices.size();
		assertTrue(resultado == 2);
	}
	
	@Test
	public void testVectorTacoronte() 
	{	
		List<Vertice> vertices = m_Algoritmo.getShortestPathTo(m_Vertices[4]);
		int resultado = vertices.size();
		assertTrue(resultado == 3);
	}
	
	@Test
	public void testVertices() 
	{	
		assertTrue(v1.compareTo(v2) == 0);
	}
	
}
