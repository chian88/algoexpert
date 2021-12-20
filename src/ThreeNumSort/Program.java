package ThreeNumSort;

import java.util.*;

class Program {
    public static int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.

        int firstIdx = 0;
        int firstElement = order[0];
        int lastIdx = array.length - 1;
        int lastElement = order[2];

        for (int i = 0 ; i < array.length; i++) {
            if (array[i] == firstElement) {
                array[i] = array[firstIdx];
                array[firstIdx] = firstElement;
                firstIdx++;
            }
        }

        for (int j = array.length - 1; j >= 0; j--) {
            if (array[j] == lastElement) {
                array[j] = array[lastIdx];
                array[lastIdx] = lastElement;
                lastIdx--;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] result = Program.threeNumberSort(new int[]{1,0,0,-1,-1,0,1,1}, new int[]{0,1,-1});

        for (int i : result) {
            System.out.println(i);
        }
    }
}
