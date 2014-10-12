/**
 * 
 */
package sssp_dag;

import java.util.LinkedList;
import java.util.List;

import exception.InvalidGraphException;

/**
 * @author Harinder Sethi
 * 
 */
public class TopSort {

	static boolean[] visited;
	static boolean[] visiting;

	public static List<Integer> getTopSortOrder(List<Integer>[] graph,
			int source) throws InvalidGraphException {
		int numOfV = graph.length;
		visited = new boolean[numOfV];
		visiting = new boolean[numOfV];

		List<Integer> topSortOrder = new LinkedList<>();
		topSort(graph, source, topSortOrder);
		return topSortOrder;
	}

	public static void topSort(List<Integer>[] graph, int vertex,
			List<Integer> topSortOrder) throws InvalidGraphException {

		// Checking whether the graph contains a cycle
		if (visiting[vertex]) {
			throw new InvalidGraphException("Invalid Graph --- contains cycle");
		}

		visiting[vertex] = true;

		if (!visited[vertex]) {
			topSortOrder.add(vertex);
			List<Integer> adjacencies = Util.getAdjacencies(graph, vertex);
			if (adjacencies != null) {
				for (int adjVertex : adjacencies) {
					topSort(graph, adjVertex, topSortOrder);
				}
			}
			visited[vertex] = true;
		}
		visiting[vertex] = false;
	}

}
