package PalindromeCheck;

public class Program {

    public static boolean isPalindrome(String str) {
        // Write your code here
        int medianIdx = str.length() / 2;
        for (int i = 0; i < medianIdx; i++) {
            char front = str.charAt(i);
            char back = str.charAt(str.length() - i - 1);

            if (front != back) return false;
        }

        return true;
    }
}
