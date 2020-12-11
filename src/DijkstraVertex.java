/* Subclass of Vertex specific to Dijkstra. Adds a distance
 * field and the ability to compare to DijkstraVertex objects.
 * 
 * @author sspurlock
 * @version 2019-10-21
 */

public class DijkstraVertex extends Vertex implements Comparable<DijkstraVertex> {
	private double distance;
	
	public DijkstraVertex(String name) {
		super(name);	
	}
	
	public void setDistance(double dist){
		distance = dist;
	}
	
	public double getDistance(){
		return distance;
	}
	
	public int compareTo(DijkstraVertex j) {
		if(this.distance < j.distance) return -1;
		else if (this.distance > j.distance) return 1;
		else return 0;
	}
}
