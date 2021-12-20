package PalindromePartioningMinCut;

import java.util.*;

class Program {
    public static int palindromePartitioningMinCuts(String str) {
        // Write your code here.
        boolean structure[][] = new boolean[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            for ( int j = i; j < str.length(); j++) {
                structure[i][j] = isPalindrome(str.substring(i, j+1));
            }
        }

        int[] minCut = new int[str.length()];
        Arrays.fill(minCut, Integer.MAX_VALUE);

        for (int i = 0; i < minCut.length; i++) {
            // if current substring from 0 to i is a palindrome, if yes, then put minCut 0 and move on

            if(structure[0][i] == true) {
                minCut[i] = 0;
            } else {
                // tentati
                int minimum = minCut[i-1] + 1;

                for (int j = 1 ; j < i; j++) {
                    if(structure[j][i] == true && (minCut[j-1] + 1) < minimum ) {
                        minimum = (minCut[j-1] + 1);
                    }
                }

                minCut[i] = minimum;
            }
        }

        return minCut[str.length() - 1];
    }

    public static boolean isPalindrome(String str) {
        for(int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "noonabbad";

        palindromePartitioningMinCuts(str);
    }
}
