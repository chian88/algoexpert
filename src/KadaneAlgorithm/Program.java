package KadaneAlgorithm;

import java.util.*;

class Program {
	public static int kadanesAlgorithm(int[] array) {
		// Write your code here.

		int max = array[0];
		int maxSoFar = array[0];
		for (int i = 1; i < array.length; i++) {
			maxSoFar = Math.max(array[i], maxSoFar + array[i]);

			if (maxSoFar > max) {
				max = maxSoFar;
			}
		}

		return max;
	}
}
