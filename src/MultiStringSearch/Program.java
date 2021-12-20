package MultiStringSearch;

import java.util.*;


class TrieNode {
	Character val;
	Map<Character, TrieNode> children;
	Integer idx;

	TrieNode (Character val) {
		this.val = val;
		this.children = new HashMap<>();
	}
}

class Program {
	static TrieNode root;

	public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
		// Write your code here.
		root = new TrieNode(null);
		List<Boolean> res = new ArrayList<>();


		for (int i = 0; i < smallStrings.length; i++) {
			TrieNode node = root;
			res.add(false);
			for (char c : smallStrings[i].toCharArray()) {
				if (!node.children.containsKey(c)) {
					node.children.put(c, new TrieNode(c));
				}

				node = node.children.get(c);
			}
			node.idx = i;
		}

		for (int i = 0; i < bigString.length(); i++) {
			if (root.children.containsKey(bigString.charAt(i))) {
				TrieNode node = root;

				int currIdx = i;

				while (currIdx < bigString.length() &&
						node.children.containsKey(bigString.charAt(currIdx)) ) {

					node = node.children.get(bigString.charAt(currIdx));
					currIdx++;

					if (node.idx != null) {
						res.set(node.idx, true);
					}
				}
			}
		}




		return res;
	}

	public static void main(String[] args) {
		Program.multiStringSearch("this is a big string", new String[]{"this", "yo", "is", "a","bigger", "string", "kappa"});

	}


}
