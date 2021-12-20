package MinimumAreaRectangle;

import java.util.*;

class Edge {
	public int y1;
	public int y2;
	Edge(int y1, int y2) {
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge edge = (Edge) o;
		return y1 == edge.y1 && y2 == edge.y2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(y1, y2);
	}
}

class Program {

	public static int minimumAreaRectangle(int[][] points) {
		// Write your code here.
		Map<Integer, List<Integer>> columns = new LinkedHashMap<>();

		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int[] point : points) {
			columns.putIfAbsent(point[0], new ArrayList<>());
			columns.get(point[0]).add(point[1]);
		}

		Map<Edge, Integer> edgeToX = new LinkedHashMap<>();

		int minRectable = Integer.MAX_VALUE;

		for (Map.Entry<Integer, List<Integer>> column : columns.entrySet()) {
			int col = column.getKey();
			List<Integer> rows = column.getValue();
			Collections.sort(rows);

			for (int i = 1; i < rows.size(); i++) {
				for (int j = 0; j < i; j++) {

					Edge e = new Edge(rows.get(j), rows.get(i));

					if (edgeToX.containsKey(e)) {
						int height = Math.abs(rows.get(j) - rows.get(i));
						int width = Math.abs(col - edgeToX.get(e));
						int currArea = width * height;

						if (currArea < minRectable) {
							minRectable = currArea;
						}
					}
					edgeToX.put(e, col);
					//Edge e = new Edge(rows.get(i), rows.get(j));
				}
			}
		}


		return minRectable == Integer.MAX_VALUE ? 0 : minRectable;
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {
				{1,5},
				{5,1},
				{4,2},
				{2,4},
				{2,2},
				{1,2},
				{4,5},
				{2,5},
				{-1,-2}
		};

		minimumAreaRectangle(input);
	}
}
