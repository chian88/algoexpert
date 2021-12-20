package MergeSort;

import java.util.*;

class Program {
    public static int[] mergeSort(int[] array) {
        // Write your code here.

        return mergeSortHelper(array);
    }

    static int[] mergeSortHelper(int[] arr) {
        if (arr.length <= 1) return arr;

        int medianIdx = arr.length / 2;
        int[] firstHalf = Arrays.copyOfRange(arr, 0, medianIdx);
        int[] secondHalf = Arrays.copyOfRange(arr, medianIdx, arr.length);

        int[] sortedFirstHalf = mergeSortHelper(firstHalf);
        int[] sortedSecondHalf = mergeSortHelper(secondHalf);

        int[] result = new int[sortedFirstHalf.length + sortedSecondHalf.length];

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while (p1 < sortedFirstHalf.length && p2 < sortedSecondHalf.length) {
            if (sortedFirstHalf[p1] < sortedSecondHalf[p2]) {
                result[p3] = sortedFirstHalf[p1];
                p1++;
            } else {
                result[p3] = sortedSecondHalf[p2];
                p2++;
            }

            p3++;
        }

        if (p1 < sortedFirstHalf.length) {
            // sortedFirstHalf
            for (int i = p1; i < sortedFirstHalf.length; i++) {
                result[p3] = sortedFirstHalf[i];
                p3++;
            }
        } else if (p2 < sortedSecondHalf.length) {
            for (int i = p2; i < sortedSecondHalf.length; i++) {
                result[p3] = sortedSecondHalf[i];
                p3++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = mergeSort(new int[]{8,5,2,9,5,6,3});

        for (int k : result) {
            System.out.println(k);
        }
    }

}
