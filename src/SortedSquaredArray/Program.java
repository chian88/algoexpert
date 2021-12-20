package SortedSquaredArray;

import java.util.*;

class Program {

    public static int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int left = 0;
        int right = array.length - 1;
        LinkedList<Integer> stack = new LinkedList<>();


        while (left <= right) {
            if (Math.abs(array[left]) > Math.abs(array[right])) {

                Double ele = Math.pow(array[left], 2);
                stack.addFirst(ele.intValue());
                left++;
            } else {
                Double ele = Math.pow(array[right], 2);
                stack.addFirst(ele.intValue());
                right--;
            }
        }

        int[] result = new int[array.length];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }


        return result;
    }

    public static void main(String[] args) {
        sortedSquaredArray(new int[]{1,2,3,5,6,8,9});
    }
}
