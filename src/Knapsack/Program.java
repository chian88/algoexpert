package Knapsack;
import java.util.*;


class Program {
	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		// Write your code here.
		// Replace the code below.
		int[][] dp = new int[items.length + 1][capacity + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], - 1);
		}
		knapsackProblemHelper(items, capacity, items.length, dp);

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> score = Arrays.asList(dp[items.length][capacity]);
		List<Integer> itemsLoc = new ArrayList<>();

		int i = items.length;
		int j = capacity;
		while(i > 0 && j > 0) {
			if (dp[i][j] != dp[i - 1][j]) {
				itemsLoc.add(i - 1);
				j = j - items[i - 1][1];

			}
			i = i - 1;
		}

		result.add(score);
		result.add(itemsLoc);


		return result;
	}

	static int knapsackProblemHelper(int[][] items, int currentCapacity, int itemIdx, int[][] dp) {
		if (currentCapacity == 0) {
			dp[itemIdx][currentCapacity] = 0;
			return 0;
		}
		if (itemIdx == 0) {
			dp[itemIdx][currentCapacity] = 0;
			return 0;
		}

		int[] item = items[itemIdx - 1];

		if (item[1] <= currentCapacity) {
			int withoutCurrentItem = dp[itemIdx - 1][currentCapacity];
			if (withoutCurrentItem == -1) {
				withoutCurrentItem = knapsackProblemHelper(items, currentCapacity, itemIdx - 1, dp);
			}

			int withCurrentItemDp = dp[itemIdx - 1][currentCapacity - item[1]];

			if (withCurrentItemDp == -1) {
				withCurrentItemDp = knapsackProblemHelper(items, currentCapacity - item[1] , itemIdx - 1, dp);
			}
			int withCurrentItem = item[0] + withCurrentItemDp;
			dp[itemIdx][currentCapacity] = Math.max(withCurrentItem, withoutCurrentItem);
			return Math.max(withCurrentItem, withoutCurrentItem);
		} else {

			int withoutCurrentItem = dp[itemIdx - 1][currentCapacity];
			if (withoutCurrentItem == -1) {
				withoutCurrentItem = knapsackProblemHelper(items, currentCapacity, itemIdx - 1, dp);
			}

			dp[itemIdx][currentCapacity] = withoutCurrentItem;
			return withoutCurrentItem;
		}
	}
	public static void main(String[] args) {
		int[][] items = new int[][]{{1,2}, {4,3}, {5,6}, {6,7}};

		knapsackProblem(items, 10);
	}
}



//class Program {
//	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
//		// Write your code here.
//		// Replace the code below.
//		int[][] dp = new int[items.length + 1][capacity + 1];
//
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[i].length; j++) {
//				if (i == 0 || j == 0) {
//					dp[i][j] = 0;
//					continue;
//				}
//				int[] item = items[i - 1];
//				if (item[1] <= j) {
//					dp[i][j] = Math.max(item[0] + dp[i - 1][j - item[1]], dp[i - 1][j]);
//				} else {
//					dp[i][j] = dp[i - 1][j];
//				}
//			}
//		}
//		List<List<Integer>> result = new ArrayList<>();
//
//		List<Integer> score = Arrays.asList(dp[items.length][capacity]);
//		List<Integer> itemsLoc = new ArrayList<>();
//
//		int i = items.length;
//		int j = capacity;
//		while(i > 0 && j > 0) {
//			if (dp[i][j] != dp[i - 1][j]) {
//				itemsLoc.add(i - 1);
//				j = j - items[i - 1][1];
//
//			}
//			i = i - 1;
//		}
//
//		result.add(score);
//		result.add(itemsLoc);
//
//
//		return result;
//	}
//
//	public static void main(String[] args) {
//		int[][] items = new int[][]{{1,2}, {4,3}, {5,6}, {6,7}};
//
//		knapsackProblem(items, 10);
//	}
//}
