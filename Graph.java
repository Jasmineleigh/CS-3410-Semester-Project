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
