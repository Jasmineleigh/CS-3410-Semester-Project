package prob2;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[]args) {
		Node union = new Node("Student Union", 0);
		Node odum = new Node("Odum Library", 1);
		Node arts = new Node("Fine Arts", 2);
		Node nevins = new Node("Nevins Hall", 3);
		Node converse = new Node("Converse Hall", 4);
		
		Edge e = new Edge(union, odum, 2.5);
		union.addEdge(e);
		
		Edge e2 = new Edge(odum, union, 2.5);
		Edge e3 = new Edge(odum, arts, 4.5);
		Edge e4 = new Edge(odum, nevins, 3.1);
		Edge e5 = new Edge(odum, converse, 2.8);
		odum.addEdge(e2);
		odum.addEdge(e3);
		odum.addEdge(e4);
		odum.addEdge(e5);
		
		Edge e6 = new Edge(arts, odum, 2.5);
		arts.addEdge(e6);
		
		Edge e7 = new Edge(nevins, odum, 3.1);
		Edge e8 = new Edge(nevins, converse, 1.4);
		nevins.addEdge(e7);
		nevins.addEdge(e8);
		
		Edge e9 = new Edge(converse, odum, 2.8);
		Edge e10 = new Edge(converse, nevins, 1.4);
		converse.addEdge(e9);
		System.out.println(converse.addEdge(e10));
		System.out.println(converse.addEdge(e5));
		System.out.println(odum.getNumEdges());
		
		List<Edge> sortedEdges = odum.getSortedEdges();
		for(int i = 0; i < sortedEdges.size(); i++) {
			System.out.println(sortedEdges.get(i));
		}
		
		System.out.println();
		Graph graph = new Graph(5);
		
		graph.addEdge(e);
		graph.addEdge(e3);
		graph.addEdge(e4);
		graph.addEdge(e5);
		graph.addEdge(e8);
		
		System.out.println(graph);
		
		
		
		
	}

}
