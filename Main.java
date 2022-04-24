package finalProject;

public class Main {
	public static void main(String[] args) {
		//add nodes
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
		Node pow = new Node("Powell Hall", 1);
		
		//add edges
		Edge e1 = new Edge(pe, edu, 770);
		pe.addEdge(e1);
		
		Edge e2 = new Edge(edu, oak, 300);
		Edge e3 = new Edge(edu, union, 480);
		edu.addEdge(e2);
		edu.addEdge(e3);
		
		Edge e4 = new Edge(oak, arts, 400);
		oak.addEdge(e4);
		
		Edge e5 = new Edge(arts, odum, 422);
		arts.addEdge(e5);
		
		Edge e6 = new Edge(lowndes, odum, 290);
		Edge e7 = new Edge(lowndes, patt, 248);
		lowndes.addEdge(e6);
		lowndes.addEdge(e7);
		
		Edge e8 = new Edge(patt, brown, 129);
		patt.addEdge(e8);
		
		Edge e9 = new Edge(brown, odum, 310);
		brown.addEdge(e9);
		
		Edge e10 = new Edge(odum, union, 212);
		Edge e11 = new Edge(odum, conv, 360);
		Edge e12 = new Edge(odum, nev, 260);
		odum.addEdge(e10);
		odum.addEdge(e11);
		odum.addEdge(e12);
		
		Edge e13 = new Edge(union, hopp, 216);
		union.addEdge(e13);
		
		Edge e14 = new Edge(hopp, palms, 139);
		hopp.addEdge(e14);
		
		Edge e15 = new Edge(conv, ashley, 279);
		Edge e16 = new Edge(conv, nev, 108);
		conv.addEdge(e15);
		conv.addEdge(e16);
		
		Edge e17 = new Edge(nev, west, 93);
		nev.addEdge(e17);
		
		Edge e18 = new Edge(palms, lang, 161);
		Edge e19 = new Edge(palms, ashley, 244);
		palms.addEdge(e18);
		palms.addEdge(e19);
		
		Edge e20 = new Edge(ashley, lang, 208);
		Edge e21 = new Edge(ashley, reade, 181);
		Edge e22 = new Edge(ashley, west, 109);
		ashley.addEdge(e20);
		ashley.addEdge(e21);
		ashley.addEdge(e22);
		
		Edge e23 = new Edge(west, bailey, 139);
		west.addEdge(e23);
		
		Edge e24 = new Edge(lang, ga, 192);
		lang.addEdge(e24);
		
		Edge e25 = new Edge(reade, ga, 157);
		Edge e26 = new Edge(reade, bailey, 96);
		reade.addEdge(e25);
		reade.addEdge(e26);
		
		Edge e27 = new Edge(bailey, pow, 91);
		bailey.addEdge(e27);
		
		Edge e28 = new Edge(ga, pow, 232);
		ga.addEdge(e28);
		
		Graph graph = new Graph(28);
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
		
		System.out.println(graph);
	}
}
