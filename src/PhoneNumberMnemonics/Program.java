package PhoneNumberMnemonics;

import java.util.*;

class Program {

	private static final Map<Integer, Character[]> numberPad = new HashMap<>() {{
		 put(2, new Character[]{'a', 'b', 'c'});
		put(3, new Character[]{'d', 'e', 'f'});
		put(4, new Character[]{'g', 'h', 'i'});
		put(5, new Character[]{'j', 'k', 'l'});
		put(6, new Character[]{'m', 'n', 'o'});
		put(7, new Character[]{'p', 'q', 'r', 's'});
		put(8, new Character[]{'t', 'u', 'v'});
		put(9, new Character[]{'w', 'x', 'y', 'z'});

		}};

	public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
		// Write your code here.
		ArrayList<String> result = new ArrayList<>();
		phoneNumberMnemonicsHelper(phoneNumber, result, 0, new StringBuilder() );
		return result;
	}

	public static void phoneNumberMnemonicsHelper(String phoneNumber, ArrayList<String> result, int pointer, StringBuilder tempResult) {
		// Write your code here.
		if (pointer >= phoneNumber.length()) {
			result.add(tempResult.toString());
			tempResult.setLength(tempResult.length() - 1);
			return;
		}

		char current = phoneNumber.charAt(pointer);

		Character[] choices = numberPad.get(Integer.parseInt(String.valueOf(current)));

		if (choices == null) {
			// just 1 or 0
			tempResult.append(current);
			phoneNumberMnemonicsHelper(phoneNumber, result, pointer + 1, tempResult);
		} else {
			for (Character choice : choices) {
				tempResult.append(choice);
				phoneNumberMnemonicsHelper(phoneNumber, result, pointer + 1, tempResult);
			}
		}

		if(tempResult.length() > 0) tempResult.setLength(tempResult.length() - 1);
	}

	public static void main(String[] args) {
		System.out.println(phoneNumberMnemonics("1905"));
	}
}
