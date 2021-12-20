package SelectionSort;

import java.util.*;

class Program {
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        int sortedPointer = 0;

        while (sortedPointer < array.length) {
            int smallest = array[sortedPointer];
            int smallestIdx = sortedPointer;
            for (int i = sortedPointer ; i < array.length; i++) {
                if (array[i] < smallest) {
                    smallest = array[i];
                    smallestIdx = i;
                }
            }

            array[smallestIdx] = array[sortedPointer];
            array[sortedPointer] = smallest;


            sortedPointer++;
        }


        return array;
    }

    public static void main(String[] args) {
        selectionSort(new int[]{8,5,2,9,5,6,3});
    }
}
