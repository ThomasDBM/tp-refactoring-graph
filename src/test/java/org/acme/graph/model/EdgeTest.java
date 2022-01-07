package org.acme.graph.model;

import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;

public class EdgeTest {

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
    
}
