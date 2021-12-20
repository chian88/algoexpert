package AStar;

import java.util.*;

class Point {
	int row;
	int col;
	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return row == point.row && col == point.col;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, col);
	}
}

class Node {
	Point point;
	int priority;
	int distFromStart;
	Node(int row, int col, int priority, int distFromStart) {
		this.point = new Point(row, col);
		this.priority = priority;
		this.distFromStart = distFromStart;
	}


}

class Program {

	public static int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
		// Write your code here.
		PriorityQueue<Node> heap = new PriorityQueue<>( (Node n1, Node n2) -> {
			return Integer.compare(n1.priority, n2.priority);
		});

		Map<Point, Point> cameFrom = new HashMap<>();
		Map<Point, Integer> costSoFar = new HashMap<>();

		Set<Point> visited = new HashSet<>();
		heap.add(new Node(startRow, startCol, 0, 0));

		cameFrom.put( new Point(startRow, startCol) , null);
		boolean found = false;
		while (!heap.isEmpty()) {
			Node current = heap.poll();

			visited.add(new Point(current.point.row, current.point.col));

			if (current.point.row == endRow && current.point.col == endCol) {
				found = true;
				break;
			}

			List<Point> locations = validNextMove(current, graph);

			for (Point location : locations) {
				if (!visited.contains(location)) {
					Node nextNode = new Node(location.row, location.col,
							current.distFromStart + 1 + manhattanDist(location, endRow, endCol),
							current.distFromStart + 1);
					heap.add(nextNode);

					Point nextPoint = new Point(location.row, location.col);

					if (!costSoFar.containsKey(nextPoint) || costSoFar.get(nextPoint) > current.distFromStart + 1) {
						costSoFar.put(nextPoint, current.distFromStart + 1);
						cameFrom.put(nextPoint, new Point(current.point.row, current.point.col));
					}


				}


			}
		}

		if (!found) return new int[][]{};

		List<Point> res = new ArrayList<>();

		Point curr = new Point(endRow, endCol);
		res.add(curr);
		while (cameFrom.get(curr) != null) {
			res.add(cameFrom.get(curr));
			curr = cameFrom.get(curr);
		}




		int[][] result = new int[res.size()][2];



		for (int i = res.size() - 1; i >= 0; i--) {
			Point current = res.get(i);

			result[res.size() - 1 - i] = new int[] {current.row, current.col };
		}



		return result;
	}

	static int manhattanDist(Point location, int endRow, int endCol) {
		return Math.abs(endRow - location.row) + Math.abs(endCol - location.col);
	}


	static List<Point> validNextMove(Node current, int[][] graph) {
		List<Point> moves = new ArrayList<>();

		// left
		if (current.point.col - 1 >= 0 && graph[current.point.row][current.point.col - 1] == 0) {
			moves.add(new Point(current.point.row, current.point.col - 1));
		}
		// right
		if (current.point.col + 1 < graph[0].length && graph[current.point.row][current.point.col + 1] == 0) {
			moves.add(new Point(current.point.row, current.point.col + 1));
		}

		// top
		if (current.point.row - 1 >= 0 && graph[current.point.row - 1][current.point.col] == 0) {
			moves.add(new Point(current.point.row - 1, current.point.col));
		}

		// right

		if (current.point.row + 1 < graph.length && graph[current.point.row + 1][current.point.col] == 0) {
			moves.add(new Point(current.point.row + 1, current.point.col));
		}

		return moves;
	}

	public static void main(String[] args) {
		int[][] graph = {{0,0,0,0,0}, {0,1,1,1,0}, {0,0,0,0,0}, {1,0,1,1,1}, {0,0,0,0,0}};

		aStarAlgorithm(0,1,4,3, graph);
	}
}
