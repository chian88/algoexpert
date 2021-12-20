package InterweavingString;

import java.util.*;

class Program {
	public static boolean interweavingStrings(String one, String two, String three) {
		// Write your code here.
		return interweavingStringsHelper(one, two, three, 0, 0, 0);
	}

	public static boolean interweavingStringsHelper(String one, String two, String three, int ptr1, int ptr2, int ptr3) {
		// Write your code here.
		if (one.length() == ptr1 && two.length() == ptr2 && three.length() == ptr3) return true;

		if (three.length()  == ptr3) return false;

		if (ptr1 < one.length() && one.charAt(ptr1) == three.charAt(ptr3)) {
			if (interweavingStringsHelper(one, two, three, ptr1 + 1, ptr2, ptr3 + 1)) return true;
		}

		if (ptr2 < two.length() && two.charAt(ptr2) == three.charAt(ptr3)) {
			if(interweavingStringsHelper(one, two, three, ptr1, ptr2 + 1, ptr3 + 1)) return true;
		}

		return false;
	}

	public static void main(String[] args) {
		interweavingStrings("aaa", "aaaf", "aaafaaa");
	}
}
