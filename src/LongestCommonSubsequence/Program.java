package LongestCommonSubsequence;
import java.util.*;

public class Program {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        String[][] structure = new String[str1.length() + 1][ str2.length() + 1];
        List<Character> ans = new ArrayList<Character>();

        for (int i = 0 ; i < str1.length() + 1; i++) {
            structure[i][0] = "";
        }

        for (int j = 0; j < str2.length() + 1; j++) {
            structure[0][j] = "";
        }

        for( int i = 1; i < str1.length() + 1; i++ ) {
            char char1 = str1.charAt(i-1);
            for(int j = 1; j < str2.length() + 1 ; j++) {
                char char2 = str2.charAt(j-1);
                if(char1 == char2) {
                    char[] diagonal = structure[i-1][j-1].toCharArray();
                    structure[i][j] = String.valueOf(diagonal) + char1;
                } else {
                    char[] left = structure[i][j-1].toCharArray();
                    char[] top = structure[i-1][j].toCharArray();

                    if(left.length > top.length) {
                        structure[i][j] = String.valueOf(left);
                    } else {
                        structure[i][j] = String.valueOf(top);
                    }
                }
            }
        }

        String answer = structure[str1.length()][str2.length()];

        for (char c : answer.toCharArray()) {
            ans.add(c);
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";

        Program.longestCommonSubsequence(str1, str2);
    }
}
