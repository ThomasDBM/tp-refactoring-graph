package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
    
    private List<Edge> edges;

    public Path(){
        this.edges = new ArrayList<Edge>();
    }

    public void setEdges(List<Edge> edges){
        this.edges = edges;
    }

    public List<Edge> getEdges(){
        return this.edges;
    }

    public long getLength(){
        long length = 0;
        for (Edge edge:edges){
            length += edge.getCost();
        }
        return length;
    }

}
