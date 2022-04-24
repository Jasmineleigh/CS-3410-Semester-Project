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
		Edge e4 = new Edge(edu, pe, 770);
		edu.addEdge(e2);
		edu.addEdge(e3);
		edu.addEdge(e4);
		
		Edge e5 = new Edge(oak, arts, 400);
		Edge e6 = new Edge(oak, edu, 300);
		oak.addEdge(e5);
		oak.addEdge(e6);
		
		Edge e7 = new Edge(arts, odum, 422);
		Edge e8 = new Edge(arts, oak, 400);
		arts.addEdge(e7);
		arts.addEdge(e8);
		
		Edge e9 = new Edge(lowndes, odum, 290);
		Edge e10 = new Edge(lowndes, patt, 248);
		lowndes.addEdge(e9);
		lowndes.addEdge(e10);
		
		Edge e11 = new Edge(patt, brown, 129);
		Edge e12 = new Edge(patt, lowndes, 248);
		patt.addEdge(e11);
		patt.addEdge(e12);
		
		Edge e13 = new Edge(brown, odum, 310);
		Edge e14 = new Edge(brown, patt, 129);
		brown.addEdge(e13);
		brown.addEdge(e14);
		
		Edge e15 = new Edge(odum, union, 212);
		Edge e16 = new Edge(odum, conv, 360);
		Edge e17 = new Edge(odum, nev, 260);
		Edge e18 = new Edge(odum, arts, 422);
		Edge e19 = new Edge(odum, lowndes, 290);
		Edge e20 = new Edge(odum, brown, 310);
		odum.addEdge(e15);
		odum.addEdge(e16);
		odum.addEdge(e17);
		odum.addEdge(e18);
		odum.addEdge(e19);
		odum.addEdge(e20);
		
		Edge e21 = new Edge(union, hopp, 216);
		Edge e22 = new Edge(union, edu, 480);
		Edge e23 = new Edge(union, odum, 212);
		union.addEdge(e21);
		union.addEdge(e22);
		union.addEdge(e23);
		
		Edge e24 = new Edge(hopp, palms, 139);
		Edge e25 = new Edge(hopp, union, 216);
		hopp.addEdge(e24);
		hopp.addEdge(e25);
		
		Edge e26 = new Edge(conv, ashley, 279);
		Edge e27 = new Edge(conv, nev, 108);
		Edge e28 = new Edge(conv, odum, 360);
		conv.addEdge(e26);
		conv.addEdge(e27);
		conv.addEdge(e28);
		
		Edge e29 = new Edge(nev, west, 93);
		Edge e30 = new Edge(nev, conv, 108);
		Edge e31 = new Edge(nev, odum, 260);
		nev.addEdge(e29);
		nev.addEdge(e30);
		nev.addEdge(e31);
		
		Edge e32 = new Edge(palms, lang, 161);
		Edge e33 = new Edge(palms, ashley, 244);
		Edge e34 = new Edge(palms, hopp, 139);
		palms.addEdge(e32);
		palms.addEdge(e33);
		palms.addEdge(e34);
		
		Edge e35 = new Edge(ashley, lang, 208);
		Edge e36 = new Edge(ashley, reade, 181);
		Edge e37 = new Edge(ashley, west, 109);
		Edge e38 = new Edge(ashley, palms, 244);
		Edge e39 = new Edge(ashley, conv, 279);
		ashley.addEdge(e35);
		ashley.addEdge(e36);
		ashley.addEdge(e37);
		ashley.addEdge(e38);
		ashley.addEdge(e39);
		
		Edge e40 = new Edge(west, bailey, 139);
		Edge e41 = new Edge(west, ashley, 109);
		Edge e42 = new Edge(west, nev, 93);
		west.addEdge(e40);
		west.addEdge(e41);
		west.addEdge(e42);
		
		Edge e43 = new Edge(lang, ga, 192);
		Edge e44 = new Edge(lang, palms, 161);
		Edge e45 = new Edge(lang, ashley, 208);
		lang.addEdge(e43);
		lang.addEdge(e44);
		lang.addEdge(e45);
		
		Edge e46 = new Edge(reade, ga, 157);
		Edge e47 = new Edge(reade, bailey, 96);
		Edge e48 = new Edge(reade, ashley, 181);
		reade.addEdge(e46);
		reade.addEdge(e47);
		reade.addEdge(e48);
		
		Edge e49 = new Edge(bailey, pow, 91);
		Edge e50 = new Edge(bailey, reade, 96);
		Edge e51 = new Edge(bailey, west, 139);
		bailey.addEdge(e49);
		bailey.addEdge(e50);
		bailey.addEdge(e51);
		
		Edge e52 = new Edge(ga, pow, 232);
		Edge e53 = new Edge(ga, lang, 192);
		Edge e54 = new Edge(ga, reade, 157);
		ga.addEdge(e52);
		ga.addEdge(e53);
		ga.addEdge(e54);
		
		Edge e55 = new Edge(pow, ga, 232);
		Edge e56 = new Edge(pow, bailey, 91);
		pow.addEdge(e55);
		pow.addEdge(e56);
		
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
		graph.addEdge(e29);
		graph.addEdge(e30);
		graph.addEdge(e31);
		graph.addEdge(e32);
		graph.addEdge(e33);
		graph.addEdge(e34);
		graph.addEdge(e35);
		graph.addEdge(e36);
		graph.addEdge(e37);
		graph.addEdge(e38);
		graph.addEdge(e39);
		graph.addEdge(e40);
		graph.addEdge(e41);
		graph.addEdge(e42);
		graph.addEdge(e43);
		graph.addEdge(e44);
		graph.addEdge(e45);
		graph.addEdge(e46);
		graph.addEdge(e47);
		graph.addEdge(e48);
		graph.addEdge(e49);
		graph.addEdge(e50);
		graph.addEdge(e51);
		graph.addEdge(e52);
		graph.addEdge(e53);
		graph.addEdge(e54);
		graph.addEdge(e55);
		graph.addEdge(e56);
		
		System.out.println(graph);
	}
}
