package NonConstructibleChange;

import java.util.*;

class Program {

	public static int nonConstructibleChange(int[] coins) {
		// Write your code here.
		int change = 0;
		Arrays.sort(coins);
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] > change + 1) {
				return change + 1;
			}
			change += coins[i];
		}


		return change+1;
	}

	public static void main(String[] args) {
		nonConstructibleChange(new int[]{5,7,1,1,2,3,22});
	}
}
