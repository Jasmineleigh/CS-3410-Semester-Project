package prob1;
import java.util.*;

public class GraphTest {
	public static void main(String arg[]) {
		int v = 6;
		int source = 0;
		List<List<Vertex>>  adjList = new ArrayList<List<Vertex>>();
		HashMap<Integer, String> buildingsAssigned = new HashMap<>();
		String[] buildings = new String[v];
		buildings[0] = "Odum Library";
		buildings[1] = "Student Union";
		buildings[2] = "Nevins";
		buildings[3] = "Converse";
		buildings[4] = "Hopper";
		buildings[5] = "PALMS";
		
		buildingsAssigned = assignBuildings(buildings);
		
		
		for(int i = 0; i < v; i++) {
			List<Vertex> location = new ArrayList<Vertex>();
			adjList.add(location);
		}
		
		// Odum
		adjList.get(0).add(new Vertex(1, 5));
		adjList.get(0).add(new Vertex(2, 3));
		adjList.get(0).add(new Vertex(3, 2));
		
		// Student Union
		adjList.get(1).add(new Vertex(0, 5));
		adjList.get(1).add(new Vertex(4, 3));
		
		// Nevins
		adjList.get(2).add(new Vertex(0, 3));
		adjList.get(2).add(new Vertex(3, 4));
		// Converse
		adjList.get(3).add(new Vertex(0, 2));
		adjList.get(3).add(new Vertex(2, 4));
		adjList.get(3).add(new Vertex(4, 8));
		// Hopper
		adjList.get(4).add(new Vertex(1, 3));
		adjList.get(4).add(new Vertex(5, 2));
		adjList.get(4).add(new Vertex(3, 8));
		// PALMS
		adjList.get(5).add(new Vertex(4, 2));
		
		Graph graph = new Graph(v);
		
		graph.dijkstraAlgorithm(adjList, source);
		
		System.out.println("The shortest node from " + source + " to other nodes: ");
		
		for(int i = 0; i < graph.dist.length; i++) {
			System.out.println(source + "\t\t" + i + "\t\t" + graph.dist[i]);
		}
	}
	
	private static HashMap<Integer, String> assignBuildings(String[] buildings){
		HashMap<Integer, String> buildingsAssigned = new HashMap<>();
		
		for (int i = 0; i < buildings.length; i++) {
			buildingsAssigned.put(i, buildings[i]);
		}
		
		return buildingsAssigned;
		
	}
}
