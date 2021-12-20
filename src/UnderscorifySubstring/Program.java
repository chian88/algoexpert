package UnderscorifySubstring;

import java.util.*;

class Program {
	public static String underscorifySubstring(String str, String substring) {
		// Write your code here.
		List<Integer[]> indices = new ArrayList<>();

		for (int i = 0; i <= str.length() - substring.length(); i++) {
			String potentialRes = str.substring(i, i + substring.length());

			if (potentialRes.equals(substring)) {
				indices.add(new Integer[]{i, i + substring.length() - 1});
			}
		}

		List<Integer[]> collapsedIndices = reduceIndices(indices);

		StringBuilder res = new StringBuilder(str);

		int offset = 0;

		for (Integer[] idx : collapsedIndices) {
			int start = idx[0];
			int finish = idx[1];

			res.insert(offset+ start, '_');
			res.insert(offset+finish + 2, '_');

			offset+= 2;
		}



		return res.toString();
	}

	private static List<Integer[]> reduceIndices(List<Integer[]> indices) {
		List<Integer[]> res = new ArrayList<>();

		if (indices.isEmpty()) return res;
		int startSoFar = indices.get(0)[0];
		int endSoFar = indices.get(0)[1];

		for (int i = 1; i < indices.size(); i++) {
			Integer[] index = indices.get(i);

			if (index[0] <= endSoFar + 1) {
				endSoFar = index[1];
			} else {
				res.add(new Integer[]{startSoFar, endSoFar});
				startSoFar = index[0];
				endSoFar = index[1];
			}
		}

		res.add(new Integer[]{startSoFar, endSoFar});

		return res;
	}

	public static void main(String[] args) {
		underscorifySubstring("this is a test to see if it works and test", "bfjawkfja");
	}
}
