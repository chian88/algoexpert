package SmallestSubstringContaining;

import java.util.*;

class Program {
	public static String smallestSubstringContaining(String bigString, String smallString) {
		// Write your code here.
		int left = 0;
		int right = 0;

		String res = "";
		int minimumSubStrLen = Integer.MAX_VALUE;


		Map<Character, Integer> smallCharCount = new HashMap<>();
		Map<Character, Integer> bigCharCount = new HashMap<>();

		for (char c : smallString.toCharArray()) {
			smallCharCount.putIfAbsent(c, 0);
			smallCharCount.put(c, smallCharCount.get(c) + 1);
		}

		boolean rightTurn = true;

		while (right < bigString.length() && left <= right) {
			// additions
			if (rightTurn) {
				char currentC = bigString.charAt(right);

				if (smallCharCount.containsKey(currentC)) {
					bigCharCount.putIfAbsent(currentC, 0);
					bigCharCount.put(currentC, bigCharCount.get(currentC) + 1);
				}

			} else {
				// deletions
				char currentC = bigString.charAt(left);

				if (bigCharCount.containsKey(currentC)) {
					bigCharCount.put(currentC, bigCharCount.get(currentC) - 1);
				}
				left++;


			}
			if (satisfySubstring(bigCharCount, smallCharCount)) {
				if ((right + 1 - left) < minimumSubStrLen) {
					res = bigString.substring(left, right + 1);
					minimumSubStrLen = res.length();
				}
				rightTurn = false;
			} else {
				right++;
				rightTurn = true;
			}
		}
		return res;
	}

	private static boolean satisfySubstring(Map<Character, Integer> bigCharCount,
											Map<Character, Integer> smallCharCount) {
		for (Map.Entry<Character, Integer> entry : smallCharCount.entrySet()) {
			if (  (bigCharCount.get(entry.getKey()) == null) ||
					entry.getValue() > bigCharCount.get(entry.getKey())) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(smallestSubstringContaining("145624356128828193236336541277356789901", "123"));
		// suppose 1932
		// getting 35612
	}
}
