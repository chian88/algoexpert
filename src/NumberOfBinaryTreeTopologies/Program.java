package NumberOfBinaryTreeTopologies;
import java.util.*;
class Program {
	public static int numberOfBinaryTreeTopologies(int n) {
		// Write your code here.
		return numberOfBinaryTreeTopologiesHelper(n, new HashMap<>());
	}

	static int numberOfBinaryTreeTopologiesHelper(int n, Map<Integer, Integer> memo) {
		if (n == 0 || n == 1) return 1;

		int nSum = 0;

		for (int left = 0; left < n; left++) {
			int right = n - 1 - left;
			int leftSum;
			if (memo.containsKey(left)) {
				leftSum = memo.get(left);
			} else {
				leftSum = numberOfBinaryTreeTopologiesHelper(left, memo);
			}

			int rightSum;
			if (memo.containsKey(right)) {
				rightSum = memo.get(right);
			} else {
				rightSum = numberOfBinaryTreeTopologiesHelper(right, memo);
			}

			nSum += (leftSum * rightSum);
		}

		memo.put(n, nSum);

		return nSum;
	}

	public static void main(String[] args) {
		System.out.println(numberOfBinaryTreeTopologies(3));
	}
}
