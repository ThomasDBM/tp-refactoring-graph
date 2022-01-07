package org.acme.graph.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.acme.graph.TestGraphFactory;
import org.acme.graph.errors.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;

public class GraphTest {

	private final static double EPSILON = 1.0e-15;

	@Test
	public void testCreateVertex(){

		Vertex d = new Vertex();
		d.setId("d");
		d.setCoordinate(new Coordinate(1.0, 1.0));

		Graph graph = new Graph();
		Vertex e = graph.createVertex(new Coordinate(1.0, 1.0), "d");

		assertEquals(d.getId(), e.getId());
		assertEquals(d.getCoordinate().x, e.getCoordinate().x, EPSILON);
		assertEquals(d.getCoordinate().y, e.getCoordinate().y, EPSILON);
	}

	@Test
	public void testCreateEdge(){
		Vertex a = new Vertex();
		a.setId("a");
		a.setCoordinate(new Coordinate(1.0, 1.0));
		Vertex b = new Vertex();
		b.setId("b");
		b.setCoordinate(new Coordinate(2.0, 2.0));

		Graph graph = new Graph();
		Edge ab = graph.createEdge(a, b, "ab");

		assertEquals(a.getId(), ab.getSource().getId());
		assertEquals(a.getCoordinate().x, ab.getSource().getCoordinate().x, EPSILON);
		assertEquals(a.getCoordinate().y, ab.getSource().getCoordinate().y, EPSILON);

		assertEquals(b.getId(), ab.getTarget().getId());
		assertEquals(b.getCoordinate().x, ab.getTarget().getCoordinate().x, EPSILON);
		assertEquals(b.getCoordinate().y, ab.getTarget().getCoordinate().y, EPSILON);
	}

	@Test
	public void testFindVertexById() {
		Vertex v = TestGraphFactory.createGraph01().findVertex("a");
		assertNotNull(v);
		assertEquals("a", v.getId());
	}

	@Test
	public void testFindVertexByIdNotFound() {
		Graph g = TestGraphFactory.createGraph01();
		NotFoundException e = Assert.assertThrows(NotFoundException.class, () -> g.findVertex("missing"));
		assertEquals("Vertex 'missing' not found", e.getMessage());
	}

	@Test
	public void testFindVertexByCoordinate() {
		Coordinate c = new Coordinate(0.0, 0.0);
		Vertex v = TestGraphFactory.createGraph01().findVertex(c);
		assertNotNull(v);
		assertEquals("a", v.getId());
	}

	@Test
	public void testFindVertexByCoordinateNotFound() {
		Graph g = TestGraphFactory.createGraph01();
		Coordinate c = new Coordinate(888.0, 999.0);
		NotFoundException e = Assert.assertThrows(NotFoundException.class, () -> g.findVertex(c));
		assertEquals("Vertex not found at [888.0,999.0]", e.getMessage());
	}

	@Test
	public void testGetOutEdges() {
		Graph g = TestGraphFactory.createGraph01();
		Vertex a = g.findVertex("a");
		assertNotNull(a);
		List<Edge> result = g.getOutEdges(a);
		assertEquals(2, result.size());
		assertEquals("ab (a->b)", result.get(0).toString());
		assertEquals("ad (a->d)", result.get(1).toString());
	}

	@Test
	public void testGetInEdges() {
		Graph g = TestGraphFactory.createGraph01();
		Vertex b = g.findVertex("b");
		assertNotNull(b);
		List<Edge> result = g.getInEdges(b);
		assertEquals(1, result.size());
		assertEquals("ab (a->b)", result.get(0).toString());
	}

}
