package MinimumPassesOfMatrix;

import java.util.*;

class Program {

	public static int minimumPassesOfMatrix(int[][] matrix) {
		// Write your code here.
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		Deque<Integer[]> mainQueue = new ArrayDeque<>();
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (!visited[row][col] && matrix[row][col] > 0) {
					mainQueue.addLast(new Integer[]{row, col});
					visited[row][col] = true;
				}
			}
		}
		int pass = bfsHelper(matrix, visited, -1, mainQueue);
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] < 0) return -1;
			}
		}

		return pass;
	}

	static int bfsHelper(int[][] matrix, boolean[][] visited, int passes, Deque<Integer[]> mainQueue) {
		Deque<Integer[]> secondaryQueue = new ArrayDeque<>();

		while (!mainQueue.isEmpty()) {

			Integer[] coor = mainQueue.removeFirst();
			int row = coor[0];
			int col = coor[1];

			if (matrix[row][col] < 0) matrix[row][col] *= -1;


			if (row - 1 >= 0 && matrix[row - 1][col] < 0 && !visited[row - 1][col] ) {
				visited[row - 1][col] = true;
				secondaryQueue.addLast(new Integer[]{row - 1, col});
			}

			if (row + 1 < matrix.length && matrix[row + 1][col] < 0 && !visited[row + 1][col]) {
				visited[row + 1][col] = true;
				secondaryQueue.addLast(new Integer[]{row + 1, col});
			}

			if (col - 1 >= 0 && matrix[row][col - 1] < 0 && !visited[row][col - 1]) {
				visited[row][col - 1] = true;
				secondaryQueue.addLast(new Integer[]{row, col - 1});
			}

			if (col + 1 < matrix[0].length && matrix[row][col + 1] < 0 && !visited[row][col + 1]) {
				visited[row][col + 1] = true;
				secondaryQueue.addLast(new Integer[]{row, col + 1});
			}
			if (mainQueue.isEmpty()) {
				passes++;
				mainQueue.addAll(secondaryQueue);
				secondaryQueue.clear();

			}

		}


		return passes;
	}

	public static void main(String[] args) {
		System.out.println(minimumPassesOfMatrix(new int[][]{{-1,-9,0, -1,0}, {-9,-4,-5,4,-8}, {2,0,0,-3,0}, {0,-17,-4,2,-5}}));
	}
}
