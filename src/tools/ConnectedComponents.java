package tools;


import main.UnDiGraph;
import main.Vertex;

import java.util.*;

/**
 * A class to find connected components from an undirected graphs
 * i.e. les composantes connexes
 */
public class ConnectedComponents {

	//for each vertex u, connectedComponentsMap.get(u) is the number of the connected component of u
	// Dans la composante connexe de u tous les sommets ont le même numéro et tous les sommets sont par définition connectés , i.e. ils sont reliés par un chemin
	//By this way we don't need to pass the map as a parameter to the methods
	private  Map<Vertex,Integer> connectedComponentsMap; // the resulting map

	private int maxConnectedComponentNumber = 0;
	private final UnDiGraph unDiGraph; // the undirected graph

	public int getMaxConnectedComponentNumber() {
		return maxConnectedComponentNumber;
	}

	/**
	 * Returns the set of vertices of the connected component of 'v'
	 * @param v
	 * @return the set of vertices of the connected component of 'v'
	 */
	public Set<Vertex> getConnectedComponentsTo(Vertex v) {
		//TO IMPLEMENT
		Set<Vertex> result = new HashSet<>();
		return result;
	}


	public ConnectedComponents(UnDiGraph diGraph) {
		connectedComponentsMap = new HashMap<>();
		unDiGraph = diGraph;
	}

	/**
	 * Returns the map of the connected components of 'G'
	 * If cc is the returned map, then, for all vertices u and v,
	 * cc.get(u) = cc.get(v) if and only if u and v are in the same
	 * connected component
	 */
	public Map<Vertex,Integer> find() {
		//TO IMPLEMENT
		return connectedComponentsMap;
	}


	private void setNumber(Vertex u, int number) {
		connectedComponentsMap.put(u, number);
	}

	public static void main(String[] s) {


		UnDiGraph u1 = GraphReader.unDiGraph("A B C D C E D E E F G H G K H I H J H K I J");
		UnDiGraph u2 = GraphReader.unDiGraph("A D A E A J B C B F B G B I C F C G C H D E D F G H");

		ConnectedComponents ccFinder = new ConnectedComponents(u1);

		Map<Vertex,Integer> cc = ccFinder.find();
		System.out.println(cc);
		System.out.println("maxConnectedComponentNumber = " + ccFinder.getMaxConnectedComponentNumber());

		ccFinder = new ConnectedComponents(u2);
		cc = ccFinder.find();
		System.out.println(cc);
		System.out.println("maxConnectedComponentNumber = " + ccFinder.getMaxConnectedComponentNumber());
	}
}
