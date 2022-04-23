package prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	private List<Edge> edges = new ArrayList<>();
	private int numNodes = 0;
	
	public Graph(int numNodes) {
		this.numNodes = numNodes;
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public List<List<Integer>> getAdjacencyList(){
		List<List<Integer>> adjacencyList = new ArrayList<>();
		sortEdges();
		
		for(int i=0; i < numNodes; i++){		//Add placeholders for each vertex
			adjacencyList.add(new ArrayList<Integer>());
		}
		
		for(Edge e: edges) {
			Node start = e.getStartNode();
			Node end = e.getEndNode();
			adjacencyList.get(start.getIndex()).add(end.getIndex());
			adjacencyList.get(end.getIndex()).add(start.getIndex());
		}
		return adjacencyList;
	}
	
	public List<Edge> InverseKruskal() {
		List<List<Integer>> adjacencyList = getAdjacencyList();		
		List<Edge> mst = new ArrayList<>();
		
		for(Edge e: edges) {
			Node start = e.getStartNode();
			Node end = e.getEndNode();
			adjacencyList.get(start.getIndex()).removeIf(v -> v == end.getIndex());
			adjacencyList.get(end.getIndex()).removeIf(v -> v == start.getIndex());
			
			if(!isConnected(adjacencyList)) {
				adjacencyList.get(start.getIndex()).add(end.getIndex());
				adjacencyList.get(end.getIndex()).add(start.getIndex());
				mst.add(e);
			}
		}
		
		return mst;
		
	}
	
	private void sortEdges() {
		Collections.sort(edges);
	}
	
	private boolean isConnected(List<List<Integer>> adjacencyList) {
		
		int startingNode = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startingNode);
		
		boolean[] visited = new boolean[adjacencyList.size()];
		List<Integer> orderOfVisited = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int removedNode = queue.remove();
			
			if(!visited[removedNode]) {
				visited[removedNode] = true;
				orderOfVisited.add(removedNode);
				
				List<Integer> incidentMatrix= adjacencyList.get(removedNode);
				
				for(Integer i: incidentMatrix) 
					if(!visited[i]) 
						queue.add(i);
			}
		}
		
		for(int i = 0; i < visited.length; i++) 
			if(!visited[i])
				return false;
		
		return true;
	}
	
	@Override
	public String toString() {
		List<Edge> mst = InverseKruskal();
		String str = mst.get(0).toString() + "\n|\nV\n";
		
		for(int i = 1; i < mst.size(); i++) {
			if(mst.get(i).getEnd().equals(mst.get(i-1).getEnd()) || (mst.get(i-1).getStart().equals(mst.get(i).getEnd()))) {
				str += mst.get(i).getEnd() + " to " + mst.get(i).getStart() + " = " + mst.get(i).getWeight() + "\n";
			}
			
			else {
				str += mst.get(i).toString() + "\n";
			}
			
			if(i != mst.size()-1) {
				str += "|\nV\n";
			}
			
				
		}
			
		return str;
	}


}
