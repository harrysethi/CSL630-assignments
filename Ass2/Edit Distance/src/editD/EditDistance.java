package editD;

import constants.EditDConstants;
import constants.OpType;

/**
 * 
 */

/**
 * @author harinder
 *
 */
public class EditDistance {

	public static void EditDist(char[] x, char[] y, int[] cost, int[][] c,
			OpType[][] op) {

		int costCopy = cost[0];
		int costReplace = cost[1];
		int costInsert = cost[2];
		int costDelete = cost[3];

		for (int i = 0; i <= x.length; i++) {
			c[i][0] = i * costDelete;
			op[i][0] = OpType.DELETE;
		}

		for (int j = 0; j <= y.length; j++) {
			c[0][j] = j * costInsert;
			op[0][j] = OpType.INSERT;
		}

		populate_costAndOp_arrays(x, y, costCopy, costReplace, costInsert,
				costDelete, c, op);

		System.out.println("Done");
	}

	private static void populate_costAndOp_arrays(char[] x, char[] y,
			int costCopy, int costReplace, int costInsert, int costDelete,
			int[][] c, OpType[][] op) {
		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				c[i][j] = EditDConstants.INFINITY;

				if (x[i - 1] == y[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + costCopy;
					op[i][j] = OpType.COPY;
				}

				if ((x[i - 1] != y[j - 1])
						&& (c[i - 1][j - 1] + costReplace < c[i][j])) {
					c[i][j] = c[i - 1][j - 1] + costReplace;
					op[i][j] = OpType.REPLACE;
				}

				if (c[i - 1][j] + costDelete < c[i][j]) {
					c[i][j] = c[i - 1][j] + costDelete;
					op[i][j] = OpType.DELETE;
				}

				if (c[i][j - 1] + costInsert < c[i][j]) {
					c[i][j] = c[i][j - 1] + costInsert;
					op[i][j] = OpType.INSERT;
				}
			}
		}
	}

	public static void opSequence(OpType[][] op, int i, int j) {
		int i1 = 0, j1 = 0;
		if (i == 0 && j == 0) {
			return;
		}

		switch (op[i][j]) {
		case COPY:
			i1 = i - 1;
			j1 = j - 1;
			break;
		case REPLACE:
			i1 = i - 1;
			j1 = j - 1;
			break;
		case DELETE:
			i1 = i - 1;
			j1 = j;
			break;
		case INSERT:
			i1 = i;
			j1 = j - 1;
			break;
		default:
			break;
		}

		opSequence(op, i1, j1);
		printOp(op[i][j]);
	}

	private static void printOp(OpType opType) {
		switch (opType) {
		case COPY:
			System.out.println("Copy");
			break;
		case REPLACE:
			System.out.println("Replace");
			break;
		case INSERT:
			System.out.println("Insert");
			break;
		case DELETE:
			System.out.println("Delete");
			break;
		default:
			break;
		}
	}
}
