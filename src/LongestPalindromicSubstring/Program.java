package LongestPalindromicSubstring;

import java.util.*;

class Program {
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.

        int longestPalindromeLen = Integer.MIN_VALUE;
        String longestPalindrome = "";

        for (int i = 0 ; i < str.length(); i++) {
            String palindrome = findPalindrome(str, true, i);

            if (palindrome.length() > longestPalindromeLen) {
                longestPalindrome = palindrome;
                longestPalindromeLen = palindrome.length();
            }

            palindrome = findPalindrome(str, false, i);

            if (palindrome.length() > longestPalindromeLen) {
                longestPalindrome = palindrome;
                longestPalindromeLen = palindrome.length();
            }

        }


        return longestPalindrome;
    }

    public static String findPalindrome(String str, boolean odd, int start) {
        String palindrome = "";
        if (odd == true) {
            int left = start - 1;
            int right = start + 1;
            palindrome += str.charAt(start);
            while (left >= 0 && right < str.length()) {
                if (str.charAt(left) != str.charAt(right)) {
                    return palindrome;
                }
                palindrome = str.charAt(left) + palindrome + str.charAt(right);
                left--;
                right++;
            }
        } else {
            int left = start - 1;
            int right = start;
            while (left >= 0 && right < str.length()) {
                if (str.charAt(left) != str.charAt(right)) {
                    return palindrome;
                }
                palindrome = str.charAt(left) + palindrome + str.charAt(right);
                left--;
                right++;
            }
        }

        return palindrome;
    }

    public static void main(String[] args) {
        String ans = longestPalindromicSubstring("abaxyzzyxf");
    }
}
