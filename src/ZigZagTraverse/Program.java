package ZigZagTraverse;

import java.util.*;

class Program {
	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		// Write your code here.
		int row = 0, col = 0;

		int rowLimit = array.size();
		int colLimit = array.get(0).size();

		boolean goDown = true;

		List<Integer> res = new ArrayList<>();

		while ( !(row == rowLimit - 1  && col == colLimit - 1) ) {

			if (goDown) {
				while (row < rowLimit && col >= 0) {
					res.add(array.get(row).get(col));

					// hit bottom
					if (row + 1 == rowLimit && col + 1 != colLimit) {
						col++;
						break;
					}


					// hit left
					if (col - 1 == -1 && row + 1 != rowLimit) {
						row++;
						break;
					}

					row++;
					col--;
				}
			} else {
				// go up
				while (row >= 0 && col < colLimit) {
					res.add(array.get(row).get(col));


					// hit top.
					if (row - 1 == -1 && col + 1 != colLimit) {
						col++;
						break;
					}

					// hit right
					if (col + 1 == colLimit && row + 1 != rowLimit) {
						row++;
						break;
					}

					row--;
					col++;
				}
			}
			goDown = !goDown;

		}
		res.add(array.get(row).get(col));

		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();

		input.add(Arrays.asList(1,3,4,10));
		input.add(Arrays.asList(2,5,9,11));
		input.add(Arrays.asList(6,8,12,15));
		input.add(Arrays.asList(7,13,14,16));
		zigzagTraverse(input);

	}
}
