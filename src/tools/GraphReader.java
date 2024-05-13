package tools;

import main.*;

import java.util.Scanner;

/**
 * This is a convenience class to build a graph from an input String.
 * Non weighted graphs are given as a sequence of pairs of vertex tags like "A B A C ..."
 * which will add the vertices A, B, C, etc. and the edge (A,B), (A,C), etc. to the graph.
 *
 * Weighted graphs are given as sequence of three items, two vertices followed by a weight
 * (a double value) like "A B 2.5 A C 5.2 ..." which will add vertices A, B, C, etc. and the
 * weighted edges (A,B,2.5), (A,C,5.2), etc. to the graph.
 */
public class GraphReader {


	public static void readGraph(Graph graph, String input) {
		Scanner scanner = new Scanner(input);
		try {
			if (weighted(input)) {
				readWeightedGraph(graph, scanner);
			} else
				readGraph(graph, scanner);
			scanner.close();
		} catch (DuplicateTagException e) {
			throw new IllegalArgumentException("Duplicate vertex tag: " + e.getMessage());
		}
	}


	public static boolean weighted(String input) {
		try (Scanner scanner = new Scanner(input)) {
			String line = scanner.nextLine();
			String[] parts = line.split(" ");
			try {
				Double.parseDouble(parts[2]);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
	}

	public static void readWeightedGraph(Graph graph, Scanner input) throws DuplicateTagException {

		String u;
		String v;
		double w;

		String line = input.nextLine();
		String[] parts = line.split(" ");

		for (int i = 0; i < parts.length-2; i+=3) {
			u = parts[i];
			v = parts[i+1];
			w = Double.parseDouble(parts[i+2]);
			Vertex uu = addVertex(graph, u);
			Vertex vv = addVertex(graph, v);
			graph.addEdge(uu, vv, w);
		}
	}

	public static void readGraph(Graph graph, Scanner input) throws DuplicateTagException {
		String u;
		String v;
		while ( input.hasNext() ) {
			u = input.next();
			if ( input.hasNext() )
				v = input.next();
			else
				throw new BadInputGraphException("");
			Vertex uu = addVertex(graph,u);
			Vertex vv = addVertex(graph,v);
			graph.addEdge(uu, vv);
		}
	}

	public static Vertex addVertex(Graph graph, String u) throws DuplicateTagException {
		Vertex v = graph.getVertex(u);
		if ( v == null )
			return graph.addVertex(u);
		return v;
	}


	/**
	 * Returns an main.UnDiGraph build from the String
	 * representation 'input'
	 */
	public static UnDiGraph unDiGraph(String input)  {
		UnDiGraph graph = new UnDiGraph();

		readGraph(graph,input);
		return graph;
	}

	/**
	 * Returns an main.DiGraph build from the String
	 * representation 'input'
	 */
	public static DiGraph diGraph(String input)  {
		DiGraph graph = new DiGraph();
		readGraph(graph,input);
		return graph;
	}










}
