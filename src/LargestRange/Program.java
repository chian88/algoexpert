package LargestRange;

import java.util.*;

class Program {
    public static int[] largestRange(int[] array) {
        // Write your code here.
        Map<Integer, Boolean> hash = new HashMap<>();
        List<int[]> ranges = new ArrayList<>();

        for (int num : array) {
            hash.put(num, false);
        }

        for (int i = 0; i < array.length; i++) {

            if (hash.get(array[i])) continue;

            int left = array[i];
            int right = array[i];

            while (hash.containsKey(left)) {
                hash.put(left, true);
                left--;
            }

            while (hash.containsKey(right)) {
                hash.put(right, true);
                right++;
            }

            ranges.add(new int[]{left + 1, right - 1});
        }

        int maxRange = Integer.MIN_VALUE;
        int[] selectedRange = new int[]{};

        for (int[] range : ranges) {
            int current = range[1] - range[0];
            if(current > maxRange) {
                maxRange = current;
                selectedRange = range;
            }

        }


        return selectedRange;
    }

    public static void main(String[] args) {
        largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
    }
}
