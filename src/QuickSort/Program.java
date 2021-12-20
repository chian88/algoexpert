package QuickSort;

import java.util.*;

class Program {
    public static int[] quickSort(int[] array) {

        quickSortHelper(array, 0, array.length- 1);

        return array;
    }


    public static void quickSortHelper(int[] array, int startIdx, int endIdx) {

        if (startIdx >= endIdx) return;
        int pivotIdx = startIdx;
        int pivot = array[pivotIdx];
        int leftIdx = startIdx + 1;
        int rightIdx = endIdx;
        while (rightIdx >= leftIdx) {
            if (array[leftIdx] > pivot && array[rightIdx] < pivot) {
                // swap left and right., then increment leftidx, decrement rightidx

                int temp = array[leftIdx];
                array[leftIdx] = array[rightIdx];
                array[rightIdx] = temp;

                leftIdx++;
                rightIdx--;
            } else {

                if (array[leftIdx] <= pivot) {
                    // increment leftIdx
                    leftIdx++;
                }

                if (array[rightIdx] >= pivot) {
                    // decrement rightIdx
                    rightIdx--;
                }
            }
        }
        array[pivotIdx] = array[rightIdx];
        array[rightIdx] = pivot;

        // left subArray
        quickSortHelper(array, startIdx, rightIdx-1);

        // right subArray
        quickSortHelper(array, rightIdx+1, endIdx );
    }

    public static void main(String[] args) {
        int[] arr = quickSort(new int[]{8,5,2,9,5,6,3});

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
