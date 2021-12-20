package BalancedBracket;

import java.util.*;


class Program {
    public static boolean balancedBrackets(String str) {
        // Write your code here.

        Deque<Character> brackets = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                brackets.addFirst(c);
            } else if (c == ')') {
                if (brackets.isEmpty()) return false;
                char openingBracket = brackets.removeFirst();
                if (openingBracket != '(') return false;
            } else if (c == ']' ) {
                if (brackets.isEmpty()) return false;
                char openingBracket = brackets.removeFirst();
                if (openingBracket != '[') return false;
            } else if (c == '}') {
                if (brackets.isEmpty()) return false;
                char openingBracket = brackets.removeFirst();
                if (openingBracket != '{') return false;
            }
        }
        return brackets.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        balancedBrackets("(141[])(){waga}((51afaw))()hh()");
    }
}
