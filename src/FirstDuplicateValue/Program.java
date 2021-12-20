package FirstDuplicateValue;

import java.util.*;

class Program {

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        int[] count = new int[array.length];
        Arrays.fill(count, 0);

        for (int n : array) {
            count[n-1] += 1;
            if(count[n-1] > 1) return n;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 2, 3, 3, 4};
        firstDuplicateValue(arr);
    }
}
