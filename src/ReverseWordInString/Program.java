package ReverseWordInString;

import java.util.*;

class Program {

    public static String reverseWordsInString(String string) {
        // Write your code here.
        StringBuilder res = new StringBuilder();

       for (int mainPtr = string.length() - 1; mainPtr >= 0; mainPtr--) {
           char c = string.charAt(mainPtr);
           if (Character.isWhitespace(c)) {
               res.append(c);
           } else {
               int charPtr = mainPtr;
               int endPtr = mainPtr;
               while (charPtr >= 0 && !Character.isWhitespace(string.charAt(charPtr))) {
                   charPtr--;
               }
               charPtr += 1;
               mainPtr = charPtr;

               for(int j = charPtr; j <= endPtr; j ++) {
                   res.append(string.charAt(j));
               }
           }

       }


        return res.toString();
    }

    public static void main(String[] args) {
        reverseWordsInString("Tim is Great");
    }
}
