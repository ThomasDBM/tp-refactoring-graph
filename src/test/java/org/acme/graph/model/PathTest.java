package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;

public class PathTest {

    private final static double EPSILON = 1.0e-15;

    @Test
    public void testConstructor(){

        Path path = new Path();

        Assert.assertEquals(0, path.getEdges().size());

    }

    @Test
    public void testGetLength(){

        Graph graph = new Graph();

        Vertex a = graph.createVertex(new Coordinate(0.0, 0.0), "a");
		Vertex b = graph.createVertex(new Coordinate(1.0, 0.0), "b");

		Edge ab = graph.createEdge(a, b, "ab");

        Path path = new Path();

        List<Edge> edges = new ArrayList<Edge>();
        edges.add(ab);

        path.setEdges(edges);

        Assert.assertEquals(1.0, path.getLength(), EPSILON);
    }
    
}
