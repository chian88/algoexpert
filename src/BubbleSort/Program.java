package BubbleSort;

import java.util.*;

class Program {
    public static int[] bubbleSort(int[] array) {
        // Write your code here.

        boolean haveSwap = false;

        do {
            haveSwap = false;
            for (int i = 0; i < array.length - 1; i++) {
                int first = array[i];
                int second = array[i+1];

                if (first > second) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    haveSwap = true;
                }
            }
        } while (haveSwap);

        return array;
    }

    public static void main(String[] args) {
        int[] result = bubbleSort(new int[]{8,5,2,9,5,6,3});
        System.out.println(result);
    }
}
