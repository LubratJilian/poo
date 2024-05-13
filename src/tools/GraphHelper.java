package tools;


import main.*;

import java.util.*;

/**
 * A class to help in graph processing
 * i.e. to find cycles, paths, roots, etc.
 */
public class GraphHelper {

	private Graph aGraph;


	/* ------------------- Cycle detection ------------------- */
	/* Cycle detection depends on the type of the graph
	 * For undirected graphs, we use a depth first search and a set of visited vertices
	 * to avoid visiting the same vertex more than once but we have to check if the vertex from which we came is not the vertex we are visiting
	 *
	 *
	 * For directed graphs, we use a depth first search with a status for each vertex
	 * The status of a vertex can be one of the following:
	 * 	- UN_DISCOVERED : the vertex was not visited
	 * 	- IN_PROGRESS : the vertex is being visited, i.e. we are visiting its adjacent vertices
	 * 	- COMPLETED : the vertex was visited and all its adjacent vertices were visited
	 */


	public GraphHelper() {
		//TO IMPLEMENT
	}

	/**
	 * Returns true if the graph 'G' is cyclic
	 * false otherwise
	 * Precondition: the graph is undirected
	 */
	public boolean hasCycle(UnDiGraph aGraph) {
		//TO IMPLEMENT
		// no cycle was found
		return false;
	}
	
	/**
	 * Returns true if a cycle was found by traversing
	 * the graph, coming from vertex from and going by vertex u
	 * Precondition: vertex 'from' is visited and vertex 'u' is
	 * not visited
	 */
	private boolean hasCycle(Vertex u, Vertex from) {
		//TO IMPLEMENT
		return false;
	}
	
	/////////////// Cycle detection for directed graphs
	
	private enum Status {UN_DISCOVERED, IN_PROGRESS, COMPLETED} // status of vertex

	/**
	 * Returns true if the graph 'diGraph' is cyclic
	 * false otherwise
	 */
	public boolean hasCycle(DiGraph diGraph) {
		//TO IMPLEMENT
		return false;
	}

	
	/**
	 * Returns true if a cycle was found by traversing
	 * the graph from vertex u
	 * Precondition: vertex 'u' is 'UnDiscovered'
	 */
	private boolean hasCycle(Vertex u) {
		//TO IMPLEMENT
		return false;
	}

	/* ------------------- Path finding ------------------- */

	/**
	 * Returns a path as from vertex 'u' to vertex 'v' in the graph 'G'
	 * as a list of vertices if such a path exists, the empty list otherwise
	 */
	public List<Vertex> findPath(Graph graph, Vertex from, Vertex to) {
		//TO IMPLEMENT
		List<Vertex> path = new LinkedList<>();
		return path;
	}


	/* ------------------- Distance computation ------------------- */
	public  double computeDistanceOfPath(List<Vertex> path, AbstractGraph graph) {
		//TO IMPLEMENT
		return 0.0;
	}

	/* ------------------- Root finding ------------------- */

	/**
	 * Returns a root of the graph 'diGraph' if
	 * such root exists, null otherwise
	 */
	public Optional<Vertex> findRoot(DiGraph diGraph) {
		//TO IMPLEMENT
		return Optional.empty();
	}




}
