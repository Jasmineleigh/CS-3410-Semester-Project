package prob1;

import java.util.Comparator;

public class Node implements Comparator<Node> {

	// Member variables of this class
	private int node;
	private double cost;
	private double time;
	private double rating;

	// Constructors of this class

	// Constructor 1
	public Node() {}

	// Constructor 2
	public Node(int node, double cost, double time, double rating){

		// This keyword refers to current instance itself
		this.node = node;
		this.cost = cost;
		this.time = time;
		this.rating = rating;
	}
	
	public int getNode() {
		return node;
	}

	public double getCost() {
		return cost;
	}
	
	public double getTime(){
		return time;
	}
	
	public double getRating() {
		return rating;
	}

	// Method 1
	@Override public int compare(Node node1, Node node2){

		if (node1.cost < node2.cost)
			return -1;

		if (node1.cost > node2.cost)
			return 1;

		return 0;
	}
}
