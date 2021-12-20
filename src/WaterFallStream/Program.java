package WaterFallStream;

import java.util.*;

class Tuple {
	public int row;
	public int col;
	public double percentage;
	public String previousDirection;
	Tuple (int row, int col, double percentage, String previousDirection) {
		this.row = row;
		this.col = col;
		this.percentage = percentage;
		this.previousDirection = previousDirection;
	}
}

class Program {
	public static double[] waterfallStreams(double[][] array, int source) {
		// Write your code here.
		Queue<Tuple> locations = new ArrayDeque<>();
		locations.offer(new Tuple(0, source, 100.0, "down"));

		int rowLimit = array.length;
		int colLimit = array[0].length;

		List<Tuple> res = new ArrayList<>();

		while ( !locations.isEmpty()) {
			Tuple current = locations.poll();

			if (current.row == rowLimit - 1 ) {
				res.add( new Tuple(current.row, current.col, current.percentage, "down"));
			} else if ( (current.row + 1 < rowLimit ) && array[current.row + 1][current.col] == 0) {
				// down is clear.
				locations.offer(new Tuple(current.row + 1, current.col, current.percentage, "down"));

			} else if ((current.row + 1 < rowLimit ) && array[current.row + 1][current.col] == 1) {
				// down got block. split to left and right. 50
				if (current.col + 1 < colLimit && array[current.row][current.col + 1] == 0 && current.previousDirection == "down") {
					locations.offer(new Tuple(current.row, current.col + 1, current.percentage / 2.0, "right"));
				}

				if (current.col + 1 < colLimit && array[current.row][current.col + 1] == 0 && current.previousDirection == "right") {
					locations.offer(new Tuple(current.row, current.col + 1, current.percentage, "right"));
				}

				if (current.col - 1 >= 0 && array[current.row][current.col - 1] == 0 && current.previousDirection == "down") {
					locations.offer(new Tuple(current.row, current.col - 1, current.percentage / 2.0, "left"));
				}

				if (current.col - 1 >= 0 && array[current.row][current.col - 1] == 0 &&  current.previousDirection == "left") {
					locations.offer(new Tuple(current.row, current.col - 1, current.percentage, "left"));
				}
			}

		}
		double[] result = new double[array[0].length];

		for (Tuple tup : res) {
			result[tup.col] += tup.percentage;
		}

		return result;
	}

	public static void main(String[] args) {
		double[][] input = new double[][] {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
											{0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
											{0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
											{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};

		waterfallStreams(input, 8);


	}
}
