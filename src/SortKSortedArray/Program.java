package SortKSortedArray;

import java.lang.reflect.Array;
import java.util.*;

class Program {

    public static int[] sortKSortedArray(int[] array, int k) {
        // Write your code here.
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] res = new int[array.length];

        for (int i = 0; i <= k; i++) {
            if (i < array.length) heap.add(array[i]);

        }

        int pointer = 0;

        while (pointer < array.length) {
            res[pointer] = heap.poll();

            pointer++;

            if (pointer + k < array.length) {
                heap.add(array[pointer + k]);
            }

        }



        return res;
    }

    public static void main(String[] args) {
        sortKSortedArray(new int[]{-1, -3, -4, 2, 1, 3}, 2);
    }
}
