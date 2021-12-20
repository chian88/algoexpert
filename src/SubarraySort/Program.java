package SubarraySort;

import java.util.*;

class Program {
    public static int[] subarraySort(int[] array) {
        // Write your code here.


        boolean[] sorted = buildSorted(array);

        int minUnsorted = Integer.MAX_VALUE;
        int maxUnsorted = Integer.MIN_VALUE;

        for (int i = 0 ; i < array.length; i++) {
            if (sorted[i] == false && array[i] < minUnsorted) {
                minUnsorted = array[i];
            }


            if (sorted[i] == false && array[i] > maxUnsorted) {
                maxUnsorted = array[i];
            }
        }

        int minIdx = -1;
        int maxIdx = -1;
        for (int i = 0; i < array.length; i++) {
            if (sorted[i] && minUnsorted < array[i]) {
                minIdx = i;
                break;
            } else if (!sorted[i]) {
                minIdx = i;
                break;
            }
        }

        for (int j = array.length-1; j >=0 ; j--) {
            if (sorted[j] && maxUnsorted > array[j]) {
                maxIdx = j;
                break;
            } else if (!sorted[j]) {
                maxIdx = j;
                break;
            }
        }

        return new int[] {minIdx, maxIdx};
    }

    static boolean[] buildSorted(int[] array) {
        boolean[] sorted = new boolean[array.length];
        Arrays.fill(sorted, false);

        for (int i = 0; i < array.length; i++) {
            int left = i - 1;
            int right = i + 1;
            boolean leftSorted = true;

            if (left >= 0 && array[left] > array[i]) {
                leftSorted = false;
            }

            boolean rightSorted = true;

            if (right < array.length && array[right] < array[i]) {
                rightSorted = false;
            }

            if (leftSorted && rightSorted) {
                sorted[i] = true;
            }
        }

        return sorted;

    }

    public static void main(String[] args) {
        subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 18, 19});
    }
}
