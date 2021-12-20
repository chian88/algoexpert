package InsertionSort;

import java.util.*;

class Program {
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        int sortedPointer = 0;

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int k = sortedPointer;
            while (k >= 0) {
                if (current <= array[k]) {
                    int temp = array[k];
                    array[k] = current;
                    array[k+1] = temp;
                } else {
                    break;
                }

                k--;
            }
            sortedPointer ++;
        }

        return array;
    }

}
