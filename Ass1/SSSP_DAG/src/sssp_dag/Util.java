/**
 * 
 */
package sssp_dag;

import java.util.List;

import constants.SsspDagConstants;

/**
 * @author Harinder Sethi
 * 
 */
public class Util {

	public static List<Integer> getAdjacencies(List<Integer>[] graph, int vertex) {
		List<Integer> adjacencies = graph[vertex];		
		return adjacencies;
	}

	public static void intialize_single_source(int[] dist, int[] prev,
			int source, int numOfV) {
		for (int i = 0; i < numOfV; i++) {
			dist[i] = SsspDagConstants.INFINITY;
			prev[i] = SsspDagConstants.NILL_PREVIOUS;
		}
		dist[source] = 0;
	}

	public static void relax_edge(int[] dist, int[] prev, int[][] weight,
			int u, int v) {
		if (dist[v] > dist[u] + weight[u][v]) {
			dist[v] = dist[u] + weight[u][v];
			prev[v] = u;
		}
	}
}
