package ShiftedBinarySearch;

import java.util.*;

class Program {
    public static int shiftedBinarySearch(int[] array, int target) {
        // Write your code here.

        int ans =  shiftedBinarySearchHelper(array, target, 0, array.length - 1);
        return ans;
    }

    static int shiftedBinarySearchHelper(int[] array, int target, int leftPtr, int rightPtr) {
        int middlePtr = (int) Math.floor((leftPtr + rightPtr) / 2);

        if (array[middlePtr] == target) return middlePtr;
        if (leftPtr == rightPtr) return -1;

        if (array[leftPtr]  <= array[middlePtr]) {
            // left is sorted.

            if (target < array[middlePtr] && target >= array[leftPtr]) {
                // go left
                return shiftedBinarySearchHelper(array, target, leftPtr, middlePtr-1);
            } else {
                /// go right
                return shiftedBinarySearchHelper(array, target, middlePtr+1, rightPtr);
            }
        } else {
            // right is sorted.

            if (target > array[middlePtr] && target <= array[rightPtr]) {
                // go right
                return shiftedBinarySearchHelper(array, target, middlePtr+1, rightPtr);
            } else {
                // left
                return shiftedBinarySearchHelper(array, target, leftPtr, middlePtr-1);
            }
        }
    }

    public static void main(String[] args) {
        shiftedBinarySearch(new int[] {45, 61, 71, 72, 73, 0, 1, 21, 33, 37}, 33);
    }
}
