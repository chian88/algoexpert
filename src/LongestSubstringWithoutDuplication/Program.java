package LongestSubstringWithoutDuplication;

import java.util.*;

class Program {
	public static String longestSubstringWithoutDuplication(String str) {
		// Write your code here
		Map<Character, Integer> charPosition = new HashMap<>();

		String longestSubstring = "";

		StringBuilder currentSubString = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (charPosition.containsKey(c)) {
				if (currentSubString.length() > longestSubstring.length()) {
					longestSubstring = currentSubString.toString();

				}
				currentSubString.setLength(0);
				i = charPosition.get(c);
				charPosition.clear();

			} else {
				charPosition.put(c, i);
				currentSubString.append(c);
			}
		}

		if (currentSubString.length() > longestSubstring.length()) {
			longestSubstring = currentSubString.toString();
		}

		return longestSubstring;
	}

	public static void main(String[] args) {
		longestSubstringWithoutDuplication("abcdeabcdefc");
	}
}
