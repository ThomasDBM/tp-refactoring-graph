package org.acme.graph;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;
import org.locationtech.jts.geom.Coordinate;

public class TestGraphFactory {

	/**
	 * d / / a--b--c
	 * 
	 * @return
	 */
	public static Graph createGraph01() {
		Graph graph = new Graph();

		/*Vertex a = new Vertex();
		a.setId("a");
		a.setCoordinate(new Coordinate(0.0, 0.0));
		graph.getVertices().add(a);*/
		Vertex a = graph.createVertex(new Coordinate(0.0, 0.0), "a");

		/*Vertex b = new Vertex();
		b.setId("b");
		b.setCoordinate(new Coordinate(1.0, 0.0));
		graph.getVertices().add(b);*/
		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0), "b");

		/*Vertex c = new Vertex();
		c.setId("c");
		c.setCoordinate(new Coordinate(2.0, 0.0));
		graph.getVertices().add(c);*/
		Vertex c = graph.createVertex(new Coordinate(2.0, 0.0), "c");

		/*Vertex d = new Vertex();
		d.setId("d");
		d.setCoordinate(new Coordinate(1.0, 1.0));
		graph.getVertices().add(d);*/
		Vertex d = graph.createVertex(new Coordinate(1.0, 1.0), "d");

		/*Edge ab = new Edge(a,b);
		ab.setId("ab");
		ab.setSource(a);
		ab.setTarget(b);
		graph.getEdges().add(ab);*/
		graph.createEdge(a, b, "ab");

		/*Edge bc = new Edge(b,c);
		bc.setId("bc");
		bc.setSource(b);
		bc.setTarget(c);
		graph.getEdges().add(bc);*/
		graph.createEdge(b, c, "bc");

		/*Edge ad = new Edge(a,d);
		ad.setId("ad");
		ad.setSource(a);
		ad.setTarget(d);
		graph.getEdges().add(ad);*/
		graph.createEdge(a, d, "ad");

		return graph;
	}

}
