package prob1;

public class Edge {
	private int start;
	private int end;
	private double weight;
	private int time;
	private int rating;
	
	public Edge(int start, int end, double weight, int time, int rating) {
		this.start = start;
		this.end = end;
		this.weight = weight;
		this.time = time;
		this.rating = rating;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public double getWeight() {
		return weight;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return start + " to " + end + " = " + weight;
	}

}
