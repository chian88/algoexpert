package SearchForRange;

import java.util.*;

class Program {
    public static int[] searchForRange(int[] array, int target) {
        // Write your code here.
        int left = searchForRangeLeft(array, target, 0);
        int right = searchForRangeRight(array, target, 0);
        return new int[] {left, right};
    }

    static int searchForRangeRight(int[] array, int target, int offset) {
        int medianIdx = array.length / 2;

        if (array.length == 1 && array[medianIdx] == target) return offset + medianIdx;
        if (array.length == 1) return -1;

        if (array[medianIdx] == target) {
            int rightPointer = medianIdx;

            while (rightPointer < array.length && array[rightPointer] == target) {
                rightPointer++;
            }

            return rightPointer - 1 + offset;
        } if (target < array[medianIdx]) {
            // go left
            int[] newArray = Arrays.copyOfRange(array, 0, medianIdx);


            return searchForRangeRight(newArray, target, 0);

        } else {
            // go right
            int[] newArray = Arrays.copyOfRange(array, medianIdx, array.length);

            return searchForRangeRight(newArray, target, medianIdx + offset);
        }
    }

    static int searchForRangeLeft(int[] array, int target, int offset) {
        int medianIdx = array.length / 2;

        if (array.length == 1 && array[medianIdx] == target) return offset + medianIdx;
        if (array.length == 1) return -1;

        if (array[medianIdx] == target) {
            int leftPointer = medianIdx;

            while (leftPointer >= 0 && array[leftPointer] == target) {
                leftPointer--;
            }

            return leftPointer + 1 + offset;
        } if (target < array[medianIdx]) {
            // go left
            int[] newArray = Arrays.copyOfRange(array, 0, medianIdx);


            return searchForRangeLeft(newArray, target, 0);

        } else {
            // go right
            int[] newArray = Arrays.copyOfRange(array, medianIdx, array.length);

            return searchForRangeLeft(newArray, target, medianIdx + offset);
        }
    }

    public static void main(String[] args) {
        // 34, 50 == 45
        searchForRange(new int[]{0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73}, 45);
    }
}
