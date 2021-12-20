package TaskAssignment;

import java.util.*;

class Pair {
	int idx;
	int task;

	Pair(int idx, int task) {
		this.idx = idx;
		this.task = task;
	}
}

class Program {

	public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
		// Write your code here.
		ArrayList<Pair> pairs = new ArrayList<>();

		for (int i = 0; i < tasks.size(); i++) {
			pairs.add(new Pair(i, tasks.get(i)));
		}


		pairs.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.task - o2.task;
			}
		});

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int start = 0;
		int end = tasks.size() - 1;

		while (k > 0 && start < end) {

			if (start == end) {
				res.add(new ArrayList<>(Arrays.asList(pairs.get(start).idx)));
			} else {
				res.add(new ArrayList<>(Arrays.asList(pairs.get(start).idx, pairs.get(end).idx )));
			}

			start++;
			end--;

			k--;
		}




		return res;
	}

	public static void main(String[] args) {
		taskAssignment(3, new ArrayList<>(Arrays.asList(1,3,5,3,1,4)));
	}
}
