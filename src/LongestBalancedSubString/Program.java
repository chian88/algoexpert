package LongestBalancedSubString;

import java.util.*;

class Program {
	public static int longestBalancedSubstring(String string) {
		// Write your code here.

		Deque<Integer> stackIdx = new ArrayDeque<>();

		stackIdx.addFirst(-1);
		int maxBalanced = Integer.MIN_VALUE;

		for (int i=0; i<string.length(); i++) {
			char current = string.charAt(i);

			if (current == '(') {
				stackIdx.addFirst(i);
			} else if (current == ')') {
				stackIdx.removeFirst();

				if (!stackIdx.isEmpty()) {
					int prevIdx = stackIdx.peekFirst();

					if (i - prevIdx > maxBalanced) {
						maxBalanced = i - prevIdx ;
					}
				} else {
					stackIdx.addFirst(i);
				}
			}
		}

		return maxBalanced == Integer.MIN_VALUE ? 0 : maxBalanced;
	}

	public static void main(String[] args) {
		longestBalancedSubstring("(()))()");
	}
}
