package GenerateDocument;

import java.util.*;

class Program {

    public static boolean generateDocument(String characters, String document) {
        // Write your code here.
        if (document.length() == 0) return true;

        HashMap<Character, Integer> countOfAlphabet = new HashMap<>();
        for (char alpha : characters.toCharArray()) {
            if (countOfAlphabet.containsKey(alpha)) {
                countOfAlphabet.put(alpha, countOfAlphabet.get(alpha) + 1);
            } else {
                countOfAlphabet.put(alpha, 1);
            }
        }

        for (char alpha : document.toCharArray()) {
            if (countOfAlphabet.containsKey(alpha)) {
                countOfAlphabet.put(alpha, countOfAlphabet.get(alpha) - 1);
                if (countOfAlphabet.get(alpha) < 0) return false;
            } else {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
       String character ="Bste!hetsi ogEAxpelrt x ";
       String document = "AlgoExpert is the Best!";

       Program.generateDocument(character, document);
    }
}
