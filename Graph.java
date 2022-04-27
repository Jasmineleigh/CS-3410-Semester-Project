package prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	private List<Edge> edges = new ArrayList<>();
	private List<Edge> removedFromGraph = new ArrayList<>();
	private int numNodes = 0;
	
	// Constructor
	public Graph(int numNodes) {
		this.numNodes = numNodes;
	}
	
	// Adds edge e if this.edges doesn't already contain it
	public boolean addEdge(Edge e) {
		if(edges.contains(e))
			return false;
		edges.add(e);
		return true;
	}
	
	// removes edge passed from this.edges
	public Edge removeEdge(Edge e) {
		Edge removed = null;
		if(!edges.contains(e)) {
			removed = e;
			edges.remove(e);
		}
		return removed;
	}
	
	// Return list of removedEdges 
	// null if InverseKruskal isn't performed first
	public List<Edge> getRemovedEdges(){
		return removedFromGraph;
	}
	
	// Creates and adjacency list where the edges are undirected
	// each edge can go in back and forth directions between the nodes it connects
	public List<List<Integer>> getAdjacencyList(){
		List<List<Integer>> adjacencyList = new ArrayList<>();// Will hold of the edges
		// Sorts this.edges in non-increasing order
		Collections.sort(edges);
		
		// Intializes the lists of edges in each list of the adjacencyList 
		for(int i=0; i < numNodes; i++){		
			adjacencyList.add(new ArrayList<Integer>());
		}
		
		// Iterates through every edge in this.edges
		for(Edge e: edges) {
			
			Node start = e.getStartNode();
			Node end = e.getEndNode();
			
			// add the edge to be bidirectional
			adjacencyList.get(start.getIndex()).add(end.getIndex());
			adjacencyList.get(end.getIndex()).add(start.getIndex());
		}
		return adjacencyList;
	}
	
	// Performs the inverse of Kruskal's Algorithm
	// Removes the larger edges first
	public List<Edge> InverseKruskal() {
		List<List<Integer>> adjacencyList = getAdjacencyList();
		// Create a container to hold the final MST
		List<Edge> mst = new ArrayList<>();
		
		for(Edge e: edges) {
			Node start = e.getStartNode();
			Node end = e.getEndNode();
			
			// Removes the heaviest edge 
			adjacencyList.get(start.getIndex()).removeIf(v -> v == end.getIndex());
			adjacencyList.get(end.getIndex()).removeIf(v -> v == start.getIndex());
			
			// If the edge is not connected after the removal
			if(!isConnected(adjacencyList)) {
				// add the edge back to the adjacencyList
				adjacencyList.get(start.getIndex()).add(end.getIndex());
				adjacencyList.get(end.getIndex()).add(start.getIndex());
				// add this edge to the MST
				mst.add(e);
			}
			
			// Add the removed edges to this.removedFromGraph
			else
				removedFromGraph.add(e);
		}
		
		return mst;
		
	}
	
	// Checks if all of the nodes are still connected in the graph
	private boolean isConnected(List<List<Integer>> adjacencyList) {
		// starting at the first node
		int startingNode = 0;
		
		// holds nodes that have not been visited yet
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startingNode);
		
		// Will be true at the index of the node if the node gets visited using BFS algo
		boolean[] visited = new boolean[adjacencyList.size()];
		
		while(!queue.isEmpty()) {
			// remove node from the beginning of queue list
			int removedNode = queue.remove();
			
			// if it is not visited at this index
			if(!visited[removedNode]) {
				// set it to true 
				visited[removedNode] = true;
				
				// List that holds all of the neighboring nodes of the removedNode 
				List<Integer> neighbors = adjacencyList.get(removedNode);
				
				// iterate over the neighbors
				for(Integer i: neighbors) 
					if(!visited[i]) // if not visited yet
						queue.add(i); // add node to the queue
			}
		}
		
		// iterate over all the indexes in visited array
		for(int i = 0; i < visited.length; i++) 
			if(!visited[i]) // if false at any index
				return false; // return false
		
		return true;
	}

	// Returns string of Edges of the MST
	public String printMST() {
		List<Edge> mst = InverseKruskal();
		String str = "";
		
		
		for(int i = 0; i < mst.size(); i++) {
			int j = 0;
			
			// While loop causes output to be in order based on the index value
			while(j < mst.size()) {
				Node start = mst.get(j).getStartNode();
				// 
				if(start.getIndex() == i) {
					str += "\t" + mst.get(j) + "\n";
					break;
				}
					
				j++;
			}
		}
			
		return str;
	}
	
	@Override
	public String toString() {	
		String str = "";
		
		for(int i = 0; i < edges.size(); i++) {
				str += "\t" + edges.get(i) + "\n";
		}
			
		return str;
	}


}
