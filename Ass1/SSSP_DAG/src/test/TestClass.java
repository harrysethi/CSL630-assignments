/**
 * 
 */
package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import sssp_dag.SSSP;
import exception.InvalidGraphException;

/**
 * @author Harinder Sethi
 * 
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out
				.println("Enter the graph (name vertices in increasing numbers from 0)");
		System.out.println("example - 0,1,2 0,2,15 1,2,3");
		String graphInput = in.nextLine();

		String[] edges = graphInput.split(" ");
		int numOfV = edges.length;

		List<Integer>[] graph = new List[numOfV];
		int[][] weight = new int[numOfV][numOfV];

		for (String edge : edges) {
			String[] s = edge.split(",");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			List<Integer> g = graph[u];
			if(g == null) {
				g = new LinkedList<>();
				graph[u] = g;
			}			
			g.add(v);
			weight[u][v] = d;
		}

		try {
			SSSP.sssp_dag(graph, weight, 0);
		} catch (InvalidGraphException e) {
			System.out.println(e.getMessage());
		}

	}
}
