package Quickselect;

import java.util.*;

class Program {
    public static int quickselect(int[] array, int k) {
        // Write your code here.
        int ans = quickselectHelper(array,k , 0, array.length - 1);


        return ans;
    }

    static int quickselectHelper(int[] array, int k, int startIdx, int endIdx) {

        int pivotIdx = startIdx;
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;

        if (pivotIdx == rightIdx && (leftIdx + 1 == k)) return array[leftIdx];

        while (leftIdx <= rightIdx) {
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                // swap
                swap(array, leftIdx, rightIdx);
            } else if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            } else if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }

        swap(array,pivotIdx, rightIdx);

        if (k == rightIdx + 1) {
            return array[rightIdx];
        } else if (k < rightIdx + 1) {
            return quickselectHelper(array,k , startIdx, rightIdx - 1);
        } else {
            return quickselectHelper(array, k , rightIdx + 1, endIdx);
        }
    }

    static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }

    public static void main(String[] args) {
        quickselect(new int[]{43,24,37}, 2);
    }
}
