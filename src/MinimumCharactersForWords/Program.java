package MinimumCharactersForWords;

import java.util.*;

class Program {

	public static char[] minimumCharactersForWords(String[] words) {
		// Write your code here.
		Map<Character, Integer> mainCounter = new HashMap<>();

		for (String word : words) {
			Map<Character, Integer> wordCounter = new HashMap<>();
			for (char c : word.toCharArray()) {
				wordCounter.putIfAbsent(c, 0);
				wordCounter.put(c, wordCounter.get(c) + 1);

				mainCounter.putIfAbsent(c, 0);
				if (wordCounter.get(c) > mainCounter.get(c)) {
					mainCounter.put(c, wordCounter.get(c));
				}
			}
		}
		Collection<Integer> numbers = (Collection<Integer>) mainCounter.values();
		int size = 0;
		for (int n : numbers) {
			size += n;
		}

		char[] res = new char[size];
		int ptr = 0;

		for (Map.Entry<Character, Integer> entry : mainCounter.entrySet()) {
			char c = entry.getKey();

			int count = entry.getValue();

			while (count > 0) {
				res[ptr++] = c;
				count--;
			}
		}

		return res;
	}


	public static void main(String[] args) {
		minimumCharactersForWords(new String[]{"this", "that", "did", "deed", "them!", "a"});
	}
}
