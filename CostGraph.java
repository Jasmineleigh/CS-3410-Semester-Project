package projectPackage;

import java.util.LinkedList;

public class CostGraph {
	 static class Edge {
		 int start;
		 int destination;
		 int cost;
		
		 public Edge(int start, int destination, int cost) {
			 this.start = start;
			 this.destination = destination;
			 this.cost = cost;
		 }
	 }

	 static class Graph {
		 int vertices;
		 LinkedList<Edge> [] adjacencylist;

		 Graph(int vertices) {
			 this.vertices = vertices;
			 adjacencylist = new LinkedList[vertices];
			 //initialize adjacency lists for all the vertices
			 for (int i = 0; i <vertices ; i++) {
			 adjacencylist[i] = new LinkedList<>();
			 }
		 }

		 public void addEgde(int start, int destination, int cost) {
			 Edge edge = new Edge(start, destination, cost);
			 adjacencylist[start].addFirst(edge); //for directed graph
		 }

		 public void printGraph(){
			 for (int i = 0; i <vertices ; i++) {
				 LinkedList<Edge> list = adjacencylist[i];
				 for (int j = 0; j <list.size() ; j++) {
					 System.out.println("vertex-" + i + " is connected to " +
					 list.get(j).destination + " with weight " + list.get(j).cost);
				 }
			 }
		 }
	 }
	 
	 public static void findPathCost(Graph costs, int vertices){
		 
	 }
}
