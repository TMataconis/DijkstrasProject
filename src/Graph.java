import java.util.*;

/**
 * Interface for a Graph Abstract Data Type (ADT). A 
 * Graph ADT consists of a set of vertices, a set of Edges and 
 * operations for accessing and manipulating these sets.
 * Any implementation of this interface should support both
 * directed and undirected graphs as described below.
 *
 * The following documentation uses a pair notation to
 * specify graph edges. For example, the edge (i,j) is
 * an edge between vertex i and vertex j.  If the Graph
 * under consideration is a directed graph, then the edge
 * (i,j) is directed from vertex i to vertex j.  Similarly,
 * the edge (j,i) would be directed from vertex j to vertex i.
 * In a directed graph the edges (i,j) and (j,i) are distinct
 * and may exist independent of one another.
 * If the graph is undirected, then the edge (i,j) is 
 * equivalent to the edge (j,i) and one may not exist without
 * the other.
 * 
 * @author sspurlock
 * @version 2019-10-21
 */
public interface Graph<V> {

    /**
     * A constant used to indicate that a Graph is directed.
     */
    static final boolean DIRECTED = true;

    /**
     * A constant used to indicate that a Graph is not directed.
     */
    static final boolean UNDIRECTED = false;
    

    /**
     * Get the number of vertices in this Graph.
     *
     * @return the number of vertices in this Graph.
     */
    int numVertices();

    /**
     * Get the number of edges in this Graph. Note that in 
     * an undirected graph there may only be a single edge
     * between each pair of vertices. In a directed graph
     * there may be two edges between each pair of vertices;
     * One in each direction.
     *
     * @return the number of edges in this Graph.
     */
    int numEdges();

    /**
     * Determine if this Graph is directed.
     *
     * @return true if this Graph is directed and false
     *         if it is undirected.
     */
    boolean isDirected();

    /**
     * Add the edge (i,j) to this Graph. 
     * 
     * @param i  a vertex in this Graph.
     * @param j  a vertex in this Graph.
     *
     * @throws IllegalVertexException if vertex i or vertex j do not
     *         exist in this Graph.
     */
    void addEdge(V i, V e)
	throws IllegalVertexException;
    
    /**
     * Add the edge (i,j) to this Graph with weight w. 
     * 
     * @param i  a vertex in this Graph.
     * @param j  a vertex in this Graph.
     * @paramm w the weight of this edge.
     *
     * @throws IllegalVertexException if vertex i or vertex j do not
     *         exist in this Graph.
     */
    void addEdge(V i, V e, double w)
	throws IllegalVertexException;

    /**
     * Remove the edge (i,j) from this Graph.
     *
     * @param i  a vertex in this Graph.
     * @param j  a vertex in this Graph.
     *
     * @throws IllegalVertexException if vertex i or vertex j do not
     *         exist in this Graph.
     */
    void removeEdge(V i, V j)
	throws IllegalVertexException;

    /**
     * Determine if the edge (i,j) exists in this Graph.
     *
     * @param i  a vertex in this Graph.
     * @param j  a vertex in this Graph.
     *
     * @return true if edge (i,j) exists in this Graph and
     *         false otherwise.
     *
     * @throws IllegalVertexException if vertex i or vertex j do not
     *         exist in this Graph.
     */
    boolean edgeExists(V i, V j)
	throws IllegalVertexException;
    
    /**
     * Get the weight associated with edge (i,j).
     *
     * @param i  a vertex in this Graph.
     * @param j  a vertex in this Graph.
     *
     * @return weight of edge (i,j) if exists in this Graph and infinity 
     * otherwise.
     *
     * @throws IllegalVertexException if vertex i or vertex j do not
     *         exist in this Graph.
     */
    double getWeight(V i, V j)
	throws IllegalVertexException;

    /**
     * Add a new vertex to this Graph. The Object v 
     * will be associated with the vertex. 
     * 
     * @param v an Object to be associated with the new vertex.
     *
     * @return the new vertex.
     */
    V addVertex(V v);

    /**
     * Remove vertex i from this Graph. 
     *
     * @param i the index of a vertex in this Graph.
     *
     *
     * @throws IllegalVertexException if vertex i does not
     *         exist in this Graph.
     */
    void removeVertex(V vertex)
	throws IllegalVertexException;

    /**
     * Find the number of edges incident on vertex i in this Graph.
     *
     * @param i  a vertex in this Graph.
     *
     * @return the number of edges that are incident on vertex i
     *         in this Graph.
     *
     * @throws IllegalVertexException if vertex i does not
     *         exist in this Graph.
     */
    int inDegree(V vertex)
	throws IllegalVertexException;

    /**
     * Find the number of edges incident from vertex i in this Graph.
     *
     * @param i a vertex in this Graph.
     *
     * @return the number of edges that are incident from vertex i
     *         in this Graph.
     *
     * @throws IllegalVertexException if vertex i does not
     *         exist in this Graph.
     */
    int outDegree(V vertex)
	throws IllegalVertexException;

    /**
     *
     * Get a collection of the vertices adjacent to the 
     * given vertex.
     * @param i a vertex in this Graph.
     *
     * @throws IllegalVertexException if vertex i does not
     *         exist in this Graph.
     */
    Collection<V> getAdjacentVertices(V vertex)
	throws IllegalVertexException;
 
    /**
     * Get a collection of the vertices in the graph..
     *
     * @param i a vertex in this Graph.
     *
     * @return a collection of the vertices  in this Graph.
     *
     * @throws IllegalVertexException if vertex i does not
     *         exist in this Graph.
     */
    Collection<V> getVertices();
    
    /**
     *  Print a text representation of the graph
     */
    
   void print();

}