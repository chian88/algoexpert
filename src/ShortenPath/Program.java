package ShortenPath;

import java.util.*;
import java.util.stream.Collectors;

class Program {
	public static String shortenPath(String path) {
		// Write your code here;
		Deque<String> stack = new ArrayDeque<>();
		StringBuilder result = new StringBuilder();

		boolean absolute = false;

		if (path.startsWith("/")) {
			absolute = true;
		}

		String[] paths = path.split("/");
		for (int i = 0; i < paths.length; i++) {
			String str = paths[i];
			if (str.length() == 0) {
				continue;
			} else if (str.equals("..") && absolute) {
				stack.pollFirst();
			} else if (str.equals("..") && !absolute) {
				if (stack.isEmpty() || stack.peekFirst().equals("..")) {
					stack.addFirst(str);
				} else {
					stack.pollFirst();
				}

			}else if (!str.equals(".")) {
				stack.addFirst(str);
			}

		}

		while (!stack.isEmpty()) {
			result.insert(0, "/" + stack.pollFirst());
		}

		if (!absolute) {
			result.delete(0, 1);
		}

		if (absolute && result.length() == 0) {
			result.append("/");
		}


		return result.toString();
	}

	public static void main(String[] args) {
		shortenPath("../../foo/bar/baz");
	}
}
