import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * The GraphMaker handles making a graph by reading from a file.
 * The makeGraphFromFile method takes in the name of a file. 
 * The code should then read in the input file and produce the corresponding graph.
 * The first line of the file will be the number of vertices. 
 * The next lines will give the edges as a table where table(i,j) gives the 
 * edge weight between vertices i and j. 
 * The two provided files are in this format.
 * 
 * @author sspurlock
 * @version 2019-10-21
 */
public class GraphMaker {
	
	public AdjListGraph makeGraphFromFile(String fileName) {
		// Create a new directed AdjListGraph and read from the file to
		// add DijkstraVertex and Edge object to the graph.
		// TODO...
		boolean isDirected = true;
		if (fileName.equals("JapanCities.txt")){ 								// Because Japan is an unDirected graph and 
			isDirected = false; 												// routers is directed, check if JapanCities is the 
		}																		// input file
		
		AdjListGraph graph = new AdjListGraph(isDirected);
		
		
		Scanner scnr;
		try {
			scnr = new Scanner(new File(fileName));
		
			int vertexNum = 0;
		
			vertexNum = Integer.parseInt(scnr.next());
		
			Vertex[] vertices = new Vertex[vertexNum]; 							// create array of vertex, w/ a size at the top of the file
		
			for (int i = 0; i < vertices.length; i++) {
				vertices[i] = graph.addVertex(new DijkstraVertex(scnr.next())); // add vertices to array & graph;
			}
		
			int vertexA = -1; 													// because the way the file is formated, vertexAs index will
			int vertexB = 0;													// start at -1 and then is immediately incremented once in
			boolean isOnVertex = false;											// while loop
		
			while (scnr.hasNext()) {
				String next = scnr.next();
				double edgeWeight = 0;
				try {															// if parseInt fails, the graph is on a new line, at a 
					edgeWeight = Double.parseDouble(next);						// vertex
					isOnVertex = false;
				}
				catch (NumberFormatException e) {								// vertexA is incremented, vertexB is reset to 0
					vertexA++;													// isOnVertex is used to easily tell its namesake
					isOnVertex = true;
					vertexB = 0;
				}
			
				if (!isOnVertex) {												// if not on vertex and edgeWeight > 0, the edge is added to
					if (edgeWeight > 0) {										// the graph with its edgeWeight
						graph.addEdge(vertices[vertexA], vertices[vertexB], edgeWeight);
					}
					vertexB++;													// vertexB is incremented outside of if statement
				}
			}
		} 
		catch (FileNotFoundException e) {} 
		catch (NumberFormatException e) {
			throw new NumberFormatException("File is not in the correct format");
		}
		
		return graph;
	}
}
