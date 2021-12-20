package KnuthMorrisPratt;

import java.util.*;

class Program {
	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
		// Write your code here.

		int[] subStringMemo = buildMemo(substring);

		int i = 0;
		int j = 0;

		while (i < string.length()) {
			if (j == substring.length()) return false;
			if (string.charAt(i) == substring.charAt(j)) {
				i++;
				j++;
			} else {
				if (j > 0){
					j = subStringMemo[j - 1] + 1;
				} else {
					i++;
				}

			}
		}

		return i == string.length() && j == substring.length();
	}

	static int[] buildMemo(String substring) {
		int[] subStringMemo = new int[substring.length()];

		Arrays.fill(subStringMemo, -1);

		int i = 0;
		int j = 1;

		while (j < substring.length()) {
			if (substring.charAt(i) == substring.charAt(j)) {
				subStringMemo[j] = i;
			} else {
				i = subStringMemo[j - 1] ;

				while (i != -1 && substring.charAt(i + 1) != substring.charAt(j)) {
					i = subStringMemo[i] ;
				}
				if (substring.charAt(i + 1) == substring.charAt(j)) {
					subStringMemo[j] = i + 1;
				}

			}

			i++;
			j++;

		}

		return subStringMemo;
	}

	public static void main(String[] args) {
		knuthMorrisPrattAlgorithm("testwafwafawfawfawfawfawfawfawfa", "fawfawfawfawfa");
	}
}
