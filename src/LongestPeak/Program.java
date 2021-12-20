package LongestPeak;

public class Program {
    public static int longestPeak(int[] array) {
        // Write your code here.
        int streak = 0;
        int maxStreak = 0;
        boolean first = true;
        for (int i = 1; i < array.length - 1; i++) {
            boolean hitPeak = false;
            int leftIndex = i - 1;
            int rightIndex = i + 1;

            if (array[leftIndex] < array[i] && array[rightIndex] < array[i]) {
                hitPeak = true;
                streak = 1;
            }

            if (hitPeak) {
                while (leftIndex >= 0 &&
                        array[leftIndex] < array[leftIndex + 1]) {
                    streak++;
                    leftIndex--;

                }

                while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
                    rightIndex++;
                    streak++;
                }
            }

            if (streak > maxStreak) {
                maxStreak = streak;
            }
        }


        return maxStreak;
    }
}
