package TopologicalSort;

import java.util.*;




class Program {
	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
		// Write your code here.
		Set<Integer> visited = new HashSet<>();

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < jobs.size(); i++) {
			Integer job = jobs.get(i);

			if (!visited.contains(job)) {
				Set<Integer> inProgress = new HashSet<>();
				if (!topologicalSortHelper(job, deps, visited, result, inProgress)) return new ArrayList<>();
			}
		}

		return result;
	}

	public static boolean topologicalSortHelper(Integer current, List<Integer[]> deps, Set<Integer> visited, List<Integer> result
	, Set<Integer> inProgress) {
		// Write your code here.
		visited.add(current);
		inProgress.add(current);

		for (int i = 0; i < deps.size(); i++) {
			Integer[] dep = deps.get(i);
			int from = dep[0];
			int to = dep[1];

			if (to == current && inProgress.contains(from)) {
				return false;
			}

			if (to == current && !visited.contains(from)) {
				if (!topologicalSortHelper(from, deps, visited, result, inProgress)) return false;
			}
		}
		inProgress.remove(current);
		result.add(current);

		return true;
	}

	public static void main(String[] args) {
		Integer[][] arr = new Integer[][]{{1,2}, {1,3}, {3,2}, {4,2}, {4,3}};

		List<Integer[]> deps = new ArrayList<>(Arrays.asList(arr));

		List<Integer> jobs = new ArrayList<>(Arrays.asList(1,2,3,4));

		System.out.println(topologicalSort(jobs, deps));
	}
}
