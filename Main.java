package finalProject;

public class Main {
		
	public static void main(String[]args) {
		InverseKruskal_Letters();
		InverseKruskal_ValdostaCampus();
		
	}
	
	private static void InverseKruskal_Letters() {
		Node a = new Node ("A", 0);
		Node b = new Node ("B", 1);
		Node c = new Node ("C", 2);
		Node d = new Node ("D", 3);
		Node E = new Node ("E", 4);
		Node f = new Node ("F", 5); 
		Node g = new Node ("G", 6);
		
		Edge ab = new Edge(a, b, 7);
		Edge ad = new Edge(a, d, 5);
		Edge bc = new Edge(b, c, 8);
		Edge be = new Edge(b, E, 7);
		Edge bd = new Edge(b, d, 9);
		Edge ce = new Edge(c, E, 5);
		Edge de = new Edge(d, E, 15);
		Edge df = new Edge(d, f, 6);
		Edge ef = new Edge(E, f, 8);
		Edge eg = new Edge(E, g, 9);
		Edge fg = new Edge(f, g, 11);
		
		Graph graph = new Graph(7);
		graph.addEdge(ab);
		graph.addEdge(ad);
		graph.addEdge(bc);
		graph.addEdge(be);
		graph.addEdge(bd);
		graph.addEdge(ce);
		graph.addEdge(de);
		graph.addEdge(df);
		graph.addEdge(ef);
		graph.addEdge(eg);	
		graph.addEdge(fg);
		
		// Print Original edges
		System.out.println("Original edges in graph:\n\n" + graph);
		
		// Print list of edges in MST
		System.out.println("Edges in MST:\n\n" + graph.printMST());
		System.out.println("Edges removed from graph:\n");
		
		for(Edge e: graph.getRemovedEdges()) {
			System.out.println("\t" + e);
		}
		
		System.out.println();
	}
	
	private static void InverseKruskal_ValdostaCampus() {
		
		// Make nodes
		Node pe = new Node("PE Complex", 0);
		Node edu = new Node("Education Building", 1);
		Node oak = new Node("Oak Parking", 2);
		Node arts = new Node("Fine Arts Building", 3);
		Node lowndes = new Node("Lowndes", 4);
		Node patt = new Node("Patterson", 5);
		Node brown = new Node("Brown", 6);
		Node odum = new Node("Odum Library", 7);
		Node union = new Node("Student Union", 8);
		Node hopp = new Node("Hopper", 9);
		Node conv = new Node("Converse Hall", 10);
		Node nev = new Node("Nevins Hall", 11);
		Node palms = new Node("Palms", 12);
		Node ashley = new Node("Ashley Hall", 13);
		Node west = new Node("West Hall", 14);
		Node lang = new Node("Langdale", 15);
		Node reade = new Node("Reade", 16);
		Node bailey = new Node("Bailey Science Center", 17);
		Node ga = new Node("Georgia", 18);
		Node pow = new Node("Powell Hall", 19);
		
		//Make edges
		Edge e1 = new Edge(pe, edu, 770);
		Edge e2 = new Edge(edu, oak, 300);
		Edge e3 = new Edge(edu, union, 480);
		Edge e4 = new Edge(oak, arts, 400);
		Edge e5 = new Edge(arts, odum, 422);
		Edge e6 = new Edge(lowndes, odum, 290);
		Edge e7 = new Edge(lowndes, patt, 248);
		Edge e8 = new Edge(patt, brown, 129);
		Edge e9 = new Edge(brown, odum, 310);
		Edge e10 = new Edge(odum, union, 212);
		Edge e11 = new Edge(odum, conv, 360);
		Edge e12 = new Edge(odum, nev, 260);
		Edge e13 = new Edge(union, hopp, 216);
		Edge e14 = new Edge(hopp, palms, 139);
		Edge e15 = new Edge(conv, ashley, 279);
		Edge e16 = new Edge(conv, nev, 108);
		Edge e17 = new Edge(nev, west, 93);
		Edge e18 = new Edge(palms, lang, 161);
		Edge e19 = new Edge(palms, ashley, 244);
		Edge e20 = new Edge(ashley, lang, 208);
		Edge e21 = new Edge(ashley, reade, 181);
		Edge e22 = new Edge(ashley, west, 109);
		Edge e23 = new Edge(west, bailey, 139);
		Edge e24 = new Edge(lang, ga, 192);
		Edge e25 = new Edge(reade, ga, 157);
		Edge e26 = new Edge(reade, bailey, 96);
		Edge e27 = new Edge(bailey, pow, 91);
		Edge e28 = new Edge(ga, pow, 232);
		
		// Add Edges to Graph
		Graph graph = new Graph(20);
		graph.addEdge(e1);
		graph.addEdge(e2);
		graph.addEdge(e3);
		graph.addEdge(e4);
		graph.addEdge(e5);
		graph.addEdge(e6);
		graph.addEdge(e7);
		graph.addEdge(e8);
		graph.addEdge(e9);
		graph.addEdge(e10);
		graph.addEdge(e11);
		graph.addEdge(e12);
		graph.addEdge(e13);
		graph.addEdge(e14);
		graph.addEdge(e15);
		graph.addEdge(e16);
		graph.addEdge(e17);
		graph.addEdge(e18);
		graph.addEdge(e19);
		graph.addEdge(e20);
		graph.addEdge(e21);
		graph.addEdge(e22);
		graph.addEdge(e23);
		graph.addEdge(e24);
		graph.addEdge(e25);
		graph.addEdge(e26);
		graph.addEdge(e27);
		graph.addEdge(e28);
		
		// Print Original edges
		System.out.println("Original edges in graph:\n\n" + graph);
		
		// Print list of edges in MST
		System.out.println("Edges in MST:\n\n" + graph.printMST());
		System.out.println("Edges removed from graph:\n");
		
		for(Edge e: graph.getRemovedEdges()) {
			System.out.println("\t" + e);
		}
		
		System.out.println();
	}
	
}
