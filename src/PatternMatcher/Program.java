package PatternMatcher;

import java.util.*;

class Program {
	public static String[] patternMatcher(String pattern, String str) {
		// Write your code here.
		boolean reverse = false;
		if (pattern.startsWith("y")) {
			reverse = true;
			StringBuilder temp = new StringBuilder();
			for (char c : pattern.toCharArray()) {
				if (c == 'x') {
					temp.append('y');
				} else {
					temp.append('x');
				}
			}
			pattern = temp.toString();
		}
		Map<Character, Integer> counter = new HashMap<>();
		int firstPosY = -1;

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			counter.putIfAbsent(c, 0);
			counter.put(c, counter.get(c) + 1);

			if (c == 'y' && firstPosY == -1) {
				firstPosY = i;
			}
		}


		int lenX = 1;
		double lenY = 0.0;
		int strLen = str.length();
		if (counter.containsKey('y') ) {

			while (lenX < strLen / counter.get('x')) {

				lenY = (strLen - (lenX * counter.get('x'))) / (counter.get('y') * 1.0);

				if (lenY != (int) lenY) {
					lenX++;
					continue;
				}

				String strX = str.substring(0, 0 + lenX);
				String strY = str.substring((firstPosY * lenX), (firstPosY * lenX) + (int) lenY);
				StringBuilder res = new StringBuilder();
				for (int i = 0; i < pattern.length(); i++) {
					char c = pattern.charAt(i);

					if (c == 'x') {
						res.append(strX);
					} else {
						res.append(strY);
					}
				}

				if (res.toString().equals(str)) {
					if (reverse) {
						return new String[]{strY, strX};
					}
					return new String[]{strX, strY};
				}

				lenX++;
			}


		} else {
			lenX = strLen / counter.get('x');
			String strX = str.substring(0, 0 + lenX);
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < pattern.length(); i++) {
				char c = pattern.charAt(i);

				if (c == 'x') {
					res.append(strX);
				}
			}

			if (res.toString().equals(str)) {
				if (reverse) {
					return new String[]{"", strX};
				}
				return new String[]{strX, ""};
			}

		}



		return new String[] {};
	}

	public static void main(String[] args) {
		patternMatcher("yyyy", "testtesttesttest");
	}
}
