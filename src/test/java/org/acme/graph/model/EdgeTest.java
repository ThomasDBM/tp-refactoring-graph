package org.acme.graph.model;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

public class EdgeTest {

	public final static double EPSILON =1.0e-15;

    @Test
	public void testConstructor(){

        Vertex a = new Vertex();
		a.setId("a");
		a.setCoordinate(new Coordinate(0.0, 0.0));

        Vertex b = new Vertex();
		b.setId("b");
		b.setCoordinate(new Coordinate(1.0, 1.0));

        Edge e = new Edge(a,b);
    
		Assert.assertEquals("a",e.getSource().getId());
        Assert.assertEquals("b",e.getTarget().getId());
        
	}

	@Test
	public void testGetCost(){

		Graph graph = new Graph();

		Vertex a = graph.createVertex(new Coordinate(0.0, 0.0), "a");
		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0), "b");

		Edge ab = graph.createEdge(a, b, "ab");

		Assert.assertEquals(1.0,ab.getCost(),EPSILON);
	}

	@Test
	public void testGetGeometryDefined(){

		Graph graph = new Graph();

		Vertex a = graph.createVertex(new Coordinate(0.0, 0.0), "a");
		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0), "b");

		GeometryFactory gf = new GeometryFactory();
		LineString geometry = gf.createLineString(new Coordinate[] {a.getCoordinate(),b.getCoordinate()});

		Edge ab = graph.createEdge(a, b, "ab");
		ab.setGeometry(geometry);

		Assert.assertEquals(0.0,ab.getGeometry().getStartPoint().getX(),EPSILON);
		Assert.assertEquals(0.0,ab.getGeometry().getStartPoint().getY(),EPSILON);

		Assert.assertEquals(1.0,ab.getGeometry().getEndPoint().getX(),EPSILON);
		Assert.assertEquals(0.0,ab.getGeometry().getEndPoint().getY(),EPSILON);
	}

	@Test
	public void testGetGeometryUndefined(){

		Graph graph = new Graph();

		Vertex a = graph.createVertex(new Coordinate(0.0, 0.0), "a");
		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0), "b");

		Edge ab = graph.createEdge(a, b, "ab");

		Assert.assertEquals(0.0,ab.getGeometry().getStartPoint().getX(),EPSILON);
		Assert.assertEquals(0.0,ab.getGeometry().getStartPoint().getY(),EPSILON);

		Assert.assertEquals(1.0,ab.getGeometry().getEndPoint().getX(),EPSILON);
		Assert.assertEquals(0.0,ab.getGeometry().getEndPoint().getY(),EPSILON);
	}
    
}
