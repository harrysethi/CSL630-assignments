package test;

import java.util.Scanner;

import constants.OpType;
/**
 * 
 */
import editD.EditDistance;

/**
 * @author harinder
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first string:");
		String s1 = in.nextLine();

		System.out.println("Enter the second string:");
		String s2 = in.nextLine();

		System.out.println("Enter the costCopy:");
		int costCopy = in.nextInt();

		System.out.println("Enter the costReplace:");
		int costReplace = in.nextInt();

		System.out.println("Enter the costInsert:");
		int costInsert = in.nextInt();

		System.out.println("Enter the costDelete:");
		int costDelete = in.nextInt();

		char[] x = s1.toCharArray();
		char[] y = s2.toCharArray();

		int lx = x.length;
		int ly = y.length;

		int c[][] = new int[lx + 1][ly + 1];
		OpType op[][] = new OpType[lx + 1][ly + 1];

		int[] cost = { costCopy, costReplace, costInsert, costDelete };

		EditDistance.EditDist(x, y, cost, c, op);
		System.out.println("Cost: " + c[lx][ly]);
		EditDistance.opSequence(op, lx, ly);

		in.close();
	}
}
