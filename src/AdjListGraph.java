/*
 * AdjListGraph implements Graph with an adjacency list.
 * 
 * @author sspurlock
 * @version 2019-10-21
 */
import java.util.*;
 

public class AdjListGraph implements Graph<Vertex>{
	private boolean isDirected;
	// Here's the adjacency list.
	private ArrayList<Vertex> myVertices;
	
	public AdjListGraph(boolean directed){
		isDirected = directed;
		myVertices = new ArrayList<Vertex>();
	}
	
	/*
	 * Add an edge between 2 vertices
	 */
	public void addEdge(Vertex i, Vertex j) throws IllegalVertexException{
		if (myVertices.contains(i) && myVertices.contains(j)){
			i.addEdge(j);
			// Non-directed graphs have 2-way edges
			if (!isDirected){
				j.addEdge(i);
			}
		}
		else{
			throw new IllegalVertexException("Add edge failed.");
		}
	}
	
	/*
	 * Add an edge of given length between 2 vertices
	 */
	public void addEdge(Vertex i, Vertex j, double length) throws IllegalVertexException{
		if (myVertices.contains(i) && myVertices.contains(j)){
			i.addEdge(j,length);
			// Non-directed graphs have 2-way edges
			if (!isDirected){
				j.addEdge(i,length);
			}
		}
		else{
			throw new IllegalVertexException("Add edge failed.");
		}
	}
	
	/*
	 * Add a vertex.
	 */
	public Vertex addVertex(Vertex v){
		myVertices.add(v);
		return v;
	}
	
	/*
	 * Determine whether or not an edge exists between 2 vertices
	 */
	public boolean edgeExists(Vertex i, Vertex j)throws IllegalVertexException{
		if (myVertices.contains(i)&& myVertices.contains(j)){
			return  i.hasEdge(j);
		}
		else{
			throw new IllegalVertexException("Edge Exists failed.");
		}
	}

	public ArrayList<Vertex> getVertices(){
		return myVertices;
	}
	
	/*
	 * Gets all vertices that vertex v points to.
	 */
	public Collection<Vertex> getAdjacentVertices(Vertex v) throws IllegalVertexException{
		if (myVertices.contains(v)){
			return v.getAdjacentVertices();
		}
		else{
			throw new IllegalVertexException("get Iterator failed");
		}
	}
	
	/*
	 * Computes the in-degree of a vertex.  The in-degree is the number
	 * of vertices with edges that lead to the given vertex.
	 */
	public int inDegree(Vertex v) throws IllegalVertexException{
		if (!myVertices.contains(v)){
			throw new IllegalVertexException("in Degree failed.");
		}
		else{
			int inDegree = 0;
			for (Vertex i: myVertices){
				for(Vertex j: i.getAdjacentVertices()){
					if (j == v){
						inDegree++;
					}
				}
			}
			return inDegree;
		}
	}
	
	/*
	 * Returns the out degree of vertex v.  The out degree 
	 * is the number of outgoing edges of vertex v.
	 */
	public int outDegree(Vertex v) throws IllegalVertexException{
		if (!myVertices.contains(v)){
			throw new IllegalVertexException("out degree failed");
		}
		else{
			return v.getAdjacentVertices().size();
		}
	}
	
	public boolean isDirected(){
		return isDirected;
	}
	
	/*
	 * Computes the total number of edges in the graph.
	 */
	public int numEdges(){
		int edges =0;
		for(Vertex v: myVertices){
			edges += outDegree(v);
		}
		// For an undirected graph, I have added 
		// directed edges that go back.  So the 
		// real # of edges is half the number
		// computed so far.  See addEdge.
		if (!this.isDirected()){
			edges /= 2;
		}
		return edges;
	}
	
	public int numVertices(){
		return myVertices.size();
	}
	
	/*
	 * Remove an edge from i to j.  This method assumes the edge exists
	 * and throws an exception if it does not.
	 * 
	 * For undirected graphs, we must also remove the edge from j to i.
	 */
	public void removeEdge(Vertex i, Vertex j) throws IllegalVertexException{
		if (myVertices.contains(i) && myVertices.contains(j) && i.hasEdge(j)){
			i.removeEdge(j);
			if (!isDirected){
				j.removeEdge(i);
			}
		}
		else{
			throw new IllegalVertexException("Remove Edge Failed.");
		}
	}
	
	/*
	 * Remove a vertex.  Assumes given vertex is in the graph.
	 */
	public void removeVertex(Vertex v) throws IllegalVertexException{
		if (myVertices.contains(v)){
			myVertices.remove(v);
			// I also have to remove everyone else's edges to the now
			// defunct vertex.
			for (Vertex i: myVertices){
				if (i.hasEdge(v)) i.removeEdge(v);
			}
		}
		else{
			throw new IllegalVertexException("removeVertex failed.");
		}
	}
	
	/*
	 * Returns the weight of the edge between vertex i & j.  Assumes the
	 * vertices exist, and throws exception if not.
	 */
	public double getWeight(Vertex i, Vertex j) throws IllegalVertexException {
		if(myVertices.contains(i)){
			return i.getEdgeWeight(j);
		}
		else{
			throw new IllegalVertexException("getWeight failed.");
		}
	}
	
	/*
	 * Prints all the pertinent information of the graph for testing 
	 * purposes.
	 */
	public void print(){
		String direction = isDirected ? "directed" : "undirected";
		System.out.println("This is a "+direction+ " graph.");
		System.out.println("This graph has "+ numEdges()+" edges and "+numVertices()+ " vertices:");
		for(Vertex i: myVertices){
			System.out.println(i.getName()+" in degree: "+this.inDegree(i)+ " out degree: "+this.outDegree(i));
			System.out.print("\tEdges to: ");
			for (Vertex j: i.getAdjacentVertices()){
				System.out.print(j.getName());
			}
			System.out.println();
		}
	}
}
