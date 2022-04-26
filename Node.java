package prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
	String name;
	int index;
	List<Edge> edges = new ArrayList<>();
	
	public Node(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public String getName() {
		return name;
	}
	
	public List getEdges() {
		return edges;
	}
	
	public boolean addEdge(Edge e) {
		
		if(e.getStart().equals(this.name)) {
			if(!edges.contains(e)) {
				edges.add(e);
				return true;
			}
		}
		
		return false;
	}
	
	public int getNumEdges() {
		return edges.size();
	}
	
	public Edge removeEdge(Edge e) {
		Edge removed = null;
		if(!edges.contains(e)) {
			removed = e;
			edges.remove(e);
		}
		return removed;
	}
	
	public List<Edge> getSortedEdges(){
		
		if(edges.size() == 1)
			return edges;
		else {
	
			for(int i = 1; i < edges.size(); i++) {
				if(edges.get(i).getWeight() > edges.get(i-1).getWeight()) {
					Collections.swap(edges, i-1, i);
				}
				
			}
			return edges;
		}
	}
	
}
