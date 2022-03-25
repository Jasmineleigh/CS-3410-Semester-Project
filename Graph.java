package prob1;

import java.util.*;

public class Graph {
	int[] dist;
	Set<Integer> visited;
	PriorityQueue<Vertex> pQueue;
	int v; // Num vertices
	List<List<Vertex>> adjList;
	
	public Graph (int v) {
		this.v = v;
		dist = new int [v];
		visited = new HashSet<Integer>();
		pQueue = new PriorityQueue<Vertex>(v, new Vertex());
	}
	
	public void dijkstraAlgorithm(List<List<Vertex>> adjList, int srcVertex) {
		this.adjList = adjList;
		
		for(int i = 0; i < v; i++) 
			dist[i] = Integer.MAX_VALUE;
			
		pQueue.add(new Vertex(srcVertex, 0));
		dist[srcVertex] = 0;
		
		while (visited.size() != v) {
			int u = pQueue.remove().node;
			visited.add(u);
			graphAdjacentNodes(u);
		}
	}
	
	// helper
	
	private void graphAdjacentNodes(int u) {
		int edgeDist = -1;
		int newDist = -1;
		
		for(int i = 0; i < adjList.get(u).size(); i++) {
			Vertex n = adjList.get(u).get(i);
			
			if (!visited.contains((n.node))) {
				edgeDist = n.cost;
				newDist = dist[u] + edgeDist;
				if (newDist < dist[n.node])
					dist[n.node] = newDist;
				
				pQueue.add(new Vertex(n.node, dist[n.node]));
			}
		}
	}
}
