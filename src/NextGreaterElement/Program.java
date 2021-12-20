package NextGreaterElement;

import java.util.*;

class Program {

	public static int[] nextGreaterElement(int[] array) {
		// Write your code here.

		Deque<Integer> stack = new ArrayDeque<>();

		int[] result = new int[array.length];

		Arrays.fill(result, -1);

		for (int i = 0; i < (2 * array.length); i++) {
			int k = i % array.length;

			while (stack.peekFirst() != null &&
					array[stack.peekFirst()] < array[k] ) {
				result[stack.removeFirst()] = array[k];
			}

			stack.addFirst(k);
		}

		return result;
	}

	public static void main(String[] args) {
		nextGreaterElement(new int[]{2,5,-3,-4, 6,7,2});
	}
}
