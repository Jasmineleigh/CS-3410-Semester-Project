package prob2;

public class Edge implements Comparable<Edge>{
	private Node start;
	private Node end;
	private double weight;
	
	public Edge(Node start, Node end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
		isFinalized = false;
	}

	public Node getStartNode() {
		return start;
	}
	
	public Node getEndNode() {
		return end;
	}
	
	public String getStart() {
		return start.getName();
	}

	public String getEnd() {
		return end.getName();
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public int compareTo(Edge e) {
		return (int)(e.weight - this.weight);
	}
	
	@Override
	public String toString() {
		return start.getName() + " to " + end.getName() + " = " + weight;
	}

}
