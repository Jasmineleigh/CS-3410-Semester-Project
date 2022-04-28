package prob1;

import java.util.*;

public class Graph {
	private List<List<Edge>> adjacencyList = null;

	public Graph(List<Edge> edges, int numVertices) {
		this.adjacencyList = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
 
        for (Edge edge: edges) {
            adjacencyList.get(edge.getStart()).add(edge);
        }
	}
	
	public List<List<Edge>> getAdjacencyList() {
		return adjacencyList;
	}
}
