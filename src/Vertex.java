/*
 * This object represents a Vertex within a graph.
 * Each edge to other vertices is kept in the Vertex object as
 * an adjacency list.  A hashmap of weights is maintained if the 
 * graph is weighted.
 * 
 * @author sspurlock
 * @version 2019-10-21
 */
import java.util.*;

public class Vertex {
	private String myName;
	private HashMap<Vertex, Double> myEdges;

	public Vertex(String name){
		myName = name;
		myEdges = new HashMap<Vertex, Double>();
	}

	public String getName(){
		return myName;
	}
	
	// If a vertex is added with no weight, assume its weight is 1.
	public void addEdge(Vertex j){
		myEdges.put(j,1.0);
	}

	public void addEdge(Vertex j, Double weight){
		myEdges.put(j, weight);
	}
	
	public void removeEdge(Vertex j){
		myEdges.remove(j);
	}
	
	public boolean hasEdge(Vertex j){
		return myEdges.containsKey(j);
	}
	
	public double getEdgeWeight(Vertex j){
		if (myEdges.containsKey(j)){
			return myEdges.get(j);
		}
		else return Double.POSITIVE_INFINITY;
	}
	
	public Collection<Vertex> getAdjacentVertices(){
		return myEdges.keySet();
	}
}
