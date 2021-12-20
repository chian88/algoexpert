package MergedSortedArray;

import java.lang.module.ResolutionException;
import java.util.*;

class Program {
	public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
		// Write your code here.
		PriorityQueue<HeapNode> heap = new PriorityQueue<HeapNode>((a, b) -> {
			return Integer.compare(a.array.get(a.ptr), b.array.get(b.ptr));
		});

		for (List<Integer> array : arrays) {
			heap.add(new HeapNode(array, 0));
		}

		List<Integer> res = new ArrayList<>();


		while (!heap.isEmpty()) {
			HeapNode least = heap.poll();
			res.add(least.array.get(least.ptr));

			least.ptr++;

			if (least.ptr < least.array.size()) {
				heap.add(least);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Program test = new Program();
		List<List<Integer>> arrays = new ArrayList<>();
		arrays.add(Arrays.asList(1,5,9,21));
		arrays.add(Arrays.asList(-1, 0));
		arrays.add(Arrays.asList(-124, 81, 121));
		arrays.add(Arrays.asList(3,6,12,20,150));
		Program.mergeSortedArrays(arrays);
	}
}


class HeapNode {
	List<Integer> array;
	int ptr;

	HeapNode(List<Integer> array, int ptr) {
		this.array = array;
		this.ptr = ptr;
	}
}