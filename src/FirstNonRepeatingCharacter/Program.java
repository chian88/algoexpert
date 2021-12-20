package FirstNonRepeatingCharacter;

import java.util.*;

class Program {

    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> counter = new HashMap<>();

        for (char c : string.toCharArray()) {
            if (counter.containsKey(c)) {
                counter.put(c, counter.get(c) + 1);
            } else {
                counter.put(c, 1);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (counter.get(c) == 1) return i;
        }

        return -1;
    }
}
