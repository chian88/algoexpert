package RunLengthEncoding;

public class Program {
    public static String runLengthEncoding(String string) {
        // Write your code here.

        Integer runningCount = 0;
        char previousChar = string.charAt(0);
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);



            if (currentChar != previousChar || runningCount >= 9) {

                result += runningCount.toString() + previousChar;
                previousChar = currentChar;
                runningCount = 0;
            }

            runningCount += 1;

        }

        result += runningCount.toString() + string.charAt(string.length() - 1);




        return result;
    }

    public static void main(String[] args) {
        String word = "........______=========AAAA   AAABBBB   BBB";

        runLengthEncoding(word);
    }
}
