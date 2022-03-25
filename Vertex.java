package prob1;

import java.util.Comparator;

public class Vertex implements Comparator<Vertex> {
	int node;
	int cost;
	
	public Vertex() {}
	
	public Vertex(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compare(Vertex v1, Vertex v2) {
		if(v1.cost < v2.cost)
			return -1;
		if(v1.cost > v2.cost)
			return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "" + node;
	}

}
