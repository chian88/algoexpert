package BinarySearch;

import java.util.*;

class Program {
    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0);
    }

    public static int binarySearchHelper(int[] array, int target, int offset) {
        int medianIdx = array.length / 2;

        if(array[medianIdx] == target) {
            return medianIdx + offset;
        }
        
        if (array.length == 1) return -1;

        if (target < array[medianIdx]) {
            return binarySearchHelper(Arrays.copyOfRange(array, 0, medianIdx), target, offset);
        }
        
        return binarySearchHelper(Arrays.copyOfRange(array, medianIdx, array.length), target, offset+medianIdx);
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 61;


        //int[] arr = new int[]{5, 2};
        //int[] arr2 = Arrays.copyOfRange(arr, 0, 1) ;
        System.out.println(binarySearch(array, target));
    }
}
