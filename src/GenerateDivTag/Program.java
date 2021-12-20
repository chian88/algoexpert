package GenerateDivTag;

import java.util.*;

class Program {

	public static ArrayList<String> generateDivTags(int numberOfTags) {
		// Write your code here.
		ArrayList<String> result = new ArrayList<>();
		generateDivTagsHelper(numberOfTags, 0, result, "");
		return result;
	}

	public static void generateDivTagsHelper(int numberOfTags, int opened,
												   ArrayList<String> result, String temp) {
		// Write your code here.
		if (numberOfTags == 0 && opened == 0) {
			result.add(temp);
			return;
		}

		if (numberOfTags > 0 && opened > 0) {
			// can open new div , and close div.
			generateDivTagsHelper(numberOfTags - 1, opened + 1, result, temp + "<div>");
			generateDivTagsHelper(numberOfTags , opened -1, result, temp + "</div>");
		} else if (numberOfTags > 0) {
			// can open div only
			generateDivTagsHelper(numberOfTags - 1, opened + 1, result, temp + "<div>");
		} else {
			// can close div only.
			generateDivTagsHelper(numberOfTags , opened -1, result, temp + "</div>");
		}

		return;
	}

	public static void main(String[] args) {
		System.out.println(generateDivTags(3));
	}
}
