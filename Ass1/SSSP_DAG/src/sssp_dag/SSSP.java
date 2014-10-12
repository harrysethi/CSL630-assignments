/**
 * 
 */
package sssp_dag;

import java.util.List;

import exception.InvalidGraphException;

/**
 * @author Harinder Sethi
 * 
 */

public class SSSP {

	public static void sssp_dag(List<Integer>[] graph, int[][] weight,
			int source) throws InvalidGraphException {

		int numOfV = graph.length;
		int[] dist = new int[numOfV];
		int[] prev = new int[numOfV];

		List<Integer> topSortOrder = TopSort.getTopSortOrder(graph, source);
		Util.intialize_single_source(dist, prev, source, numOfV);

		for (int vertexInOrder : topSortOrder) {
			List<Integer> adjacencies = Util.getAdjacencies(graph,
					vertexInOrder);
			if (adjacencies != null) {
				for (int adjVertex : adjacencies) {
					Util.relax_edge(dist, prev, weight, vertexInOrder,
							adjVertex);
				}
			}
		}

		System.out.println("Distance array: ");
		for (int i = 0; i < numOfV; i++) {
			System.out.println(dist[i]);
		}
		System.out.println("Previous array: ");
		for (int i = 0; i < numOfV; i++) {
			System.out.println(prev[i]);
		}
	}

}
