package prob1;
import java.util.*;

public class Main {
//This implements user input however requires a fulls proper spelling but does ignore case.
	public static void testInputFromUser() {
		int numVertices = 29;
		List<Edge> edges = createEdges();
		Graph graph = new Graph(edges, numVertices);
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the starting building name");
		String begin = scan.nextLine();
		System.out.println("Please input the destination building name");
		String end = scan.nextLine();

		String[] names = names();
		
		int x=0;
		int y=0;
		
		for(int i=0;i<numVertices;i++) {
			if(begin.equalsIgnoreCase(names[i])) {
				x=i;
			}
			if(end.equalsIgnoreCase(names[i])) {
				y=i;
			}
		}
		
		int currentLocation = x;// start
		int destination = y; // destination
		
	// run dijkstra's algo on every node in the graph
		System.out.println("\nPrioritizing Time...");
		for(int start = 0; start < numVertices; start++) {
			findShortestPaths(graph, start, numVertices, currentLocation, destination, "Time");
		}

		System.out.println("\nPrioritizing Distance...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Distance");
		}

			System.out.println("\nPrioritizing Rating...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Rating");
			}

		scan.close();
	}

	
	
	public static void main(String[]args) {
		testLongDistance_SHC_To_Odum();
		testIntermediateDistance_DrexelPark_To_OdumLibrary();
		testShortDistance_StudentUnion_To_AshleyHall();
		testInputFromUser();
	}
	
	public static void testLongDistance_SHC_To_Odum() {
		int numVertices = 29;
		List<Edge> edges = createEdges();
		Graph graph = new Graph(edges, numVertices);
		int currentLocation = 28;
		int destination = 2;
		
		System.out.println("\nStarting Location: " + names()[currentLocation] + "\nDestination: " + names()[destination] + "\n");
		
		// run dijkstra's algo on every node in the graph
		System.out.println("Prioritizing Time...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Time");
			}
		System.out.println("\nPrioritizing Distance...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Distance");
			}
			System.out.println("\nPrioritizing Rating...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Rating");
			}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}
	
	public static void testIntermediateDistance_DrexelPark_To_OdumLibrary() {
		int numVertices = 29;
		List<Edge> edges = createEdges();
		Graph graph = new Graph(edges, numVertices);
		int currentLocation = 25;
		int destination = 2;
		
		System.out.println("\nStarting Location: " + names()[currentLocation] + "\nDestination: " + names()[destination] + "\n");
		
		// run dijkstra's algo on every node in the graph
		System.out.println("Prioritizing Time...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Time");
			}
		System.out.println("\nPrioritizing Distance...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Distance");
			}
			System.out.println("\nPrioritizing Rating...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Rating");
			}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}
	
	public static void testShortDistance_StudentUnion_To_AshleyHall() {
		int numVertices = 29;
		List<Edge> edges = createEdges();
		Graph graph = new Graph(edges, numVertices);
		int currentLocation = 1;
		int destination = 10;
		
		System.out.println("\nStarting Location: " + names()[currentLocation] + "\nDestination: " + names()[destination] + "\n");
		
		// run dijkstra's algo on every node in the graph
		System.out.println("Prioritizing Time...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Time");
			}
		System.out.println("\nPrioritizing Distance...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Distance");
			}
			System.out.println("\nPrioritizing Rating...");
			for(int start = 0; start < numVertices; start++) {
				findShortestPaths(graph, start, numVertices, currentLocation, destination, "Ratings");
			}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}
	
	
	public static void findShortestPaths(Graph graph, int source, int n, int start, int destination, String priority) {
	     PriorityQueue<Node> queue = null;
	     
		//check priority of the path
	     if(priority.equals("Time")) {
	    	 queue = new PriorityQueue<>(Comparator.comparingDouble(node -> node.getTime()));
	     }
	     else if(priority.equals("Distance")) {
	    	 queue = new PriorityQueue<>(Comparator.comparingDouble(node -> node.getCost()));
	     }
	     else {
	    	 queue = new PriorityQueue<>(Comparator.comparingDouble(node -> node.getRating()));
	     }
	     
	     //add first node to queue
	     queue.add(new Node(source, 0.0, 0, 0));
	     
	     List<Double> times = new ArrayList<>(Collections.nCopies(n, Double.MAX_VALUE));
	     List<Double> distances = new ArrayList<>(Collections.nCopies(n, Double.MAX_VALUE));
	     List<Double> ratings = new ArrayList<>(Collections.nCopies(n, Double.MAX_VALUE));
		// holds list of values based on priority parameter
	     List<Double> listOfPriority = new ArrayList<>();

		// set the index of the first node to 0
	     distances.set(source, 0.0);
	     times.set(source, 0.0);
	     ratings.set(source, 0.0);
	     
		// keep track if a node is visited or not
	     boolean[] finalized = new boolean[n];
	     finalized[source] = true;
	     
		// keep track of previous nodes
	     int[] predecessor = new int[n];
	     predecessor[source] = -1;
	     
		// until the queue is empty
	     while(!queue.isEmpty()) {
	    	 Node node = queue.poll();//get and remove the node at the front of the queue
	    	 int currentNode = node.getNode();
	    	 
		     // check the edges in the adjacency list
	    	 for(Edge e: graph.getAdjacencyList().get(currentNode)) {
	    		 int destinationNode = e.getEnd();
	    		 double priorityParameter = 0;

	    		if(priority.equals("Time")) {
				priorityParameter = e.getTime();
				listOfPriority = times;
	    		}
	    	     	else if(priority.equals("Distance")) {
				 priorityParameter = e.getWeight();
				 listOfPriority = distances;
		        }
		        else {
				 priorityParameter = e.getRating();
				 listOfPriority = ratings;
	    	       }
	    		 // if the edge isn't finalized
			 // AND we find an edge with a lower cost
	    		 if(!finalized[destinationNode] && 
	    			(listOfPriority.get(currentNode) + priorityParameter) < listOfPriority.get(destinationNode)) {
	    			 // Update the value of the edge in the list of priority at that index
	    			 listOfPriority.set(destinationNode, (listOfPriority.get(currentNode) + priorityParameter));
				 // set predecessor to the current node
	    			 predecessor[destinationNode] = currentNode;
				 // add the node to the queue
	    			 queue.add((new Node(destinationNode, distances.get(destinationNode), times.get(destinationNode), ratings.get(destinationNode))));
	    		 }
	    	 }
	    	 // set edge to be finalized at the current node
	    	 finalized[currentNode] = true;
	     }
	     
	     List<Integer> route = new ArrayList<>();
	     
	     for(int i = 0; i < n; i++) {
	    	 if(i != source && listOfPriority.get(i) != Double.MAX_VALUE) {
	    		 // Populates route list with the order of nodes to visit
	    		 getRoute(predecessor, i, route);
	    		
			 
	    		 if(source == start && i == destination) {
	    			 // calculates the totals for every priority 
	    			double totalDistance = 0;
	    			double totalTime = 0;
	    			double totalRating = 0;
	    			int counter = 0;
	    			 for(int r = 0; r < route.size()-1; r++) {
	    				 
	    				 String[] names = names();
	    				 double dist = getDistance(route.get(r), route.get(r+1));
	    				 double time = getTime(route.get(r), route.get(r+1));
	    				 double rating = getRating(route.get(r), route.get(r+1));
	    				 totalDistance += dist;
	    				 totalTime += time;
	    				 totalRating += rating;
	    				 counter++;
					 // print the path
	    				 System.out.printf("Please walk %.3fKm (about %.0f feet) from %s to %s for %.0f minutes (approximately %.0f seconds)\n",
							dist, (dist*3280.84), names[route.get(r)], names[route.get(r+1)], time, (time *60));
	    				 
	    			 }
	    			 // print all the totals
	    			 System.out.printf("The total time is %.0f minutes (approximately %.0f seconds) "
					+ "for the total distance of %.3fKm ( about %.0f feet).\nThis route has a rating of %.1f stars.\n", 
					totalTime, (totalTime*60), totalDistance, (totalDistance*3280.84), (totalRating/counter));
	    			break;
	    		 }
	    		 route.clear();
	    	 }
	     }
	     
	 }
	
	public static void findBestPath(Graph graph, int source, int n, int start, int destination) {
		
	}
	 
	 // get the time of the edge with this particular start and end
	 private static double getTime(int start, int end) {
		 List<Edge> edges = createEdges();
			for(Edge e: edges) {
				if(e.getStart() == start && e.getEnd() == end) {
					return e.getTime();
				}
			}
			return 0;
	}

	// get the distance of the edge with this particular start and end
    private static double getDistance(int start, int end) {
	List<Edge> edges = createEdges();
	for(Edge e: edges) {
		if(e.getStart() == start && e.getEnd() == end) {
			return e.getWeight();
		}
	}
	return 0;
	}
    
    // get the rating of the edge with this start and end
    private static double getRating(int start, int end) {
	List<Edge> edges = createEdges();
	for(Edge e: edges) {
		if(e.getStart() == start && e.getEnd() == end) {
			return e.getRating();
		}
	}
	return 0;
	}

    // Get the order of the nodes to visit to get from one point to another
	public static void getRoute(int[] predecessor, int index, List<Integer> route) {
		if(index >= 0) {
			getRoute(predecessor, predecessor[index], route);
			route.add(index);
		}
	}


	// Creates a list of all the edges 
	// edges added twice because the graph is bidirectional
	public static List<Edge> createEdges(){
		 List<Edge> edges = Arrays.asList(
							new Edge(0, 2,  0.128, 4, 3),	
							new Edge(0, 18, 0.168, 4, 2),
							new Edge(0, 20, 0.198, 2, 1),
							new Edge(1, 2, 0.060, 1, 5),
							new Edge(1, 8, 0.065, 1, 4),
							new Edge(1, 17, 0.185, 2, 3),
							new Edge(2, 0, 0.128, 4, 3),
							new Edge(2, 1, 0.065, 1, 5),
							new Edge(2, 3, 0.088, 2, 5),
							new Edge(2, 5, 0.094, 1, 4),
							new Edge(2, 6, 0.079, 2, 5),
							new Edge(2, 7, 0.109, 1, 4),
							new Edge(3, 2, 0.088, 2, 5),
							new Edge(3, 4, 0.076, 1, 5),
							new Edge(4, 3, 0.076, 1, 5),
							new Edge(4, 5, 0.039, 1, 5),
							new Edge(4, 20, 0.244, 5, 1),
							new Edge(4, 26, 0.088, 4, 3),///Pat to Adm
							new Edge(5, 2, 0.094, 1, 4),
							new Edge(5, 4, 0.039, 1, 5),
							new Edge(5, 6, 0.095, 2, 3),
							new Edge(6, 2, 0.079, 2, 5),
							new Edge(6, 5, 0.095, 2, 3),
							new Edge(6, 7, 0.033, 1, 5),
							new Edge(6, 11, 0.028, 1, 5),
							new Edge(7, 2, 0.109, 1, 4),
							new Edge(7, 6, 0.033, 1, 5),
							new Edge(7, 8, 0.065, 1, 4),
							new Edge(7, 10, 0.085, 1, 5),
							new Edge(8, 1, 0.065, 1, 4),
							new Edge(8, 7, 0.065, 1, 4),
							new Edge(8, 9, 0.042, 3, 5),
							new Edge(9, 8, 0.042, 3, 5),
							new Edge(9, 10, 0.074, 3, 5),
							new Edge(9, 14, 0.049, 1, 5),
							new Edge(10, 7, 0.085, 1, 5),
							new Edge(10, 9, 0.074, 3, 5),
							new Edge(10, 11, 0.033, 2, 5),
							new Edge(10, 14, 0.063, 4, 4),
							new Edge(11, 6, 0.028, 1, 5),
							new Edge(11, 10, 0.033, 2, 5),
							new Edge(11, 12, 0.042, 2, 5),
							new Edge(12, 11, 0.042, 2, 5),
							new Edge(12, 13, 0.029, 3, 5),
							new Edge(12, 16, 0.027, 1, 5),
							new Edge(13, 12, 0.029, 3, 5),
							new Edge(13, 14, 0.058, 2, 5),
							new Edge(13, 15, 0.047, 1, 5),
							new Edge(14, 9, 0.049, 1, 5),
							new Edge(14, 10, 0.063, 4, 4),
							new Edge(14, 13, 0.068, 2, 5),
							new Edge(14, 15, 0.058, 2, 5),
							new Edge(15, 13, 0.047, 1, 5),
							new Edge(15, 14, 0.058, 2, 5),
							new Edge(15, 16, 0.070, 4, 3),
							new Edge(15, 28,  0.109, 2, 3), ///GA to SHC
							new Edge(16, 12, 0.027, 1, 5),
							new Edge(16, 15, 0.070, 4, 3),
							new Edge(16, 28, 0.134, 2, 3),///Pow to SHC
							new Edge(17, 1, 0.185, 2, 3),
							new Edge(17, 18, 0.123, 2, 4),
							new Edge(17, 19, 0.254, 6, 2),
							new Edge(18, 0, 0.168, 4, 2),
							new Edge(18, 17, 0.123, 2, 4),
							new Edge(19, 17, 0.254, 6, 2),
							new Edge(19, 22, 0.313, 4, 1),
							new Edge(20, 0, 0.198, 2, 1),
							new Edge(20, 21, 0.213, 5, 1),
							new Edge(20, 25, 0.152, 2, 3),
							new Edge(20, 4, 0.244, 5, 1),
							new Edge(21, 20, 0.213, 5, 1),
							new Edge(21, 25, 0.231, 6, 1),
							new Edge(22, 19, 0.313, 4, 1),
							new Edge(22, 23, 0.121, 4, 2),///Rec to Sust
							new Edge(22, 24, 0.127, 2, 3),///Rec to Centen
							new Edge(23, 22, 0.121, 4, 2),///Sust to Rec
							new Edge(23, 24, 0.121, 4, 2),///Sust to Centen
							new Edge(24, 22, 0.127, 2, 3),///Centen to Rec
							new Edge(24, 23, 0.121, 4, 2),///Centen to Sust
							new Edge(25, 20, 0.152, 2, 3),
							new Edge(25, 21, 0.231, 6, 1),
							new Edge(25, 26, 0.174, 5, 3),///Drexel to Adm
							new Edge(26, 4, 0.088, 4, 3),///Adm to Patt
							new Edge(26, 25, 0.174, 5, 3),///Adm to Drexel
							new Edge(27, 28, 0.167, 3, 4),///Honors to SHC
							new Edge(28, 15, 0.109, 2, 3),///SHC to GA
							new Edge(28, 16, 0.134, 2, 3),///SHC to Pow
							new Edge(28, 27, 0.167, 3, 4)///SHC to Honors
													);
		 return edges;
	 }

	// Creates an array of the names of each building on vsu campus
	 private static String[] names(){
			String[] names = new String[40];
			
			names[0] = "Fine Arts";
			names[1] =  "Student Union";
			names[2] = "Odum Library";
			names[3] = "Lowndes Hall";
			names[4] = "Patterson Hall";
			names[5] = "Brown Hall";
			names[6] = "Nevin's Hall";
			names[7] = "Converse Hall";
			names[8] = "Hopper Hall";
			names[9] = "Palm's Dining";
			names[10] ="Ashley Hall";
			names[11] = "West Hall";
			names[12] = "Bailey Science Center";
			names[13] = "Reade Hall";
			names[14] = "Langdale Hall";
			names[15] = "Georgia Hall";
			names[16] = "Powell Hall";
			names[17] = "Education Building";
			names[18] = "Oak Parking Deck";
			names[19] = "PE Complex";
			names[20] = "Communication Arts";
			names[21] = "University Center";
			names[22] = "Student Rec Center";
			names[23] = "Sustella Parking Deck";
			names[24] = "Centennial Hall";
			names[25] = "Drexel Park"; 
			names[26] = "Admissions";
			names[27] = "Honor's House";
			names[28] = "Student Health Center";
			
			
			return names;
		}
}
