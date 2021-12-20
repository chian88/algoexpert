package Dijkstra;

import java.util.*;

class Structure {
	int idx;
	int dist;

	Structure(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Structure structure = (Structure) o;
		return idx == structure.idx;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idx);
	}
}

class Program {
	public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		// Write your code here.
		int[] result = new int[edges.length];
		Arrays.fill(result, -1);

		PriorityQueue<Structure> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));

		heap.add(new Structure(start, 0));

		while (!heap.isEmpty()) {
			Structure current = heap.poll();
			if (result[current.idx] < 0 || result[current.idx] > current.dist) {
				result[current.idx] = current.dist;
			}

			int[][] adjacentNodes = edges[current.idx];

			for (int i = 0; i < adjacentNodes.length; i++) {
				int[] node = adjacentNodes[i];

				if (result[node[0]] == -1) {
					Structure newNodeStruct = new Structure(node[0], current.dist + node[1]);
					heap.add(newNodeStruct);
				}

			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][][] edges = {
				{{1,3}, {2,2}},
				{{3,7}},
				{{1,2}, {3,4}, {4,1}},
				{},
				{{0,2}, {1,8}, {3,1}}

		};

		dijkstrasAlgorithm(4, edges);
	}
}
