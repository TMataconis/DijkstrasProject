/*
 * Uses the GraphMaker to make the graph, asks the user for the source vertex 
 * and destination vertex, and then runs Dijkstra's algorithm. The shortest 
 * path length as well as the actual path should be printed to the screen, 
 * then the program should terminate. See the examples in assignment for the 
 * appropriate formatting.
 * 
 * @author sspurlock
 * @version 2019-10-21
 */

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstras {
	HashMap<DijkstraVertex, DijkstraVertex> parent = new HashMap<DijkstraVertex, DijkstraVertex>();

	// Constructor: prompt user to enter file name, then
	// call runShortestPath with the file name.
	public Dijkstras() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the file name");
		String fileName = scnr.next();
		runShortestPath(fileName);
		scnr.close();
	}

	// Make a graph and run Dijkstra's algorithm.
	public void runShortestPath(String fileName){
		// Create a new GraphMaker object and use it to make a new AdjListGraph.
		// TODO
		GraphMaker graphMaker = new GraphMaker();
		AdjListGraph graph = graphMaker.makeGraphFromFile(fileName);
		
		// Print the graph out and prompt the user to enter the starting 
		// and ending vertices.
		// TODO
		//graph.print();
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter the starting vertex");
		String startVertex = scnr.next();
		
		System.out.println("Enter the ending vertex");
		String endVertex = scnr.next();
		
		scnr.close();
		
		// Call the shortestPath method with the graph and the source Vertex.
		// TODO
		DijkstraVertex sourceVertex = null;
		DijkstraVertex endingVertex = null;
		
		for (Vertex v : graph.getVertices()) {
			if (v.getName().equals(startVertex)) {
				sourceVertex = (DijkstraVertex)v;
			}
			else if (v.getName().equals(endVertex)) {
				endingVertex = (DijkstraVertex)v;
			}
		}
		
		shortestPath(graph, sourceVertex);
		// Get the distance to the destination Vertex and print it out.
		// TODO
		System.out.println("The shortest path is " + endingVertex.getDistance());
		
		// Find and print the path by following back from the destination Vertex to each
		// parent. Note that, in the shortestPath method, you'll have stored 
		// the parent for each Vertex in the HashMap declared at the top of this file).
		// TODO
		System.out.print(sourceVertex.getName());
		DijkstraVertex tempVertex = sourceVertex;
		
		while (tempVertex != endingVertex) {
			for (DijkstraVertex v : parent.keySet()) {
				if (v.equals(tempVertex)) {
					System.out.print("::" + parent.get(v).getName());
					tempVertex = parent.get(v);
				}
			}
		}
	}

	// Given the graph and source vertex, run Dijkstra's algorithm.
	public void shortestPath(AdjListGraph graph, DijkstraVertex source){
		// Initialize the distance to all the vertices in the graph to infinity,
		// except the source vertex, which should be 0.
		// TODO
		
		// Make a PriorityQueue (imported above in Java.Util.PriorityQueue)
		// of DijkstraVertex objects and add all the vertices.
		// TODO
		
		PriorityQueue<DijkstraVertex> pq = new PriorityQueue<>();
		
		for (Vertex i : graph.getVertices()) {
			DijkstraVertex vertex = (DijkstraVertex)i;
			if (vertex.equals(source)) {
				vertex.setDistance(0);
			}
			else {
				vertex.setDistance(Double.POSITIVE_INFINITY);
			}
			pq.add(vertex);
		}
		
		// Keep looping as long as the priorty queue is not empty, doing the following:
		// - get the next closest Vertex from the priority queue
		// - get its adjacent vertices
		// - for each adjacent vertex, check if the distance to get there from the 
		//   current vertex would be shorter than its current distance. If so, remove
		//   it from the priority queue, update its distance, and re-add it. Keep track
		//   of which vertex led to this vertex using the parent HashMap declared
		//   at the top of the file.
		// TODO
		
		while (!pq.isEmpty()) {
			DijkstraVertex closestVertex = pq.poll();
			
			double temp = Double.MAX_VALUE;
			for (Vertex i : closestVertex.getAdjacentVertices()) {
				DijkstraVertex v = (DijkstraVertex)i;
				
				if (closestVertex.getDistance() + closestVertex.getEdgeWeight(i) < v.getDistance()) {
					pq.remove(v);
					v.setDistance(closestVertex.getDistance() + closestVertex.getEdgeWeight(v));
					if (graph.isDirected()) {
						parent.put(closestVertex, v);
					}
					else {
						if (v.getDistance() < temp) {
							temp = v.getDistance();
							parent.put(closestVertex, v);
						}
					}
					pq.add(v);
				}
			}
		}
	}
}
