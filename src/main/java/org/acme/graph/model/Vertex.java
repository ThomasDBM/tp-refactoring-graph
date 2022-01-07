package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Coordinate;

/**
 * 
 * Un sommet dans un graphe
 * 
 * @author MBorne
 *
 */
public class Vertex {

	/**
	 * Identifiant du sommet
	 */
	private String id;

	/**
	 * Position du sommet
	 */
	private Coordinate coordinate;

	/**
	 * Liste des tronçons arrivants sur le vertex
	 */
	List<Edge> inEdges = new ArrayList<Edge>();
	/**
	 * Liste des tronçon partant du vertex
	 */
	List<Edge> outEdges = new ArrayList<Edge>();

	Vertex() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public void setInEdges(List<Edge> edges){
		this.inEdges = edges;
	}

	@JsonIgnore
	public List<Edge> getInEdge(){
		return this.inEdges;
	}

	public void setOutEdges(List<Edge> edges){
		this.outEdges = edges;
	}

	@JsonIgnore
	public List<Edge> getOutEdge(){
		return this.outEdges;
	}

	@Override
	public String toString() {
		return id;
	}

}
